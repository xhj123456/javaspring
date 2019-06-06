package com.service;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.mail.EmailException;
import org.springframework.stereotype.Service;

public interface EmailCodeService {
    JSONObject sendEmailCode(String emailName) throws EmailException;
}
