package com.tsgl.enums;

public enum IS_LB {
	yes(1,"轮播显示"),
    no(0,"正常显示");
    private int value;
    private String description;
    private IS_LB(int value,String description){
        this.setValue(value);
        this.setDescription(description);
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}
