package com.company.product.models.scena.screenplay;

import com.company.product.models.scena.NoteBook;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.HashMap;
import java.util.Map;


public class Protagonist {

    private static final ThreadLocal<Protagonist> protagonist = ThreadLocal.withInitial(Protagonist::new);

    private NoteBook hisNotebook;
    private Map<String, String> tblGherkin;
    public static final String ANONYMOUS = "anonymous";
    private boolean isSessionActive;


    public static Actor onStage(){

        Actor actor;

        try{
            actor = OnStage.theActorInTheSpotlight();
        }catch(NullPointerException npe){
            actor = OnStage.theActorCalled(ANONYMOUS);
        }

        return actor;
    }

    public static Protagonist review(){
        return protagonist.get();
    }

    public static void isPreparedForNextScene(){
        Protagonist.review().hisNotebook = null;
    }

    public NoteBook hisNotebook()
    {
        if  (   this.hisNotebook == null   )
        {
            this.hisNotebook = new NoteBook();
        }
        return hisNotebook;
    }

    public Map<String, String> getTblGherkin()
    {
        if  (   this.tblGherkin == null  )
        {
            tblGherkin = new HashMap<>();
        }

        return this.tblGherkin;
    }


    public boolean isSessionActive() {
        return isSessionActive;
    }

    public void setSessionActive(boolean sessionActive) {
        this.isSessionActive = sessionActive;
    }


}
