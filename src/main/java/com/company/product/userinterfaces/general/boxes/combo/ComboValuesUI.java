package com.company.product.userinterfaces.general.boxes.combo;

import com.company.product.models.dtos.userinterfaces.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.interfaces.IUserInterface;

/**
 * For more information:
 * @see UIJavaDoc#CLASS
 */
public enum ComboValuesUI implements IUserInterface
{

    ITEM_LIST("boxes.combo"),

    ;

    private final String id;
    private UserInterfaceDTO ui;

    /**
     * For more information:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    ComboValuesUI(String id){
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
