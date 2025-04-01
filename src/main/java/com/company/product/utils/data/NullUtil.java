package com.company.product.utils.data;

import com.company.product.utils.GeneralUtil;
import com.company.product.utils.javadoc.JavaDocUtil;

/**
 * Utility related to null data processing
 */
public class NullUtil
{
    public static final String ID_NULL = "%[NULL]%";

    /**
     * For more information:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private NullUtil(){
        GeneralUtil.notAllowInstantiation();
    }

    public static boolean isNull(String data) {

        return ID_NULL.equals(data);
    }
}
