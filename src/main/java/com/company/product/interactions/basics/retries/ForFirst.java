package com.company.product.interactions.basics.retries;

import com.company.product.utils.time.WaitUtil;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.StaleElementReferenceException;

@AllArgsConstructor
public class ForFirst implements Interaction {

    private int maxRetries;
    private Performable[] actions;

    private static final long WAIT_FOR_RETRY = 500;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        for(Performable action : actions)
        {
            int attempts = 0;

            while (attempts < maxRetries) {
                try {

                    actor.attemptsTo(action);
                    break;

                } catch (StaleElementReferenceException e) {
                    attempts++;

                    System.err.println("Retry by StaleElementReferenceException (" + attempts + ")");
                    Serenity.recordReportData().withTitle("Retry #"+attempts+" for StaleElementException").andContents("Attempt to recover from the exception");

                    WaitUtil.stopFor(ForFirst.WAIT_FOR_RETRY);
                }
            }
        }
    }

    public static ForFirst time(Performable ... actions) {

        return Tasks.instrumented(
                ForFirst.class,
                3,
                actions
        );
    }

    public static ForFirst time(int maxRetries, Performable ... actions) {
        return new ForFirst(maxRetries,actions);
//        return Tasks.instrumented(
//                ForFirst.class,
//                maxRetries,
//                actions
//        );
    }
}
