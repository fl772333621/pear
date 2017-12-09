package com.mfanw.pear.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

    private static final long serialVersionUID = 5872150911602659316L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 上级（0表示无上级）
     */
    private Integer manager;

    /**
     * 登录名称
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 用户类型：0消费者，1超级管理员，2经理，3普通员工
     */
    private Integer typeFlag;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 余额
     */
    private Double money;

    /**
     * 创建者
     */
    private Integer creator;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改者
     */
    private Integer modifier;

    /**
     * 修改时间
     */
    private String modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManager() {
        return manager;
    }

    public void setManager(Integer manager) {
        this.manager = manager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(Integer typeFlag) {
        this.typeFlag = typeFlag;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("UserEntity [");
        if (id != null) {
            sb.append("id=" + getId() + ",");
        }
        if (manager != null) {
            sb.append("manager=" + getManager() + ",");
        }
        if (username != null) {
            sb.append("username=" + getUsername() + ",");
        }
        if (password != null) {
            sb.append("password=" + getPassword() + ",");
        }
        if (typeFlag != null) {
            sb.append("typeFlag=" + getTypeFlag() + ",");
        }
        if (nickname != null) {
            sb.append("nickname=" + getNickname() + ",");
        }
        if (phone != null) {
            sb.append("phone=" + getPhone() + ",");
        }
        if (address != null) {
            sb.append("address=" + getAddress() + ",");
        }
        if (money != null) {
            sb.append("money=" + getMoney() + ",");
        }
        if (creator != null) {
            sb.append("creator=" + getCreator() + ",");
        }
        if (createTime != null) {
            sb.append("createTime=" + getCreateTime() + ",");
        }
        if (modifier != null) {
            sb.append("modifier=" + getModifier() + ",");
        }
        if (modifyTime != null) {
            sb.append("modifyTime=" + getModifyTime() + ",");
        }
        if (sb.indexOf(",") > -1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

}
