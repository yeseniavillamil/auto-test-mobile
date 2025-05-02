package com.company.product.userinterfaces.features.welcome;


import com.company.product.models.dtos.userinterfaces.app.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.interfaces.app.IUserInterface;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

/**
 * For more information:
 * @see UIJavaDoc#CLASS
 */
public enum OnboardingUI implements IUserInterface {

    BTN_SKIP("onboarding.skip"),


    ;

    private final String id;

    private UserInterfaceDTO ui;

    /**
     * For more information:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    OnboardingUI(String id){
        this.id = id;
    }

    @Override
    public String getStringSelector() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public UserInterfaceDTO getUI() {
        return this.ui;
    }

    @Override
    public void setUI(UserInterfaceDTO ui) {
        this.ui = ui;
    }
}
