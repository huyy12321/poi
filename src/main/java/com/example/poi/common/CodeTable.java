/*
 * Project: util-root
 * 
 * File Created at 2014-10-08
 
 * Copyright 2012 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.example.poi.common;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@SuppressWarnings("all")
/**
 * 响应码对照表
 *
 *
 * @version V1.0
 * @since 2014-10-08 11:24
 */
public enum CodeTable implements Serializable {

    //服务 [000]-[099]
    SUCCESS(0, "成功!"),
    EXCEPTION(1, "失败"),
    ERROR(2, "参数错误."),
    DATA_HAS_EXIST(3, "数据已存在!"),
    DATA_NONE_EXIST(4, "数据不存在"),
    ILLEGAL(5, "非法请求"),
    CAPTCHA_ERROR(7, "验证码错误"),
    CARD_NONE_EXIST(8, "充值卡不存在"),
    DATA_MERGE(9,"购物车数据合并"),
    DATA_STATE_ERROR(100, "数据状态不正确"),
    PASSWORD_ERROR(101, "密码不正确！"),
    ERROR_ACCOUNT_FEE_LESS(102, "账户余额不足"),
    ACCESS_DENIAL(103, "token过期"),
    NO_PERMISSION(104, "没有操作权限"),
    DATA_200(200, "服务器异常");
    /**
     * 存放CODE -> Enum的Map
     */
    private static final ConcurrentMap<Integer, CodeTable> CODE_MAP = new ConcurrentHashMap<Integer, CodeTable>(
            CodeTable.values().length);

    /**
     * 填充CODE --> Enum的Map
     */
    static {
        for (CodeTable codeTable : CodeTable.values()) {
            CODE_MAP.put(codeTable.code, codeTable);
        }
    }

    /**
     * 响应码
     */
    private final int code;

    /**
     * 响应消息
     */
    private final String message;

    /**
     * 构造函数
     *
     * @param code    响应码
     * @param message 响应消息
     */
    CodeTable(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public CodeTable fromCode(Integer code) {
        return CODE_MAP.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
