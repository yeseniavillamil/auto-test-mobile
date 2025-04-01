package com.company.product.app.stepdefinitions.javadoc;


import com.company.product.utils.GeneralUtil;

/**
 * Class that centralizes the documentation associated with the concept of step definitions (StepDefinitions), in the
 * Screenplay pattern
 */
public class StepDefinitionsJavaDoc {

    /**
     * Class that allows Cucumber to connect/route the functional language with its equivalent technical resolution,
     * by finding a StepDefinition method that satisfies the gherkin statement expressed in the .feature file
     */
    public static final String CLASS = null;

    /**
     * It allows the translation and interpretation of gherkin Given statements, which are related to the sequence of
     * previous actions, necessary to reach the context in which the test scene will be carried out.
     * <br/>For more information on commonly used parameters:
     * @see StepDefinitionsJavaDoc#PARAMETER_ACTOR
     * @see StepDefinitionsJavaDoc#PARAMETER_NOTEBOOK
     */
    public static final String GIVEN = null;

    /**
     * Link sequentially with the GIVEN and WHEN methods of the previous screen (previous stepDefinition), which
     * according to the flow, when executed allows us to reach where the gherkin statement of the GIVEN says it is
     */
    public static final String LINK_PREVIOUS_SCENE_PREVIOUS_SCREEN = null;


    /**
     * It allows the translation and interpretation of gherkin When statements, which are related to the sequence of
     * actions that will be performed during the test scene.
     * <br/>For more information on commonly used parameters:
     * @see StepDefinitionsJavaDoc#PARAMETER_NOTEBOOK
     */
    public static final String WHEN = null;

    /**
     * Link with the GIVEN method of the current screen (this stepDefinition), which according to the flow, when 
     * located on the current screen, will proceed to trigger the actions proposed by the scenario
     */
    public static final String LINK_SCENE_IN_ACTION_GIVEN_CURRENT = null;

    /**
     * Continue with the integration towards the Task(s), responsible for executing the actor's actions during the
     * scene.
     */
    public static final String LINKED_TASK = null;

    /**
     * It allows the translation and interpretation of the gherkin Then statements, which are related to the expected
     * behaviors, consequences, at the end of the actions carried out during the test scene.
     */
    public static final String QUESTIONS = null;

    /**
     * Continue with the integration towards the Question(s), responsible for executing the validation(s)/verification(s)
     * on the executed scenario, designed based on the behaviors expected and that were applied to the consequences
     * obtained at the end of the actions carried out by the actor during the test scene
     */
    public static final String LINKED_QUESTIONS = null;

    /**
     * <li/> actor: Name/description of the actor starring in the scene
     */
    public static final String PARAMETER_ACTOR = null;

    /**
     * <li/> libreto:   Enable parameter, in case the gherkin statement has an associated parameter table
     *                  (gherkin table)
     */
    public static final String PARAMETER_NOTEBOOK = null;

    private StepDefinitionsJavaDoc()
    {
        GeneralUtil.notAllowInstantiation();
    }
}
