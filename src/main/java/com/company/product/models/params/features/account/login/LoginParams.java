package com.company.product.models.params.features.account.login;

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
public class LoginParams implements IParam
{

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

}
