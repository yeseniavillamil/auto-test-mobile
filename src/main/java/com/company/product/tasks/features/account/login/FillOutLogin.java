package com.company.product.tasks.features.account.login;

import com.company.product.interactions.basics.boxes.text.WriteText;
import com.company.product.interactions.basics.clicks.OneClick;
import com.company.product.models.params.features.account.login.LoginParams;
import com.company.product.tasks.javadoc.TasksJavaDoc;
import com.company.product.userinterfaces.features.account.login.LoginUI;
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
public class FillOutLogin implements Task
{
    private LoginParams params;

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
                        LoginUI.TXT_USERNAME.getTarget(),
                        this.params.getUsername()
                ),

                WriteText.field(
                        LoginUI.TXT_PASSWORD.getTarget(),
                        this.params.getPassword()
                )
        );

    }

    /**
     * For more information:
     * @see TasksJavaDoc#LINK
     */
    public static FillOutLogin account(LoginParams params)
    {
        return Tasks.instrumented(
            FillOutLogin.class,
                params
        );
    }
}
