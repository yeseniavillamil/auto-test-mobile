package com.company.product.tasks.javadoc;

import com.company.product.models.params.javadoc.ParamsJavaDoc;
import com.company.product.utils.GeneralUtil;

/**
 * Class that centralizes the documentation associated with the concept of tasks (Tasks), in the Screenplay pattern
 */
public class TasksJavaDoc {

    /**
     * Class to which responsibility is delegated for the action(s) that the actor will carry out on the test scene,
     * usually its scope is limited to describing a functional and specific activity of the actor on the scene through
     * of a sequence of actions
     */
    public static final String CLASS = null;

    /**
     * Area dedicated to the objective of the task, through the implementation of the sequence of actions, other tasks
     * or interactions, which will describe the behavior of the actor on the test scene, when carrying out this task
     */
    public static final String PERFORM_AS = null;

    /**
     * Customize the name of this method to offer better understanding when using it from the StepDefinition
     * <br/>Facilitates integration from the Step Definition through a static invocation strategy
     * <br/>For more information on commonly used parameters:
     * @see TasksJavaDoc#PARAMETER_PARAMS
     */
    public static final String LINK = null;

    /**
     * <li/> parameters: Enable parameter, in case the task requires an input of parameters to carry out its objective,
     *                   these parameters are normally routed from the StepDefinition through the script, and are
     *                   encapsulated within a 'Params' concept object,
     * @see ParamsJavaDoc#CLASS
     */
    public static final String PARAMETER_PARAMS = null;

    /**
     * Continue with the integration of the sequence of actions, calling other tasks or interactions, which together
     * describe what the actor will perform on the test scene.
     */
    public static final String LINKED_ACTIONS = null;

    private TasksJavaDoc()
    {
        GeneralUtil.notAllowInstantiation();
    }

}
