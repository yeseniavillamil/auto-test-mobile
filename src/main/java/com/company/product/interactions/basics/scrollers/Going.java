package com.company.product.interactions.basics.scrollers;

import com.company.product.interactions.basics.retries.ForFirst;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

@AllArgsConstructor
public class Going implements Interaction {

    private Target element;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        if(this.element != null){

            actor.attemptsTo(
                    /**
                     * for the moment StaleElementException is presented for
                     * click actions
                     */

                    ForFirst.time(
                            Scroll.to(this.element)
                    )
            );
        }
    }

    public static Going to(Target element)
    {
        return Tasks.instrumented(
                Going.class,
                element
        );
    }

}
