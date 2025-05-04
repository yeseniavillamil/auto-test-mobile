package com.company.product.questions.general.screen.web;

import com.company.product.interactions.basics.web.window.frame.InFrame;
import com.company.product.models.dtos.userinterfaces.web.UserInterfaceDTO;
import com.company.product.questions.javadoc.QuestionsJavaDoc;
import com.company.product.userinterfaces.general.web.screen.WebContentUI;
import com.company.product.utils.params.ParamsUtil;
import com.company.product.utils.questions.statedelements.constants.enums.ElementStates;
import com.company.product.utils.questions.statedelements.questions.TheState;
import com.company.product.utils.userinterfaces.UserInterfacesUtil;
import com.company.product.utils.userinterfaces.interfaces.web.IUserInterface;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
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
    private List<String> section; //for consider iframes
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
                    ? WebContentUI.LBL_TEXT_EXACTLY_WITH_APOSTROPHE
                    : WebContentUI.LBL_TEXT_EXACTLY;
        }else{
            lblText = text.contains("'")
                    ? WebContentUI.LBL_TEXT_WITH_APOSTROPHE
                    : WebContentUI.LBL_TEXT;
            text = text.toLowerCase();
        }

        String xpathSection = this.validateSection(actor);

        String xpathSection2 =
                xpathSection.isEmpty()
                        ? "//*"
                        : xpathSection;

        boolean result = TheState.ofTheElements(
                lblText.getTarget(text,xpathSection,xpathSection2)
            ).is(this.is)
            .answeredBy(actor);

        if(result && (this.section ==null || this.section.isEmpty()))
        {
            actor.attemptsTo(
                Scroll.to(lblText.getTarget(text,xpathSection,xpathSection2))
            );
        }

        if(this.section != null  && this.section.size()>1)
        {
            actor.attemptsTo(
                    Switch.toDefaultContext()
            );
        }

        return result;
    }

    private String validateSection(Actor actor)
    {
        String xpathSection;

        if(this.section ==null || this.section.isEmpty()){
            xpathSection = StringUtils.EMPTY;
        }else{
            Target uiSection;
            List<Target> lstFrames = new ArrayList<>();

            int i=0;
            do{
                String frame = this.section.get(i);
                UserInterfaceDTO ui = UserInterfacesUtil.getInstance().getUserInterface(frame);
                uiSection = (this.parameters ==null)
                        ? ui.getTarget()
                        : ui.getTarget(this.parameters.toArray());

                if(i != this.section.size()-1){
                    lstFrames.add(uiSection);
                }
                i++;
            }while(i<this.section.size());

            if(this.section.size()>1){
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
            xpathSection = uiSection.getCssOrXPathSelector();
        }

        return xpathSection;
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
        List<String> lstSections = ParamsUtil.processString(section);
        question.setSection(lstSections);
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

