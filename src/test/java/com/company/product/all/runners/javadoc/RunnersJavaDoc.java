package com.company.product.all.runners.javadoc;

import com.company.product.utils.GeneralUtil;

/**
 * Class that centralizes the documentation associated with the concept of launchers (runners)
 */
public class RunnersJavaDoc {

    /**
     * Class that allows deploying/launching the automation process guided by @CucumberOptions configurations
     * <li/> snippets:  CamelCase notation, in the generation of methods proposed by Cucumber, not finding StepDefinition
     * <li/> features:  Path of the .feature file(s) where the scenarios and test cases written in gherkin are located
     * <li/> glue:      Paths where Cucumber will search to connect the gherkin with the StepDefinition that satisfies the statement
     * <li/> tags:      Tags that identify/select the scenarios and/or cases that will be executed when the runner is launched
     * <li/> dryRun:    It allocates and focuses the execution of the runner on the equivalent verification between the
     *                  gherkin statements and the StepDefinition, if the relationship is not found, it will display the
     *                  proposals for generating StepDefinition methods expected by Cucumber. It is only activated to
     *                  perform this check
     */
    public static final String CLASS = null;

    /**
     * Deploying the launcher does not require the creation of an instance, to do so use:
     * <br/>Private constructor with support for disallowing instantiation
     * @see GeneralUtil#notAllowInstantiation()
     */
    public static final String CONSTRUCTOR = null;

    private RunnersJavaDoc()
    {
        GeneralUtil.notAllowInstantiation();
    }
}
