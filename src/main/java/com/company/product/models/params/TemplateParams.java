package com.company.product.models.params;

import com.company.product.models.params.javadoc.ParamsJavaDoc;
import com.company.product.utils.models.params.interfaces.IParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * For more information:
 * @see ParamsJavaDoc#CLASS
 */

@Data
@NoArgsConstructor
public class TemplateParams implements IParam
{

    @JsonProperty("parameter1")
    private String parameter1;

    @JsonProperty("parameter2")
    private String parameter2;

    @JsonProperty("parameter3")
    private boolean parameter3;

}
