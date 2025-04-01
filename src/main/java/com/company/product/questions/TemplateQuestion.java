package com.company.product.questions;

import com.company.product.questions.javadoc.QuestionsJavaDoc;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

/**
 * For more information:
 * @see QuestionsJavaDoc#CLASS
 */
@Builder
public class TemplateQuestion implements Question<Boolean>
{
    //private {{TypeParams}} parameters

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
        boolean result;

        result = false;

        return result;
    }

    /**
     * For more information:
     * @see QuestionsJavaDoc#LINK
     */
    public static TemplateQuestion link(/*{{TypeParams}} parameters*/)
    {
        return TemplateQuestion.builder()
            //.parameters(parameters)
            .build();
    }
}
