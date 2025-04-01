package com.company.product.interactions.waits;

import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wait {
    private Target[] elements;

    private static final long TO_SECONDS = 1000;
    private static final long TO_MINUTES = TO_SECONDS *60;
    private static final long TO_MILISECONDS = 1;

    private Wait(Target[] elements)
    {
        this.elements = elements;
    }

    public static Wait until(Target ... elements)
    {
        return new Wait(elements);
    }

    public WaitUntil is(ElementStates... states)
    {
        return new WaitUntil(this.elements, states);
    }

    public class WaitUntil
    {
        private Target[] elements;

        private ElementStates[] states;

        private WaitUntil(Target[] elements, ElementStates[] states)
        {
            this.elements = elements;
            this.states = states;
        }

        public WaitUntilBe forNotMoreOf(long time)
        {
            return new WaitUntilBe(this.elements, this.states, time);
        }

        public class WaitUntilBe
        {
            private Target[] elements;
            private ElementStates[] states;
            private long time;

            private WaitUntilBe(Target[] elements, ElementStates[] states, long time)
            {
                this.elements = elements;
                this.states = states;
                this.time = time;
            }

            public WaitFor seconds()
            {
                this.time = this.time * Wait.TO_SECONDS;
                return WaitFor.situation(this.elements, this.states, this.time);
            }

            public WaitFor minutes()
            {
                this.time = this.time * Wait.TO_MINUTES;
                return WaitFor.situation(this.elements, this.states, this.time);
            }

            public WaitFor milliseconds()
            {
                this.time = this.time * Wait.TO_MILISECONDS;
                return WaitFor.situation(this.elements, this.states, this.time);
            }
        }
    }
}

class WaitFor /*extends Thread*/ implements Interaction
{
    private Target[] elements;
    private ElementStates[] states;
    private long milliseconds;

    public WaitFor(Target[] elements, ElementStates[] states, long milliseconds)
    {
        this.elements = elements;
        this.states = states;
        this.milliseconds = milliseconds;
    }

    public class ThreadWait extends Thread
    {
        private long milliseconds;
        private boolean stop;

        public ThreadWait(long milliseconds)
        {
            this.milliseconds = milliseconds;
        }

        @Override
        public void run()
        {
            this.stop = false;
            //System.err.println(new SimpleDateFormat("hh:mm:ss").format(new Date()))
            try {
                Thread.sleep(this.milliseconds);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //System.err.println(new SimpleDateFormat("hh:mm:ss").format(new Date()))
            this.stop = true;
        }

        public boolean isStop(){
            return this.stop;
        }
    }

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        Target element;
        List<Target> lstElements = Arrays.asList(this.elements);
        List<Target> lstFinalElements = new ArrayList<>(lstElements);

        //this.start()
        ThreadWait thread = new ThreadWait(this.milliseconds);
        thread.start();

        while ( !lstFinalElements.isEmpty() && !thread.isStop())
        {
            //System.err.println(Arrays.toString(lstFinalElements.toArray()))
            element = lstFinalElements.get(0);
            boolean checked = true;
            for (   ElementStates state : this.states)
            {
                if  (   !state.isWhen(actor,element) )
                {
                    checked = false;
                    break;
                }
            }
            lstFinalElements.remove(element);
            if(!checked){
                lstFinalElements.add(element);
            }
        }
    }

    public static WaitFor situation(Target[] elementos, ElementStates[] estados, long milisegundos){
        return Tasks.instrumented(WaitFor.class,elementos, estados, milisegundos);
    }
}
