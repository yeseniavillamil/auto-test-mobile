package com.company.product.userinterfaces.features.account.login;


import com.company.product.models.dtos.userinterfaces.app.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.interfaces.app.IUserInterface;

/**
 * For more information:
 * @see UIJavaDoc#CLASS
 */
public enum LoginUI implements IUserInterface {

    TXT_USERNAME("login.username"),
    TXT_PASSWORD("login.password"),
    BTN_SIGNIN("login.signin"),



    ;


    private final String id;

    private UserInterfaceDTO ui;

    /**
     * For more information:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    LoginUI(String id){
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
