package com.company.product.interactions.basics.boxes.text;

import com.company.product.interactions.basics.retries.ForFirst;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Keys;

import java.util.Arrays;

@AllArgsConstructor
public class WriteText implements Interaction {

    private Target element;
    private String text;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        if(this.text != null){

            int length = this.element.resolveFor(actor).getTextValue().length();

            Keys[] keys = new Keys[length];
            Arrays.fill(keys, Keys.BACK_SPACE);

            actor.attemptsTo(
                    /**
                     * for the moment StaleElementException is presented for
                     * click actions
                     */

                    ForFirst.time(
                        //Clear.field(this.element),
                        Hit.the(keys).into(this.element),

                        Enter.theValue(this.text).into(this.element)
                    )
            );
        }
    }

    public static WriteText field(Target element, String text)
    {
        return Tasks.instrumented(
                WriteText.class,
                element,
                text);
    }

}
