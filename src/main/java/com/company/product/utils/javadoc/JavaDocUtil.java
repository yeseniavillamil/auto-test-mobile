package com.company.product.utils.javadoc;

import com.company.product.utils.GeneralUtil;


public class JavaDocUtil {

    /**
     * A compendium of utilities arranges its consumption statically, under this characteristic it should not be
     * necessary to instantiate <a href="https://rules.sonarsource.com/java/RSPEC-1118">(SonarRule)</a>, For this use:
     * <br/>Private constructor with support for disallowing instantiation
     * @see GeneralUtil#notAllowInstantiation()
     */
    public static final String CONSTRUCTOR = null;

    private JavaDocUtil()
    {
        GeneralUtil.notAllowInstantiation();
    }
}
