package com.company.product.userinterfaces.general.app.screen;

import com.company.product.models.dtos.userinterfaces.app.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.interfaces.app.IUserInterface;

/**
 * For more information:
 * @see UIJavaDoc#CLASS
 */
public enum AppContentUI implements IUserInterface
{

    LBL_TEXT("appview.contain.text"),
    LBL_TEXT_WITH_APOSTROPHE("appview.contain.text.withApostrophe"),
    LBL_TEXT_EXACTLY("appview.contain.text.exactly"),
    LBL_TEXT_EXACTLY_WITH_APOSTROPHE("appview.contain.text.exactly.withApostrophe"),

    ;

    private final String id;
    private UserInterfaceDTO ui;
    //private final String name;
    //private final String stringSelector;

    /**
     * For more information:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    AppContentUI(String id){
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
        this.ui=ui;
    }

}
