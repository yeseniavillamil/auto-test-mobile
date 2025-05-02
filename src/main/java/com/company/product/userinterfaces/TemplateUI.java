package com.company.product.userinterfaces;

import com.company.product.models.dtos.userinterfaces.web.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.interfaces.web.IUserInterface;

/**
 * For more information:
 * @see UIJavaDoc#CLASS
 */
public enum TemplateUI implements IUserInterface {

    TXT_NAME_TEXT_BOX("feature.id-textbox"),

    BTN_NAME_BUTTON("feature.id-button"),

    CHK_NAME_CHECK_BOX("feature.id-checkbox"),

    CMB_NAME_LIST_VALUE("feature.id-listvalue"),

    ;

    private final String id;
    private UserInterfaceDTO ui;
    //private final String name;
    //private final String stringSelector;

    /**
     * For more information:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    TemplateUI(String id){
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
