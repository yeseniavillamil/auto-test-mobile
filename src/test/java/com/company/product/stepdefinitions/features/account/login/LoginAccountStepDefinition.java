package com.company.product.stepdefinitions.features.account.login;

import com.company.product.models.scena.NoteBook;
import com.company.product.models.scena.screenplay.Protagonist;
import com.company.product.stepdefinitions.features.welcome.OnBoardingStepDefinition;
import com.company.product.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.company.product.tasks.features.account.login.FillOutLogin;
import com.company.product.tasks.features.account.login.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

/**
 * For more information:
 * @see StepDefinitionsJavaDoc#CLASS
 */
public class LoginAccountStepDefinition
{
    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#GIVEN
     */
    @Given("^that \"(.*)\" is on access control.*")
    public static void givenThatIsOnAccessControl(String actor)
    {
        /**
         * @see StepDefinitionsJavaDoc#LINK_PREVIOUS_SCENE_PREVIOUS_SCREEN
         */
        OnBoardingStepDefinition.givenThatIsOnHisOnboarding(actor);
        OnBoardingStepDefinition.whenNavigatesForTheOnboarding();
    }

    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#WHEN
     */
    @When("^access to his account.*")
    public static void whenAccessToHisAccount(NoteBook noteBook)
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_TASK
         */
        Protagonist.onStage().attemptsTo(
                Login.account(noteBook.getParamsLogin())
        );
    }

    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#WHEN
     */
    @When("^fill out access to his account.*")
    public static void whenFillOutAccessToHisAccount(NoteBook noteBook)
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_TASK
         */
        Protagonist.onStage().attemptsTo(
                FillOutLogin.account(noteBook.getParamsLogin())
        );
    }



}
