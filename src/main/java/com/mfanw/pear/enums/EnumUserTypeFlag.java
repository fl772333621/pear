package com.mfanw.pear.enums;

/**
 * <b></b>
 * <p>
 * 描述
 * </p>
 * 
 * @version 2017年11月28日 下午3:03:00
 * @author mengwei
 */
public enum EnumUserTypeFlag {

    /**
     * 0 - 系统管理员
     */
    SYSTEM(0, "系统管理员"),
    /**
     * 1 - 管理员
     */
    ADMIN(1, "管理员"),
    /**
     * 2 - 用户
     */
    USER(0, "用户"),;

    private Integer code;

    private String name;

    private EnumUserTypeFlag(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static EnumUserTypeFlag getEnum(Integer value) {
        for (EnumUserTypeFlag enumValue : EnumUserTypeFlag.values()) {
            if (enumValue.getCode().equals(value)) {
                return enumValue;
            }
        }

        return null;
    }

    public static Integer[] getCodes() {
        EnumUserTypeFlag[] values = EnumUserTypeFlag.values();
        Integer[] result = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i].getCode();
        }
        return result;
    }
}
