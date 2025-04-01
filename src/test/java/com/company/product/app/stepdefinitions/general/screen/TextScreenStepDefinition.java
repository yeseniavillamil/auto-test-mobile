package com.company.product.app.stepdefinitions.general.screen;

import com.company.product.models.params.general.screen.TextZoneParams;
import com.company.product.models.scena.NoteBook;
import com.company.product.questions.general.screen.IsObservedText;
import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;

public class TextScreenStepDefinition {

    @Then("^should be presented: \"([^\"]*)\".*")
    public static void thenShouldBePresented(String texts)
    {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        IsObservedText.inScreen(
                            ElementStates.VISIBLE,
                            false,
                            texts
                        )
                )
        );
    }

    @Then("^should be presented in \"([^\"]*)\": \"([^\"]*)\".*")
    public static void thenShouldBePresentedIn(String section, String texts)
    {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        IsObservedText.inScreen(
                            ElementStates.VISIBLE,
                            false,
                            section,
                            texts
                        )
                )
        );
    }

    @Then("^should be presented in \"([^\"]*)\" with \"([^\"]*)\"")
    public static void thenShouldBePresentedInWith(String section, String parameters, NoteBook noteBook)
    {
        try {
            for (TextZoneParams params : noteBook.getLstParamsTextZone()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedText.inScreen(
                                        ElementStates.VISIBLE,
                                        false,
                                        section,
                                        parameters,
                                        params.getText()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextZone().clear();
        }

    }

    @Then("^should be presented in \"([^\"]*)\"$")
    public static void thenShouldBePresentedIn(String section, NoteBook noteBook)
    {
        try {

            for (TextZoneParams params : noteBook.getLstParamsTextZone()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedText.inScreen(
                                        ElementStates.VISIBLE,
                                        false,
                                        section,
                                        params.getParameters(),
                                        params.getText()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextZone().clear();
        }

    }

    @Then("^should be presented$")
    public static void thenShouldBePresented(NoteBook noteBook)
    {
        try {
            for (TextZoneParams params : noteBook.getLstParamsTextZone()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedText.inScreen(
                                        ElementStates.VISIBLE,
                                        false,
                                        params.getSection(),
                                        params.getParameters(),
                                        params.getText()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextZone().clear();
        }

    }






    @Then("^should be presenetd exactly: \"([^\"]*)\".*")
    public static void thenShouldBePresentedExactly(String texts)
    {
        OnStage.theActorInTheSpotlight().should(
            GivenWhenThen.seeThat(
                IsObservedText.inScreen(
                    ElementStates.VISIBLE,
                    true,
                    texts
                )
            )
        );
    }

    @Then("^should be presented exactly in \"([^\"]*)\": \"([^\"]*)\".*")
    public static void thenShouldBePresentedExactlyIn(String section, String texts)
    {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        IsObservedText.inScreen(
                            ElementStates.VISIBLE,
                            true,
                            section,
                            texts
                        )
                )
        );
    }

    @Then("^should be presented exactly in \"([^\"]*)\" with \"([^\"]*)\"")
    public static void thenShouldBePresentedExactlyInWith(String section, String parameters, NoteBook noteBook)
    {
        try {

            for (TextZoneParams params : noteBook.getLstParamsTextZone()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedText.inScreen(
                                        ElementStates.VISIBLE,
                                        true,
                                        section,
                                        parameters,
                                        params.getText()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextZone().clear();
        }

    }

    @Then("^should be presented exactly in \"([^\"]*)\"$")
    public static void thenShouldBePresentedExactlyIn(String section, NoteBook noteBook)
    {
        try {
            for (TextZoneParams params : noteBook.getLstParamsTextZone()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedText.inScreen(
                                        ElementStates.VISIBLE,
                                        true,
                                        section,
                                        params.getParameters(),
                                        params.getText()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextZone().clear();
        }

    }

    @Then("^should be presented exactly$")
    public static void thenShouldBePresentedExactly(NoteBook noteBook)
    {
        try {
            for (TextZoneParams params : noteBook.getLstParamsTextZone()) {
                OnStage.theActorInTheSpotlight().should(
                        GivenWhenThen.seeThat(
                                IsObservedText.inScreen(
                                        ElementStates.VISIBLE,
                                        true,
                                        params.getSection(),
                                        params.getParameters(),
                                        params.getText()
                                )
                        )
                );
            }
        }finally{
            noteBook.getLstParamsTextZone().clear();
        }

    }
}
