
package com.company.product.runners;

import com.company.product.runners.javadoc.RunnersJavaDoc;
import com.company.product.utils.GeneralUtil;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;


/**
 * For more information:
 * @see RunnersJavaDoc#CLASS
 */

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource(RunnerConstants.PACKAGE_FEATURES)
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@Actual")
@ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = RunnerConstants.CAMELCASE)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = RunnerConstants.PACKAGE_GLUE)
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = RunnerConstants.PRETTY
                +","+RunnerConstants.CUCUMBER_SERENITY_REPORTER_PARALLEL
                //+","+RunnerConstants.DIR_REPORT_TIMELINE+ TestRunner.FEATURE_DIR+"/timeline"
                //+","+RunnerConstants.DIR_REPORT_JSON+ TestRunner.FEATURE_FILE+".json"
                //+","+RunnerConstants.DIR_REPORT_JUNIT + TestRunner.FEATURE_FILE+".xml"
                //+","+RunnerConstants.DIR_REPORT_HTML+ TestRunner.FEATURE_FILE+".html"
)
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
public class TestRunner
{
    //static final String FEATURE_DIR = "/account/login";
    //static final String FEATURE_FILE = FEATURE_DIR+"/login";

    /**
     * For more information:
     * @see RunnersJavaDoc#CONSTRUCTOR
     */
    private TestRunner()
    {
        GeneralUtil.notAllowInstantiation();
    }
}
