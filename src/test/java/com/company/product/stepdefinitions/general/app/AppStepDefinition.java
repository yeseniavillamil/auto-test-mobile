package com.company.product.stepdefinitions.general.app;

import com.company.product.models.scena.screenplay.Protagonist;
import com.company.product.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

/**
 * For more information:
 * @see StepDefinitionsJavaDoc#CLASS
 */
public class AppStepDefinition {


    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#GIVEN
     */
    @Given("^that \"(.*)\" started the application.*")
    public static void givenThatStartedTheApplication(String actor)
    {
        Protagonist.onStage().assignName(actor);
    }

    @When("^fill out access to his account, without mandatory information.*")
    public static void When()
    {
        System.err.println("fsdfds");
    }



}
