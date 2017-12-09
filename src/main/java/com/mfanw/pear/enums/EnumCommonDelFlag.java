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
public enum EnumCommonDelFlag {

    /**
     * 0 - 正常
     */
    NORMAL(0, "正常"),
    /**
     * 1 - 已删除
     */
    DELETED(1, "已删除");

    private Integer code;

    private String name;

    private EnumCommonDelFlag(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static EnumCommonDelFlag getEnum(Integer value) {
        for (EnumCommonDelFlag enumValue : EnumCommonDelFlag.values()) {
            if (enumValue.getCode().equals(value)) {
                return enumValue;
            }
        }

        return null;
    }

    public static Integer[] getCodes() {
        EnumCommonDelFlag[] values = EnumCommonDelFlag.values();
        Integer[] result = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i].getCode();
        }
        return result;
    }
}
