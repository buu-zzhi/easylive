package com.easylive.entity.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserSexEnum {
    MAN(1, "男"),
    WOMAN(0, "女"),
    SECRET(2, "未知");;

    private Integer status;
    private String desc;

    public static UserSexEnum getByStatus(Integer status) {
        for (UserSexEnum item : UserSexEnum.values()) {
            if (item.getStatus().equals(status)) {
                return item;
            }
        }
        return null;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
