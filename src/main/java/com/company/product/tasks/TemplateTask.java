package com.company.product.tasks;

import com.company.product.tasks.javadoc.TasksJavaDoc;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * For more information:
 * @see TasksJavaDoc#CLASS
 */
@AllArgsConstructor
public class TemplateTask implements Task
{
    //private {{TypeParams}} parameters

    /**
     * For more information:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * For more information:
         * @see TasksJavaDoc#LINKED_ACTIONS
         */
        actor.attemptsTo(
            /*
             * List Actions,
             */
        );
    }

    /**
     * For more information:
     * @see TasksJavaDoc#LINK
     */
    public static TemplateTask link(/*{{TypeParams}} parameters*/)
    {
        return Tasks.instrumented(
            TemplateTask.class/*,
               parameters
               */
        );
    }
}
