package com.company.product.questions.general.screen.app;

import com.company.product.models.dtos.userinterfaces.app.UserInterfaceDTO;
import com.company.product.questions.javadoc.QuestionsJavaDoc;
import com.company.product.userinterfaces.general.app.screen.AppContentUI;
import com.company.product.utils.params.ParamsUtil;
import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import com.company.product.utils.questions.statedelements.questions.TheState;
import com.company.product.utils.userinterfaces.UserInterfacesUtil;
import com.company.product.utils.userinterfaces.interfaces.app.IUserInterface;
import io.appium.java_client.android.AndroidDriver;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * For more information:
 * @see QuestionsJavaDoc#CLASS
 */
@Builder
@Data
public class IsObservedText implements Question<Boolean>
{
    private List<String> texts;
    private ElementStates is;
    private boolean exactly;
    private String section; //for consider iframes
    private List<String> parameters;//apply for iframes as element

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

        for(String text : this.texts)
        {
            if( text!=null &&  !text.isEmpty()  )
            {
                result = this.validateText(actor,text);

                if( !result ) {
                    break;
                }
            }
        }

        return result;
    }

    private boolean validateText(Actor actor, String text)
    {
        IUserInterface lblText;
        if(this.exactly){
            lblText = text.contains("'")
                    ? AppContentUI.LBL_TEXT_EXACTLY_WITH_APOSTROPHE
                    : AppContentUI.LBL_TEXT_EXACTLY;
        }else{
            lblText = text.contains("'")
                    ? AppContentUI.LBL_TEXT_WITH_APOSTROPHE
                    : AppContentUI.LBL_TEXT;
            text = text.toLowerCase();
        }

        String xpathSection;

        if(this.section ==null || this.section.trim().isEmpty()){
            xpathSection = StringUtils.EMPTY;
        }else{
            UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterfaceApp(this.section);
            Target uiSection = (this.parameters ==null)
                    ? ui.getTarget()
                    : ui.getTarget(this.parameters.toArray());

            //TODO SCROLL TO MOBILE APPIUM
//            actor.attemptsTo(
//                    Scroll.to(uiSection)
//            );

            //NO WORK Target.getCssOrXPathSelector() by Appium [Android/iOS]
            //xpathSection = uiSection.getCssOrXPathSelector();

            xpathSection = Serenity.getProxiedDriver() instanceof AndroidDriver
                ?  ui.getSelectorAndroidFixed()
                : ui.getSelectorIOSFixed();
        }

        String xpathSection2 =
                xpathSection.isEmpty()
                        ? "//*"
                        : xpathSection;

        boolean result = TheState.ofTheElements(
                lblText.getTarget(text,xpathSection,xpathSection2)
            ).is(this.is)
            .answeredBy(actor);

        //TODO SCROLL TO MOBILE APPIUM
//        if(result && (this.section ==null || this.section.isEmpty()))
//        {
//            actor.attemptsTo(
//                Scroll.to(lblText.getTarget(text,xpathSection,xpathSection2))
//            );
//        }

        return result;
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedText inScreen(
            ElementStates is,
            boolean exactly,
            String section,
            String parameters,
            String text
    ) {
        IsObservedText question = IsObservedText.inScreen(is,exactly,section,text);
        List<String> lstParameters = ParamsUtil.processString(parameters);
        question.setParameters(lstParameters);
        return question;
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedText inScreen(
            ElementStates is,
            boolean exactly,
            String section,
            String text
    ) {
        IsObservedText question = IsObservedText.inScreen(is,exactly,text);
        question.setSection(section);
        return question;
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static IsObservedText inScreen(ElementStates is, boolean exactly, String text)
    {
        List<String> texts = ParamsUtil.processString(text);

        return IsObservedText.builder()
                .is(is)
                .exactly(exactly)
                .texts(texts)
                .build();
    }

}

