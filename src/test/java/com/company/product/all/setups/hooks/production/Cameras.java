package com.company.product.all.setups.hooks.production;

import com.company.product.models.scena.screenplay.Protagonist;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class Cameras {

    @Before
    public void init(Scenario scenario) {
        System.err.println(scenario.getName());
        OnStage.setTheStage(new OnlineCast());
    }


    @After
    public void stop(Scenario scenario)
    {
        System.err.println(scenario.getStatus().toString());
        Protagonist.isPreparedForNextScene();
    }
}
