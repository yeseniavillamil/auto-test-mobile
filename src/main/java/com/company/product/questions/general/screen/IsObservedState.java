package com.company.product.questions.general.screen;

import com.company.product.models.dtos.userinterfaces.web.UserInterfaceDTO;
import com.company.product.questions.javadoc.QuestionsJavaDoc;
import com.company.product.utils.params.ParamsUtil;
import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import com.company.product.utils.questions.statedelements.questions.TheState;
import com.company.product.utils.userinterfaces.UserInterfacesUtil;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;

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
    private List<String> elements;
    private List<String> parameters;
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

        boolean result = true;

        for(String element : this.elements)
        {
            if( element!=null &&  !element.isEmpty()  )
            {
                result = this.validateElement(actor,element);

                if( !result ) {
                    break;
                }
            }
        }

        return result;
    }

    private boolean validateElement(Actor actor, String element){

        UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterface(element);
        Target uiElement = (this.parameters ==null)
            ? ui.getTarget()
            : ui.getTarget(this.parameters.toArray());

        actor.attemptsTo(
            Scroll.to(uiElement)
        );

        return TheState.ofTheElements(
                uiElement
            ).is(ElementStates.valueOf(this.state.toUpperCase()))
            .answeredBy(actor);
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedState ofTheElement(String state, String element, String parameters)
    {
        List<String> elements = ParamsUtil.processString(element);
        List<String> lstParameters = ParamsUtil.processString(parameters);

        return IsObservedState.builder()
            .state(state)
            .elements(elements)
            .parameters(lstParameters)
            .build();
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedState ofTheElement(String status, String ... elements)
    {
        return IsObservedState.builder()
            .state(status)
            .elements(Arrays.asList(elements))
            .build();
    }
}

