package com.company.product.utils.questions.statedelements.constants.enums;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

public enum ElementStates {

    VISIBLE {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return element.isVisibleFor(actor);
            //return element.resolveFor(actor).isVisible()
        }
    },
    NO_VISIBLE {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return !element.isVisibleFor(actor);
            //return !element.resolveFor(actor).isVisible()
        }
    },
    ENABLED {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return element.resolveFor(actor).isEnabled();
        }
    },
    DISABLED {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return !element.resolveFor(actor).isEnabled();
        }
    },
    PRESENT {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return element.resolveFor(actor).isPresent();
        }
    },
    NO_PRESENT {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return !element.resolveFor(actor).isPresent();
        }
    },
    CLICKABLE {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return element.resolveFor(actor).isClickable();
        }
    },
    NO_CLICKABLE {
        @Override
        public boolean isWhen(Actor actor, Target element) {
            return !element.resolveFor(actor).isClickable();
        }
    },

    ;

    public abstract boolean isWhen(Actor actor, Target element);
}
