package com.company.product.models.params.features.welcome;

import com.company.product.models.params.javadoc.ParamsJavaDoc;
import com.company.product.utils.models.params.interfaces.IParam;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * For more information:
 * @see ParamsJavaDoc#CLASS
 */

@Data
@NoArgsConstructor
public class WelcomeParams implements IParam
{

    @JsonProperty("username")
    private String username;


}
