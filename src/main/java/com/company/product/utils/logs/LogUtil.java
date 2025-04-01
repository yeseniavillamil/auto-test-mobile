package com.company.product.utils.logs;

import com.company.product.utils.GeneralUtil;
import com.company.product.utils.javadoc.JavaDocUtil;
import com.company.product.utils.params.ParamsUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

import java.util.Arrays;

/**
 * Utility for managing traces (logs), which support the debugging process
 */
public class LogUtil
{
    public static final String RGX_FOUND_METHOD = "(?<gr>\\.[^.]+\\.[^.]+)$";
    public static final String RGX_INCLUDE_JUMP_START_METHOD = "\n\tTraza: ${gr}";

    public static final String FORMAT = "\n\t\t{1}";

    /**
     *	constant q identifies the position of interest to extract from the java call stack, when drawing a log, to
     *	recover the class path that caused the call to make the log trace
     */
    public static final int ID_POS_CLASS_STACK_TRACE_CURRENT_THREAD = 4;

    public static final String JUMP_LINE = "\n";

    public static final String TAB_LINE = "\t";

    public static final String IDENTATION = "\n\t\t";

    public static final String RGX_FINISH_JUMP_OR_TAB = "[\\n\\t]+$"; //"(\\n|\\t)+$"

    /**
     * For more information:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private LogUtil(){
        GeneralUtil.notAllowInstantiation();
    }


    public static void info(Object pReg, Object ... pParameters )
    {
        LogUtil.log(null,Level.INFO, pReg, pParameters);
    }

    public static void info(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.INFO, pReg, pParameters);
    }

    public static void info(Throwable pEx)
    {
        LogUtil.log(null,Level.INFO, pEx);
    }

    public static void info(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.INFO, pEx);
    }

    public static void error (Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.ERROR, pReg, pParameters);
    }

    public static void error (Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.ERROR, pReg, pParameters);
    }

    public static void error(Throwable pEx)
    {
        LogUtil.log(null,Level.ERROR, pEx);
    }

    public static void error(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.ERROR, pEx);
    }

    public static void warn(Object pReg, Object ... pParameters)
    {
        LogUtil.log(null, Level.WARN, pReg, pParameters);
    }

    public static void warn(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.WARN, pReg, pParameters);
    }

    public static void warn(Throwable pEx)
    {
        LogUtil.log(null,Level.WARN, pEx);
    }

    public static void warn(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.WARN, pEx);
    }

    public static void debug(Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.DEBUG, pReg, pParameters);
    }

    public static void debug(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.DEBUG, pReg, pParameters);
    }

    public static void debug(Throwable pEx)
    {
        LogUtil.log(null,Level.DEBUG, pEx);
    }

    public static void debug(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.DEBUG, pEx);
    }

    public static void trace(Object pReg, Object ... pParameters)
    {
        LogUtil.log(null,Level.TRACE, pReg, pParameters);
    }

    public static void trace(Logger logger, Object pReg, Object ... pParameters)
    {
        LogUtil.log(logger,Level.TRACE, pReg, pParameters);
    }

    public static void trace(Throwable pEx)
    {
        LogUtil.log(null,Level.TRACE, pEx);
    }

    public static void trace(Logger logger,Throwable pEx)
    {
        LogUtil.log(logger,Level.TRACE, pEx);
    }


    public static void general	(	Level pLevel,
                                       Object pReg,
                                       Object ... pParameters
    )
    {
        LogUtil.log(null,pLevel, pReg, pParameters);
    }


    public static void general	(	Logger logger,
                                       Level pLevel,
                                       Object pReg,
                                       Object ... pParameters
    )
    {
        LogUtil.log(logger,pLevel, pReg, pParameters);
    }


    private static void log(Logger logger,
                            Level pLevel,
                            Object pReg,
                            Object ... pParameters
    )
    {
        String strReg;
        logger = LogUtil.calculateLogger(logger);

        strReg = LogUtil.formatLog(pReg, pParameters);

        switch(pLevel){
            case DEBUG:
                if(logger.isDebugEnabled()){
                    logger.debug(strReg);
                }
                break;
            case INFO:
                if(logger.isInfoEnabled()){
                    logger.info(strReg);
                }
                break;
            case ERROR:
                if(logger.isErrorEnabled()){
                    logger.error(strReg);
                }
                break;
            case WARN:
                if(logger.isWarnEnabled()){
                    logger.warn(strReg);
                }
                break;
            default:
                if(logger.isTraceEnabled()){
                    logger.trace(strReg);
                }
                break;
        }
    }

    private static String formatLog(Object pReg, Object ... pParameters)
    {
        String strLogFixed;

        if(pReg==null || pReg.toString().isEmpty()) {
            strLogFixed = StringUtils.EMPTY;
        }else {

            if(pReg instanceof Throwable ex){
                strLogFixed = Arrays.toString(ex.getStackTrace()).replace(",",JUMP_LINE);
                strLogFixed = ex+JUMP_LINE+strLogFixed;
            }else{
                strLogFixed = ParamsUtil.processParameters(pReg.toString(), pParameters);
            }
            strLogFixed = strLogFixed.replace(JUMP_LINE, IDENTATION)
                    .replaceAll(RGX_FINISH_JUMP_OR_TAB, StringUtils.EMPTY);
        }

        return ParamsUtil.processParameters(FORMAT, Thread.currentThread().getId(),strLogFixed);
    }

    private static Logger calculateLogger(Logger logger)
    {
        String strTrace = null;

        if(logger != null) {
            for(int i = ID_POS_CLASS_STACK_TRACE_CURRENT_THREAD; i<Thread.currentThread().getStackTrace().length ; i++ ) {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i];
                if(stackTraceElement.getClassName().equals(logger.getName())) {
                    strTrace = stackTraceElement.toString();
                    break;
                }
            }
        }

        if(strTrace == null) {

            strTrace = Thread.currentThread().getStackTrace()[ID_POS_CLASS_STACK_TRACE_CURRENT_THREAD].toString();
        }

        return LoggerFactory.getLogger(strTrace.replaceAll(RGX_FOUND_METHOD, RGX_INCLUDE_JUMP_START_METHOD));
    }

    public static Logger getLogger()
    {
        return getLogger(Thread.currentThread().getStackTrace().length-1);
    }

    public static Logger getLogger(int idPosClaseStackTraceCurrentThread)
    {
        String strClass;

        strClass = Thread.currentThread().getStackTrace()[idPosClaseStackTraceCurrentThread].getClassName();

        return LoggerFactory.getLogger(strClass);
    }
}
