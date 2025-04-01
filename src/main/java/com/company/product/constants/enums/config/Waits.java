package com.company.product.constants.enums.config;

import lombok.Getter;

@Getter
public enum Waits {

    GENERAL(20),

    ;

    private final long time;

    Waits(long time){
        this.time = time;
    }

}
