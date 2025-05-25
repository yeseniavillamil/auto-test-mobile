package com.company.product.tasks.features.welcome;

import com.company.product.interactions.basics.boxes.text.WriteText;
import com.company.product.interactions.basics.clicks.OneClick;
import com.company.product.models.params.features.welcome.WelcomeParams;
import com.company.product.tasks.javadoc.TasksJavaDoc;
import com.company.product.userinterfaces.features.welcome.OnboardingUI;
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
public class FillVeryFyIdentity implements Task
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
                WriteText.field(
                        WelcomeUI.TXT_USER.getTarget(),
                        params.getUsername()
                )

        );

    }

    /**
     * For more information:
     * @see TasksJavaDoc#LINK
     */
    public static FillVeryFyIdentity user(WelcomeParams params)
    {
        return Tasks.instrumented(
                FillVeryFyIdentity.class,
                params

        );
    }
}
