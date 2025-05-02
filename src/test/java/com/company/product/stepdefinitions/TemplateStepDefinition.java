package com.company.product.stepdefinitions;

import com.company.product.models.scena.screenplay.Protagonist;
import com.company.product.questions.TemplateQuestion;
import com.company.product.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.company.product.tasks.TemplateTask;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * For more information:
 * @see StepDefinitionsJavaDoc#CLASS
 */
public class TemplateStepDefinition
{
    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#GIVEN
     */
    //@Given("^that \"(.*)\" is {{activate the statement and adapt the expression that satisfies the gherkin statement}}.*")
    public static void givenThatIsOn(String actor/*, NoteBook noteBook*/)
    {
        /**
         * @see StepDefinitionsJavaDoc#LINK_PREVIOUS_SCENE_PREVIOUS_SCREEN
         */
        //{{PreviousScreen}}StepDefinition.given{{ThatIsOnPreviousScreen}}(/*noteBook*/);
        //{{PreviousScreen}}StepDefinition.when{{ExecuteWhatAllowsMeFindMeHere}}(/*noteBook*/);
    }

    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#WHEN
     */
    //@When("^{{activate the statement and adapt the expression that satisfies the gherkin statement}}.*")
    public static void when(/*NoteBook noteBook*/)
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_TASK
         */
        Protagonist.onStage().attemptsTo(
            //tasks/features/../{{Task}}.{{needOnScreen}}(noteBook.getParameters{{Params}}) // linked with Task
            TemplateTask.link()
        );
    }

    /**
     * For more information:
     * @see StepDefinitionsJavaDoc#QUESTIONS
     */
    //@Then("^should {{activate the statement and adapt the expression that satisfies the gherkin statement}}.*")
    public static void thenShouldBe()
    {
        /**
         * For more information:
         * @see StepDefinitionsJavaDoc#LINKED_QUESTIONS
         */
        Protagonist.onStage().should(
            GivenWhenThen.seeThat(
                TemplateQuestion.link() // Linked with Questions
            )
        );
    }

}
