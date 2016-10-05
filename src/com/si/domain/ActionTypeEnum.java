package com.si.domain;


/**
 * Created by Saranda Ilazi on 22/09/2016.
 */
public enum ActionTypeEnum {
    WITHDRAWAL(1),
    DEPOSIT(2),
    BALANCE(3);

    private int value;

    ActionTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ActionTypeEnum getEnumValue(int value) {
        for (ActionTypeEnum actionTypeEnum : ActionTypeEnum.values()) {
            if(actionTypeEnum.getValue() == value) {
                return actionTypeEnum;
            }
        }
        return null;
    }
}