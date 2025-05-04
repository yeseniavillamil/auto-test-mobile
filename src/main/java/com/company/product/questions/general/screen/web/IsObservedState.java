package com.company.product.questions.general.screen.web;

import com.company.product.interactions.basics.web.window.frame.InFrame;
import com.company.product.models.dtos.userinterfaces.web.UserInterfaceDTO;
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
    private List<String> element; //for consider iframes
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

//        boolean result = true;
//
//        for(String element : this.element)
//        {
//            if( element!=null &&  !element.isEmpty()  )
//            {
//                result = this.validateElement(actor,element);
//
//                if( !result ) {
//                    break;
//                }
//            }
//        }
//
//        return result;

        return this.validateState(actor,this.state);
    }

    private boolean validateState(Actor actor, String state){

//        UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterface(element);
//        Target uiElement = (this.parameters ==null)
//            ? ui.getTarget()
//            : ui.getTarget(this.parameters.toArray());
//
//        actor.attemptsTo(
//            Scroll.to(uiElement)
//        );

        Target uiElement = this.validateElement(actor);

        return TheState.ofTheElements(
                uiElement
            ).is(ElementStates.valueOf(state.toUpperCase()))
            .answeredBy(actor);
    }

    private Target validateElement(Actor actor)
    {
        Target uiSection;
        List<Target> lstFrames = new ArrayList<>();

        int i=0;
        do{
            String frame = this.element.get(i);
            UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterface(frame);
            uiSection = (this.parameters ==null)
                    ? ui.getTarget()
                    : ui.getTarget(this.parameters.toArray());

            if(i != this.element.size()-1){
                lstFrames.add(uiSection);
            }
            i++;
        }while(i<this.element.size());

        if(this.element.size()>1){
            Target[] arrFrames = lstFrames.toArray(new Target[0]);
            actor.attemptsTo(
                    InFrame.located(true,
                            arrFrames
                    ).perform(
                            (Performable[]) null
                    )
            );
        }

        actor.attemptsTo(
                Scroll.to(uiSection)
        );

        return uiSection;
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
            .element(elements)
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
            .element(Arrays.asList(elements))
            .build();
    }
}

