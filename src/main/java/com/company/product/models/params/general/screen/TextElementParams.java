package com.company.product.models.params.general.screen;

import com.company.product.models.params.javadoc.ParamsJavaDoc;
import com.company.product.utils.models.params.interfaces.IParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * For more information:
 * @see ParamsJavaDoc#CLASS
 */
@Data
@NoArgsConstructor

//for back strategy
@Builder
@AllArgsConstructor
public class TextElementParams implements IParam
{
    @JsonProperty("name")
    private String element;

    @JsonProperty("parameters")
    private String parameters;

    @JsonProperty("text")
    private String text;

    /**
     * Para mas informacion:
     * @see ParamsJavaDoc#CREATE_PARAMS
     */
    public static TextElementParams createParams(String element, String parameters, String text)
    {
        return TextElementParams.builder()
                .element(element)
                .parameters(parameters)
                .text(text)
                .build();
    }
}
