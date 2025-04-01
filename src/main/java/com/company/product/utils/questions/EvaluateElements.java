package com.company.product.utils.questions;

import com.company.product.constants.enums.config.Waits;
import com.company.product.interactions.waits.Wait;
import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class EvaluateElements implements Question<Boolean>
{
    private Target[] elements;

    @Override
    public Boolean answeredBy(Actor actor)
    {
        actor.attemptsTo(
            //WaitUntil.the(this.elementos[0], WebElementStateMatchers.isVisible()).forNoMoreThan(Esperas.GENERAL.getTiempo()).seconds()
            Wait.until(this.elements[0])
                .is(ElementStates.PRESENT)
                .forNotMoreOf(Waits.GENERAL.getTime()).seconds()
        );

        boolean result = true;

        for (   Target element : this.elements)
        {
            result = this.validateThan(actor,element);
            if  (   !result  ){
                break;
            }
        }

        return result;
    }

    protected abstract boolean validateThan(Actor actor, Target element);

}
