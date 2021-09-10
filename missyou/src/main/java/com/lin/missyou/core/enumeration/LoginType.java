package com.lin.missyou.core.enumeration;

public enum LoginType {

    USER_WX(0, "微信登陆"),
    USER_Email(1, "邮箱登陆");

    private Integer value;
    LoginType(Integer value, String description) {
        this.value = value;
    }
    public void test() {

    }
}
