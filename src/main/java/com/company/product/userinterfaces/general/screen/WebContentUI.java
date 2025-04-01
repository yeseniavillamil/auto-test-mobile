package com.company.product.userinterfaces.general.screen;

import com.company.product.models.dtos.userinterfaces.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.interfaces.IUserInterface;

/**
 * For more information:
 * @see UIJavaDoc#CLASS
 */
public enum WebContentUI implements IUserInterface
{

    LBL_TEXT("view.contain.text"),
    LBL_TEXT_EXACTLY("view.contain.text.exactly"),

    ;

    private final String id;
    private UserInterfaceDTO ui;
    //private final String name;
    //private final String stringSelector;

    /**
     * For more information:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    WebContentUI(String id){
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
