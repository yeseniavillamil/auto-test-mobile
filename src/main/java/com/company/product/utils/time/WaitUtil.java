package com.company.product.utils.time;

import com.company.product.utils.GeneralUtil;
import com.company.product.utils.javadoc.JavaDocUtil;


public class WaitUtil
{

    /**
     * For more information:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private WaitUtil(){
        GeneralUtil.notAllowInstantiation();
    }

    public static void stopFor(long time){

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
