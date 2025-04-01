package com.company.product.utils.questions.statedelements.questions;

import com.company.product.utils.questions.EvaluateElements;
import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class TheState
{
    private Target[] elementos;

    public class ElEstadoDeLosElementos extends EvaluateElements {

        private ElementStates estado;

        ElEstadoDeLosElementos(Target[] elementos, ElementStates estado) {
            super(elementos);
            this.estado = estado;
        }

        @Override
        protected boolean validateThan(Actor actor, Target element)
        {
            if (this.estado == null) {
                throw new UnsupportedOperationException();
            }

            return this.estado.isWhen(actor, element);
        }
    }

    public ElEstadoDeLosElementos is(ElementStates estado) {
        return new ElEstadoDeLosElementos(this.elementos, estado);
    }

    public static TheState ofTheElements(Target ... elementos)
    {
        return new TheState(elementos);
    }
}
