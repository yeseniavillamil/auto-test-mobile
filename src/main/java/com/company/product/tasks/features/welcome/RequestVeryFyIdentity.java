package com.company.product.tasks.features.welcome;

import com.company.product.interactions.basics.boxes.text.WriteText;
import com.company.product.interactions.basics.clicks.OneClick;
import com.company.product.models.params.features.welcome.WelcomeParams;
import com.company.product.tasks.javadoc.TasksJavaDoc;
import com.company.product.userinterfaces.features.welcome.WelcomeUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * For more information:
 * @see TasksJavaDoc#CLASS
 */
@AllArgsConstructor
public class RequestVeryFyIdentity implements Task
{
    private WelcomeParams params;

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
                FillVeryFyIdentity.user(
                        this.params
                ),

                OneClick.on(
                        WelcomeUI.BTN_SEND_CODE.getTarget()
                )

        );

    }

    /**
     * For more information:
     * @see TasksJavaDoc#LINK
     */
    public static RequestVeryFyIdentity user(WelcomeParams params)
    {
        return Tasks.instrumented(
                RequestVeryFyIdentity.class,
                params

        );
    }
}
