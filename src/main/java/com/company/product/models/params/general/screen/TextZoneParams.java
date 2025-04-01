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
public class TextZoneParams implements IParam
{

    @JsonProperty("section")
    private String section;

    @JsonProperty("parameters")
    private String parameters;

    @JsonProperty("text")
    private String text;

    /**
     * For more information:
     * @see ParamsJavaDoc#CREATE_PARAMS
     */
    public static TextZoneParams createParams(String section, String parameters, String text)
    {
        return TextZoneParams.builder()
                .section(section)
                .parameters(parameters)
                .text(text)
                .build();
    }
}
