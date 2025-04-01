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
public class StateElementParams implements IParam
{
    @JsonProperty("status")
    private String status;

    @JsonProperty("name")
    private String element;

    @JsonProperty("parameters")
    private String parameters;

    /**
     * For more information:
     * @see ParamsJavaDoc#CREATE_PARAMS
     */
    public static StateElementParams createParams(String status, String element, String parameters)
    {
        return StateElementParams.builder()
                .status(status)
                .element(element)
                .parameters(parameters)
                .build();
    }
}
