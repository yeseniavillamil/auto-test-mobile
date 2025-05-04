//package com.company.product.questions.general.screen;
//
//import com.company.product.models.dtos.userinterfaces.web.UserInterfaceDTO;
//import com.company.product.questions.javadoc.QuestionsJavaDoc;
//import web.com.company.product.userinterfaces.general.WebContentUI;
//import com.company.product.utils.params.ParamsUtil;
//import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
//import com.company.product.utils.questions.statedelements.questions.TheState;
//import com.company.product.utils.userinterfaces.UserInterfacesUtil;
//import com.company.product.utils.userinterfaces.interfaces.web.IUserInterface;
//import lombok.Builder;
//import lombok.Data;
//import net.serenitybdd.screenplay.Actor;
//import net.serenitybdd.screenplay.Question;
//import net.serenitybdd.screenplay.actions.Scroll;
//import net.serenitybdd.screenplay.targets.Target;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.List;
//
///**
// * For more information:
// * @see QuestionsJavaDoc#CLASS
// */
//@Builder
//@Data
//public class IsObservedText implements Question<Boolean>
//{
//    private List<String> texts;
//    private ElementStates is;
//    private boolean exactly;
//    private String section;
//    private List<String> parameters;
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
//        for(String text : this.texts)
//        {
//            if( text!=null &&  !text.isEmpty()  )
//            {
//                result = this.validateText(actor,text);
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
//    private boolean validateText(Actor actor, String text){
//        IUserInterface lblText=this.exactly
//            ? WebContentUI.LBL_TEXT_EXACTLY
//            : WebContentUI.LBL_TEXT;
//
//        String xpathSection;
//
//        if(this.section ==null || this.section.trim().isEmpty()){
//            xpathSection = StringUtils.EMPTY;
//        }else{
//            UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterface(this.section);
//            Target uiSection = (this.parameters ==null)
//                ? ui.getTarget()
//                : ui.getTarget(this.parameters.toArray());
//
//            actor.attemptsTo(
//                Scroll.to(uiSection)
//            );
//            xpathSection = uiSection.getCssOrXPathSelector();
//        }
//
//        boolean result = TheState.ofTheElements(
//                lblText.getTarget(text,xpathSection)
//            ).is(this.is)
//            .answeredBy(actor);
//
//        if(result && this.section ==null){
//            actor.attemptsTo(
//                Scroll.to(lblText.getTarget(text,xpathSection))
//            );
//        }
//
//        return result;
//    }
//
//    /**
//     * For more information:
//     * @see QuestionsJavaDoc#LINK
//     */
//    public static IsObservedText inScreen(
//        ElementStates is,
//        boolean exactly,
//        String section,
//        String parameters,
//        String text
//    ) {
//        IsObservedText question = IsObservedText.inScreen(is,exactly,section,text);
//        List<String> lstParameters = ParamsUtil.processString(parameters);
//        question.setParameters(lstParameters);
//        return question;
//    }
//
//    /**
//     * For more information:
//     * @see QuestionsJavaDoc#LINK
//     */
//    public static IsObservedText inScreen(
//        ElementStates is,
//        boolean exactly,
//        String section,
//        String text
//    ) {
//        IsObservedText question = IsObservedText.inScreen(is,exactly,text);
//        question.setSection(section);
//        return question;
//    }
//
//    /**
//     * For more information:
//     * @see QuestionsJavaDoc#LINK
//     */
//    public static IsObservedText inScreen(ElementStates is, boolean exactly, String text)
//    {
//        List<String> texts = ParamsUtil.processString(text);
//
//        return IsObservedText.builder()
//            .is(is)
//            .exactly(exactly)
//            .texts(texts)
//            .build();
//    }
//
//}
//
