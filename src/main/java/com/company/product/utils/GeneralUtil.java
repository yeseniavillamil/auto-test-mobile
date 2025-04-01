package com.company.product.utils;

import com.company.product.utils.javadoc.JavaDocUtil;

/**
 * General and transversal utilities for the project
 */
public class GeneralUtil
{
    /**
     * Private constructor with support for disallowing instantiation
     * <br/>For more information:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private GeneralUtil(){
        GeneralUtil.notAllowInstantiation();
    }

    /**
     * Prevent direct instance (new), both for internal use and from other classes
     */
    public static void notAllowInstantiation(){
        throw new UnsupportedOperationException();
    }

    /**
     * unsupported operation exception
     */
    public static void unsupportedOperation(){
        throw new UnsupportedOperationException();
    }
}
