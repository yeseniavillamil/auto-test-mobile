//package com.company.product.questions.general.screen;
//
//import com.company.product.models.dtos.userinterfaces.web.UserInterfaceDTO;
//import com.company.product.questions.javadoc.QuestionsJavaDoc;
//import com.company.product.utils.params.ParamsUtil;
//import com.company.product.utils.userinterfaces.UserInterfacesUtil;
//import lombok.Builder;
//import lombok.Data;
//import net.serenitybdd.screenplay.Actor;
//import net.serenitybdd.screenplay.Question;
//import net.serenitybdd.screenplay.actions.Scroll;
//import net.serenitybdd.screenplay.questions.TextValue;
//import net.serenitybdd.screenplay.targets.Target;
//
//import java.util.List;
//
///**
// * For more information:
// * @see QuestionsJavaDoc#CLASS
// */
//@Builder
//@Data
//public class IsObservedTextElement implements Question<Boolean>
//{
//    private List<String> elements;
//    private List<String> parameters;
//    private String text;
//
//    /**
//     * For more information:
//     * @see QuestionsJavaDoc#ANSWERED_BY
//     */
//    @Override
//    public Boolean answeredBy(Actor actor)
//    {
//        /**
//         * For more information:
//         * @see QuestionsJavaDoc#LINK_VALIDATIONS_VERIFICATIONS
//         */
//
//        boolean result = true;
//
//        for(String element : this.elements)
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
//    }
//
//    private boolean validateElement(Actor actor, String element){
//
//        UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterface(element);
//        Target uiElement = (this.parameters ==null)
//            ? ui.getTarget()
//            : ui.getTarget(this.parameters.toArray());
//
//        actor.attemptsTo(
//            Scroll.to(uiElement)
//        );
//
//        return actor.asksFor(TextValue.of(uiElement))
//                .trim().equals(this.text);
//    }
//
//    /**
//     * For more information:
//     * @see QuestionsJavaDoc#LINK
//     */
//    public static IsObservedTextElement ofTheElement(String element, String parameters, String text)
//    {
//        List<String> elements = ParamsUtil.processString(element);
//        List<String> lstParameters = ParamsUtil.processString(parameters);
//
//        return IsObservedTextElement.builder()
//            .elements(elements)
//            .parameters(lstParameters)
//            .text(text)
//            .build();
//    }
//}
//
