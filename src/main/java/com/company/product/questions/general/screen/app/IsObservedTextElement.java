package com.company.product.questions.general.screen.app;

import com.company.product.models.dtos.userinterfaces.app.UserInterfaceDTO;
import com.company.product.questions.javadoc.QuestionsJavaDoc;
import com.company.product.utils.params.ParamsUtil;
import com.company.product.utils.userinterfaces.UserInterfacesUtil;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.TextValue;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

/**
 * For more information:
 * @see QuestionsJavaDoc#CLASS
 */
@Builder
@Data
public class IsObservedTextElement implements Question<Boolean>
{
    private String element;
    private List<String> parameters;
    private String text;
    //private boolean exactly;//TODO

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

        return this.validateText(actor,this.text);
    }

    private boolean validateText(Actor actor, String text){

        UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterfaceApp(element);
        Target uiElement = (this.parameters ==null)
            ? ui.getTarget()
            : ui.getTarget(this.parameters.toArray());

        //TODO SCROLL TO MOBILE APPIUM
//        actor.attemptsTo(
//            Scroll.to(uiElement)
//        );

        return actor.asksFor(TextValue.of(uiElement))
                .trim().equals(text);
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedTextElement ofTheElement(String element, String parameters, String text)
    {
        List<String> lstParameters = ParamsUtil.processString(parameters);

        return IsObservedTextElement.builder()
            .element(element)
            .parameters(lstParameters)
            .text(text)
            .build();
    }
}

