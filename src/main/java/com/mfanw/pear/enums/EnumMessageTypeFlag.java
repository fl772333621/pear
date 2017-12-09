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
public enum EnumMessageTypeFlag {

    /**
     * 0 - 未读
     */
    NORMAL(0, "未读"),
    /**
     * 1 - 已读
     */
    READ(1, "已读"),;

    private Integer code;

    private String name;

    private EnumMessageTypeFlag(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static EnumMessageTypeFlag getEnum(Integer value) {
        for (EnumMessageTypeFlag enumValue : EnumMessageTypeFlag.values()) {
            if (enumValue.getCode().equals(value)) {
                return enumValue;
            }
        }

        return null;
    }

    public static Integer[] getCodes() {
        EnumMessageTypeFlag[] values = EnumMessageTypeFlag.values();
        Integer[] result = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i].getCode();
        }
        return result;
    }
}
