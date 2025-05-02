package com.company.product.models.dtos.userinterfaces.app;

import com.company.product.utils.params.ParamsUtil;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;
import org.openqa.selenium.By;


@Builder
@Data
public class UserInterfaceDTO
{

    private String id;

    private String name;

    private String selectorAndroid;
    private String selectorIOS;

    public Target getTarget(Object ... parameters)
    {
        String nameFixed = ParamsUtil.processParameters(this.name,parameters);
        String selectorAndroidFixed = ParamsUtil.processParameters(this.selectorAndroid,parameters);
        String selectorIOSFixed = ParamsUtil.processParameters(this.selectorIOS,parameters);

        return this.getStrategy(
                Target.the(nameFixed),
                selectorAndroidFixed,
                selectorIOSFixed
        );
    }

    private Target getStrategy(
            TargetBuilder target,
            String stringSelectorAndroid,
            String stringSelectorIOS
    ) {
        return target.locatedForAndroid(
                By.xpath(stringSelectorAndroid)
        ).locatedForIOS(
                By.xpath(stringSelectorIOS)
        );
    }
}
