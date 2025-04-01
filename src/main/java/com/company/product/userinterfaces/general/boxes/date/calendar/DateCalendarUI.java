package com.company.product.userinterfaces.general.boxes.date.calendar;

import com.company.product.models.dtos.userinterfaces.UserInterfaceDTO;
import com.company.product.userinterfaces.javadoc.UIJavaDoc;
import com.company.product.utils.userinterfaces.interfaces.IUserInterface;

/**
 * For more information:
 * @see UIJavaDoc#CLASS
 */
public enum DateCalendarUI implements IUserInterface
{

    CAL_DATE_CALENDAR("boxes.datecalendar"),
    BTN_BACK_YEARS("boxes.datecalendar.back years"),
    BTN_VIEW_MONTHS("boxes.datecalendar.change view.to month"),
    BTN_VIEW_YEARS("boxes.datecalendar.change view.to years"),
    BTN_YEAR("boxes.datecalendar.year"),
    BTN_MONTH("boxes.datecalendar.month"),
    BTN_DAY("boxes.datecalendar.day"),

    ;

    private final String id;
    private UserInterfaceDTO ui;

    /**
     * For more information:
     * @see UIJavaDoc#CONSTRUCTOR
     */
    DateCalendarUI(String id){
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
