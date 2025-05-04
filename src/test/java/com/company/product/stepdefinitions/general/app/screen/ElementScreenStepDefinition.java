package com.company.product.stepdefinitions.general.app.screen;

import com.company.product.models.params.general.screen.StateElementParams;
import com.company.product.models.params.general.screen.TextElementParams;
import com.company.product.models.scena.NoteBook;
import com.company.product.questions.general.screen.app.IsObservedState;
import com.company.product.questions.general.screen.app.IsObservedTextElement;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class ElementScreenStepDefinition {

    @Then("^in the app content, should be observed \"([^\"]*)\": \"([^\"]*)\".*")
    public static void thenShouldBeObserved(String state, String element)
    {
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                IsObservedState.ofTheElement(state, element, null)
            )
        );
    }

    @Then("^in the app content, should be observed \"([^\"]*)\"$")
    public static void thenShouldBeObserved(String state, NoteBook noteBook)
    {
        try {
            for (StateElementParams params : noteBook.getLstParamsStateElement()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedState.ofTheElement(
                                        state,
                                        params.getElement(),
                                        params.getParameters()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsStateElement().clear();
        }
    }

    @Then("^in the app content, should be observed the state of the elements.*")
    public static void thenShouldBeObservedTheStateElements(NoteBook noteBook)
    {
        try {
            for (StateElementParams params : noteBook.getLstParamsStateElement()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedState.ofTheElement(
                                        params.getStatus(),
                                        params.getElement(),
                                        params.getParameters()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsStateElement().clear();
        }
    }

    @Then("^in the app content, should be observed the text in the elements: \"([^\"]*)\".*")
    public static void thenShouldBeObservedTheTextInTheElements(String text, NoteBook noteBook)
    {
        try {
            for (TextElementParams params : noteBook.getLstParamsTextElement()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedTextElement.ofTheElement(
                                        params.getElement(),
                                        params.getParameters(),
                                        text
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextElement().clear();
        }
    }

    @Then("^in the app content, should be observed the text in the elements.*")
    public static void thenShouldBeObservedTheTextInTheElements(NoteBook noteBook)
    {
        try {
            for (TextElementParams params : noteBook.getLstParamsTextElement()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedTextElement.ofTheElement(
                                        params.getElement(),
                                        params.getParameters(),
                                        params.getText()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextElement().clear();
        }
    }
}
