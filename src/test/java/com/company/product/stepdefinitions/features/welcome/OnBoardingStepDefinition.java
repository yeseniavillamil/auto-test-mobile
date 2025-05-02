package com.company.product.stepdefinitions.features.welcome;

import com.company.product.models.scena.screenplay.Protagonist;
import com.company.product.questions.TemplateQuestion;
import com.company.product.stepdefinitions.general.app.AppStepDefinition;
import com.company.product.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.company.product.tasks.TemplateTask;
import com.company.product.tasks.features.welcome.TourOnboarding;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * For more information:
 * @see StepDefinitionsJavaDoc#CLASS
 */
public class OnBoardingStepDefinition
{
    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#GIVEN
     */
    @Given("^that \"(.*)\" is on his onboarding.*")
    public static void givenThatIsOnHisOnboarding(String actor)
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
    @When("^navigates for the onboarding.*")
    public static void whenNavigatesForTheOnboarding(/*NoteBook noteBook*/)
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_TASK
         */
        Protagonist.onStage().attemptsTo(
                TourOnboarding.welcome()
        );
    }


}
