package com.company.product.interactions.basics.clicks;

import com.company.product.interactions.basics.retries.ForFirst;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

@AllArgsConstructor
public class OneClick implements Interaction {

    private Target element;

//    private static final long WAIT_FOR_RETRY = 500;
//    private static final long MAX_RETRIES = 3;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        if(this.element != null){

            actor.attemptsTo(
                    ForFirst.time(
                            Click.on(this.element)
                    )
            );
        }
    }

    public static OneClick on(Target element)
    {
        return Tasks.instrumented(
                OneClick.class,
                element
        );
    }

}
