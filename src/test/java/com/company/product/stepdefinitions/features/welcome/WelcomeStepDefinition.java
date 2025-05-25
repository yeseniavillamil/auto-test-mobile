package com.company.product.stepdefinitions.features.welcome;

import com.company.product.models.scena.NoteBook;
import com.company.product.models.scena.screenplay.Protagonist;
import com.company.product.stepdefinitions.general.app.AppStepDefinition;
import com.company.product.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.company.product.tasks.features.welcome.FillVeryFyIdentity;
import com.company.product.tasks.features.welcome.RequestVeryFyIdentity;
import com.company.product.tasks.features.welcome.onboarding.TourOnboarding;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * For more information:
 * @see StepDefinitionsJavaDoc#CLASS
 */
public class WelcomeStepDefinition
{
    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#GIVEN
     */
    @Given("^that \"(.*)\" is on welcome message.*")
    public static void givenThatIsOnWelcomeMessage(String actor)
    {
        /**
         * @see StepDefinitionsJavaDoc#LINK_PREVIOUS_SCENE_PREVIOUS_SCREEN
         */
        AppStepDefinition.givenThatStartedTheApplication(actor);
    }

    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#WHEN
     */
    @When("^fill out his identity verification.*")
    public static void whenFillOutHisIdentityVerification(NoteBook noteBook)
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_TASK
         */
        Protagonist.onStage().attemptsTo(
                FillVeryFyIdentity.user(noteBook.getParamsWelcome())
        );
    }

    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#WHEN
     */
    @When("^requests his identity verification.*")
    public static void whenRequestOutHisIdentityVerification(NoteBook noteBook)
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_TASK
         */
        Protagonist.onStage().attemptsTo(
                RequestVeryFyIdentity.user(noteBook.getParamsWelcome())
        );
    }


}
