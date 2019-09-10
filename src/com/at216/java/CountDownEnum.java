package com.at216.java;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @Classname CountDownEnum
 * @Description TODO
 * @Date 2019/9/10 15:49
 * @Created by 10474
 */
public enum  CountDownEnum {

    ONE(1,"春天"),TOW(2,"夏天"),THREE(3,"秋天"),FOUR(4,"冬天"),FIVE(5,"阴天"),SIX(6,"晴天");

    private Integer newCode;
    private String newMess;

    public Integer getNewCode() {
        return newCode;
    }

    public String getNewMess() {
        return newMess;
    }

    CountDownEnum(Integer newCode, String newMess) {
        this.newCode = newCode;
        this.newMess = newMess;
    }

    public static CountDownEnum forEach_CountDownEnum(int index){
        CountDownEnum[] values = CountDownEnum.values();
        for (CountDownEnum value : values) {
            if(value.getNewCode()==index){
                return value;
            }
        }
        return null;
    }
}
