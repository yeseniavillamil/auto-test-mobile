package com.company.product.all.runners;

public class RunnerConstants {

    private RunnerConstants(){
        throw new UnsupportedOperationException();
    }

    private final static String BASE = "com.company.product";
    private final static String URL = "src/test/resources";

    public final static String PACKAGE_STEP_DEFINITIONS = BASE+".app.stepdefinitions";
    public final static String PACKAGE_DATA_DEFINITIONS = BASE+".datadefinitions";
    public final static String PACKAGE_SETUPS = BASE+".all.setups";

    public final static String PACKAGE_GLUE = RunnerConstants.PACKAGE_STEP_DEFINITIONS+","+RunnerConstants.PACKAGE_SETUPS;

    public final static String PACKAGE_FEATURES = "/features";
    public final static String PACKAGE_FEATURES_URL = URL+PACKAGE_FEATURES;

    public final static String PRETTY = "pretty";
    public final static String CAMELCASE = "camelcase";
    public final static String CUCUMBER_SERENITY_REPORTER_PARALLEL = "io.cucumber.core.plugin.SerenityReporterParallel";
    public final static String DIR_REPORT_TIMELINE = "timeline:build/reports/cucumber";///timeline
    public final static String DIR_REPORT_JSON = "json:build/reports/cucumber";///json
    public final static String DIR_REPORT_JUNIT = "junit:build/reports/cucumber";///junit
    public final static String DIR_REPORT_HTML = "html:build/reports/cucumber";///html

}
