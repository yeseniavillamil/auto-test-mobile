package com.company.product.interactions.basics.web.window.tabs;


import com.company.product.utils.logs.LogUtil;
import lombok.Builder;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



@Builder
public class SwitchTab implements Interaction
{
    private Performable[] actions;
    private boolean stayOnNewTab;
    private boolean closeActualTab;

    @Override
    public <T extends Actor> void performAs(T actor)
    {
        try{
            new WebDriverWait(Serenity.getDriver(), Duration.ofSeconds(3))
                    .until(d -> d.getWindowHandles().size() > 1);

            String actualWindow = Serenity.getDriver().getWindowHandle();

            //Serenity.getDriver().getWindowHandle();
            //Serenity.getDriver().getWindowHandles();

            if(closeActualTab)
            {
                Serenity.getDriver().close();
            }

            //go to new window
            actor.attemptsTo(
                    //Switch.toWindow("93E8B3BF76FCF02E9D8626496CEB93D3") //WORK
                    //Switch.toWindowTitled("Inbox") //WORK
                    //Switch.toTheOtherWindow() //WORK
                    Switch.toNewWindow() //WORK
            );

            //actions in new window
            if(this.actions != null)
            {
                actor.attemptsTo(
                        this.actions
                );
            }

            if(!closeActualTab && !stayOnNewTab)
            {
                //back to original window
                actor.attemptsTo(
                        Switch.toWindow(actualWindow)
                );
            }

        }catch(Exception e){
            LogUtil.warn(e);
        }
    }

    public static SwitchTab recent()
    {
        return SwitchTab.builder().build();
    }

    public SwitchTab andPerform(Performable ... actions)
    {
        this.actions = actions;
        return this;
    }

    public SwitchTab andStayOnNewTab()
    {
        this.stayOnNewTab = true;
        return this;
    }

    public SwitchTab andCloseActualTab()
    {
        this.closeActualTab = true;
        return this;
    }
}