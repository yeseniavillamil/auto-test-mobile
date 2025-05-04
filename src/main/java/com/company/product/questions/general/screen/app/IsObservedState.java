package com.company.product.questions.general.screen.app;


import com.company.product.models.dtos.userinterfaces.app.UserInterfaceDTO;
import com.company.product.questions.javadoc.QuestionsJavaDoc;
import com.company.product.utils.params.ParamsUtil;
import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import com.company.product.utils.questions.statedelements.questions.TheState;
import com.company.product.utils.userinterfaces.UserInterfacesUtil;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * For more information:
 * @see QuestionsJavaDoc#CLASS
 */
@Builder
@Data
public class IsObservedState implements Question<Boolean>
{
    private String element;
    private List<String> parameters;//apply for iframes as element
    private String state;

    /**
     * For more information:
     * @see QuestionsJavaDoc#ANSWERED_BY
     */
    @Override
    public Boolean answeredBy(Actor actor)
    {
        /**
         * For more information:
         * @see QuestionsJavaDoc#LINK_VALIDATIONS_VERIFICATIONS
         */

        return this.validateState(actor,this.state);
    }

    private boolean validateState(Actor actor, String state){

        UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterfaceApp(element);
        Target uiElement = (this.parameters ==null)
            ? ui.getTarget()
            : ui.getTarget(this.parameters.toArray());

        actor.attemptsTo(
            Scroll.to(uiElement)
        );

        return TheState.ofTheElements(
                uiElement
            ).is(ElementStates.valueOf(state.toUpperCase()))
            .answeredBy(actor);
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedState ofTheElement(String state, String element, String parameters)
    {
        List<String> lstParameters = ParamsUtil.processString(parameters);

        return IsObservedState.builder()
            .state(state)
            .element(element)
            .parameters(lstParameters)
            .build();
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedState ofTheElement(String status, String element)
    {
        return IsObservedState.builder()
            .state(status)
            .element(element)
            .build();
    }
}

