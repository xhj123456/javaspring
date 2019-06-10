package com.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.mail.EmailException;

public interface EmailCodeService {
    /**
     * 发送邮箱验证码
     * @param emailName
     * @return
     * @throws EmailException
     */
    JSONObject sendEmailCode(String emailName) throws EmailException;
    Boolean validateEmailCode(String code);
}
