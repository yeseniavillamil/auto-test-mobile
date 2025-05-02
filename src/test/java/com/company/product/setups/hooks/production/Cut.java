package com.company.product.setups.hooks.production;


import com.company.product.utils.logs.LogUtil;
import net.serenitybdd.core.webdriver.enhancers.AfterAWebdriverScenario;
import net.thucydides.model.domain.TestOutcome;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;
import java.util.UUID;

public class Cut implements AfterAWebdriverScenario {


    @Override
    public void apply(EnvironmentVariables environmentVariables, TestOutcome testOutcome, WebDriver webDriver) {

        String newId = UUID.randomUUID()+testOutcome.getId();

        try {
            Field id = testOutcome.getClass().getDeclaredField("id");
            id.setAccessible(true);
            id.set(testOutcome,newId);
            //testOutcome.setTitle(prefix + " - " + testOutcome.getTitle());

        } catch (Exception e) {
            LogUtil.error(e);
        }
    }

    @Override
    public boolean isActivated(EnvironmentVariables environmentVariables) {
        return AfterAWebdriverScenario.super.isActivated(environmentVariables);
    }
}


