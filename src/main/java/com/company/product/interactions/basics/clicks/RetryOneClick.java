package com.company.product.interactions.basics.clicks;


import com.company.product.utils.time.WaitUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

@AllArgsConstructor
public class RetryOneClick implements Interaction {

    private Target element;

    private static final long WAIT_FOR_RETRY = 500;
    private static final long MAX_RETRIES = 3;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        if(this.element != null){

            int attempts = 0;

            while (attempts < MAX_RETRIES) {
                try {

                    this.element.resolveFor(actor).click();

                    break;
                } catch (StaleElementReferenceException | TimeoutException e) {
                    attempts++;
                    System.err.println("Retry Selenium by any Exception State (" + attempts + ")");
                    WaitUtil.stopFor(WAIT_FOR_RETRY);
                }
            }
        }
    }

    public static RetryOneClick on(Target element)
    {
        return Tasks.instrumented(
                RetryOneClick.class,
                element
        );
    }

}
