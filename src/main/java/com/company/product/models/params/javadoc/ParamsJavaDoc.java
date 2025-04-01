package com.company.product.models.params.javadoc;

import com.company.product.models.scena.NoteBook;
import com.company.product.utils.GeneralUtil;

/**
 * Class that centralizes the documentation associated with the concept of step-parameters (Params), within the
 * architecture
 */
public class ParamsJavaDoc {

    /**
     * Class that represents the set of parameters, usually described by a gherkin table
     * DO NOT FORGET TO RECORD THE PARAMETERS IN THE NOTEBOOK, TO ENABLE ITS USE
     * @see NoteBook
     */
    public static final String CLASS = null;

    public static final String CREATE_PARAMS = null;

    private ParamsJavaDoc()
    {
        GeneralUtil.notAllowInstantiation();
    }

}
