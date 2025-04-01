package com.company.product.models.dtos.userinterfaces;

import com.company.product.utils.params.ParamsUtil;
import lombok.Builder;
import lombok.Data;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.targets.TargetBuilder;


@Builder
@Data
public class UserInterfaceDTO
{

    private String id;

    private String name;

    private String selector;

    public Target getTarget(Object ... parameters)
    {
        String nameFixed = ParamsUtil.processParameters(this.name,parameters);
        String selectorFixed = ParamsUtil.processParameters(this.selector,parameters);

        return this.getStrategy(
                Target.the(nameFixed),
                selectorFixed
        );
    }

    private Target getStrategy(TargetBuilder target, String stringSelector)
    {
        return target.locatedBy(stringSelector);
    }
}
