package com.company.product.models.scena;


import com.company.product.models.params.TemplateParams;
import com.company.product.models.params.features.account.login.LoginParams;
import com.company.product.models.params.general.screen.StateElementParams;
import com.company.product.models.params.general.screen.TextElementParams;
import com.company.product.models.params.general.screen.TextZoneParams;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NoteBook {

    private TemplateParams paramsTemplate;

    @JsonProperty("login")
    private LoginParams paramsLogin;



    @JsonProperty("stateElement")
    private StateElementParams paramsStateElement;
    private List<StateElementParams> lstParamsStateElement;

    @JsonProperty("textZone")
    private TextZoneParams paramsTextZone;
    private List<TextZoneParams> lstParamsTextZone;

    @JsonProperty("textElement")
    private TextElementParams paramsTextElement;
    private List<TextElementParams> lstParamsTextElement;

    public void setParamsStateElement(StateElementParams paramsStateElement) {
        //this.paramsStateElement = paramsStateElement;// NO WORK, REPLACE ALL ITEMS IN THE LIST
        this.getLstParamsStateElement().add(paramsStateElement);
    }

    public List<StateElementParams> getLstParamsStateElement() {
        if (this.lstParamsStateElement ==null){
            this.lstParamsStateElement =new ArrayList<>();
        }
        return this.lstParamsStateElement;
    }

    public void setParamsTextZone(TextZoneParams paramsTextZone) {
        //this.paramsTextZone = paramsTextZone; // NO WORK, REPLACE ALL ITEMS IN THE LIST
        this.getLstParamsTextZone().add(paramsTextZone);
    }

    public List<TextZoneParams> getLstParamsTextZone() {
        if (this.lstParamsTextZone ==null){
            this.lstParamsTextZone =new ArrayList<>();
        }
        return this.lstParamsTextZone;
    }

    public void setParamsTextElement(TextElementParams paramsTextElement) {
        //this.paramsTextElement = paramsTextElement; // NO WORK, REPLACE ALL ITEMS IN THE LIST
        this.getLstParamsTextElement().add(paramsTextElement);
    }

    public List<TextElementParams> getLstParamsTextElement() {
        if (this.lstParamsTextElement ==null){
            this.lstParamsTextElement =new ArrayList<>();
        }
        return this.lstParamsTextElement;
    }


}

