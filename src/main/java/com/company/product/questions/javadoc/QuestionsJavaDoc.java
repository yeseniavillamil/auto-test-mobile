package com.company.product.questions.javadoc;


import com.company.product.utils.GeneralUtil;

/**
 * Class that centralizes the documentation associated with the concept of questions (Questions), in the Screenplay
 * pattern
 */
public class QuestionsJavaDoc {

    /**
     * Class to whom the responsibility is delegated to evaluate the results obtained, expected behavior and/or
     * consequence of having carried out the actor's previous actions, during the scene
     */
    public static final String CLASS = null;

    /**
     * Area dedicated to the objective of the question, through the implementation of its designed
     * validation/verification
     */
    public static final String ANSWERED_BY = null;

    /**
     * Customize the name of this method to offer better understanding when using it from the StepDefinition
     * <br/>Facilitates integration from the Step Definition through a static invocation strategy
     */
    public static final String LINK = null;

    /**
     * Continue with the integration of the validation(s)/verification(s) necessary to achieve the objective of the
     * question (Question)
     */
    public static final String LINK_VALIDATIONS_VERIFICATIONS = null;

    private QuestionsJavaDoc()
    {
        GeneralUtil.notAllowInstantiation();
    }

}
