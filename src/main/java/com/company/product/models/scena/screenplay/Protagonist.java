package com.company.product.models.scena.screenplay;

import com.company.product.models.scena.NoteBook;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.HashMap;
import java.util.Map;


public class Protagonist /*extends Actor*/{

    //private static Protagonist protagonist;
    private static final ThreadLocal<Protagonist> protagonist = ThreadLocal.withInitial(Protagonist::new);

    private NoteBook hisNotebook;
    private Map<String, String> tblGherkin;
    private Map<String, Object> objectsMap;

    private static final String ANONYMOUS = "anonymous";
    private boolean isSessionActive;

//    private Protagonist(String name)
//    {
//        super(name);
//    }

    public static Actor onStage(){
        return OnStage.theActorInTheSpotlight();
    }

    public static Protagonist review(){
        //if(Protagonist.protagonist == null){
        //Protagonist.protagonist = new Protagonist();
        //protagonist = ThreadLocal.withInitial(Protagonist::new);
        //}
        //return Protagonist.protagonist;
        return protagonist.get();
    }

    public static void isPreparedForNextScene(){
        //Protagonist.protagonist = null;
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

//    public static boolean hasPreviouslyActed(String as){
//        return Protagonist.isOnScene(as);
//    }

//    private static boolean isOnScene(String as)
//    {
//        boolean isOnScene = OnStage.stage().anActorIsOnStage();
//
//        as = as == null || as.trim().isEmpty()
//            ? ANONYMOUS
//            : as;
//        Protagonist.principal().assignName(as);
//
//        if  (   isOnScene
//            &&  !as.equalsIgnoreCase(OnStage.theActorInTheSpotlight().getName())
//        ) {
//            isOnScene = false;
//        }
//
//        return isOnScene;
//    }

//    public static Protagonist principal()
//    {
//        if(Protagonist.protagonist ==null){
//            Protagonist.protagonist = new Protagonist(ANONYMOUS);
//        }
//        return Protagonist.protagonist;
//    }

//    public static Protagonist enterOfScene(String as)
//    {
//        DressingRoom.delElenco().preparaAlProtagonista(as, Protagonist.principal());
//        OnStage.theActorCalled(as);
//        return Protagonist.principal();
//    }
//
//    public static Protagonist onStage()
//    {
//        Protagonist onStage;
//        if  (   Protagonist.isOnScene(Protagonist.principal().getName())   )
//        {
//            onStage = Protagonist.principal();
//        }else{
//            onStage = null;
//        }
//
//        return onStage;
//    }

//    public String withThePaperOf(){
//        return super.getName();
//    }




    public boolean isSessionActive() {
        return isSessionActive;
    }

    public void setSessionActive(boolean sessionActive) {
        this.isSessionActive = sessionActive;
    }


}
