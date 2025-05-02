package com.company.product.tasks.features.welcome;

import com.company.product.interactions.basics.clicks.OneClick;
import com.company.product.tasks.javadoc.TasksJavaDoc;
import com.company.product.userinterfaces.features.welcome.OnboardingUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

/**
 * For more information:
 * @see TasksJavaDoc#CLASS
 */
@AllArgsConstructor
public class TourOnboarding implements Task
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
                OneClick.on(OnboardingUI.BTN_SKIP.getTarget())
        );

    }

    /**
     * For more information:
     * @see TasksJavaDoc#LINK
     */
    public static TourOnboarding welcome(/*{{TypeParams}} parameters*/)
    {
        return Tasks.instrumented(
            TourOnboarding.class/*,
               parameters
               */
        );
    }
}
