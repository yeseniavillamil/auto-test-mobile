package com.company.product.interactions.basics.web.window.frame;


import lombok.AllArgsConstructor;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.targets.Target;

@Builder
public class InFrame
{
    private Target[] frameLocations;
    private boolean stayOnFrame;

    @AllArgsConstructor
    private class InFrameLocated implements Interaction
    {
        private Performable[] actions;

        @Override
        public <T extends Actor> void performAs(T actor)
        {
            if(frameLocations!=null){
                for (Target frameLocation: frameLocations) {
                    actor.attemptsTo(
                            Switch.toFrame(frameLocation.resolveFor(actor))
                    );
                }
            }

            if(this.actions != null){
                actor.attemptsTo(
                        this.actions
                );
            }

            if(!stayOnFrame){
                actor.attemptsTo(
                        Switch.toDefaultContext()
                );
            }
        }
    }

    public static InFrame located(Target... frameLocations)
    {
        return InFrame.builder()
            .frameLocations(frameLocations)
            .build();
    }

    public static InFrame located(boolean stayOnFrame,Target... frameLocations)
    {
        return InFrame.builder()
                .frameLocations(frameLocations)
                .stayOnFrame(stayOnFrame)
                .build();
    }

    public InFrameLocated perform(Performable ... actions)
    {
        return new InFrameLocated(actions);
    }
}
