package com.company.product.utils.userinterfaces.interfaces;


import com.company.product.models.dtos.userinterfaces.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.UserInterfacesUtil;
import net.serenitybdd.screenplay.targets.Target;

public interface IUserInterface {

    /**
     * For more information:
     * @see UIJavaDoc#TARGET
     */
    default Target getTarget(Object ... parameters)
    {
        if(this.getUI() == null){
            this.setUI(UserInterfacesUtil.getInstance().getUserInterface(this.getId()));
        }

        return this.getUI().getTarget(parameters);

        /*String name = ParamsUtil.processParamters(this.getUI().getName(),parameters);
        String stringSelector = ParamsUtil.processParamters(this.getUI().getSelector(),parameters);

        return this.getStrategy(
            Target.the(name),
            stringSelector
        );*/
    }

    /*default Target getStrategy(TargetBuilder target, String stringSelector)
    {
        return target.locatedBy(stringSelector);
    }*/

    /**
     * For more information:
     * @see UIJavaDoc#STRING_SELECTOR
     */
    @Deprecated
    String getStringSelector();

    /**
     * For more information:
     * @see UIJavaDoc#NAME
     */
    @Deprecated
    String getName();


    String getId();

    UserInterfaceDTO getUI();

    void setUI(UserInterfaceDTO ui);
}
