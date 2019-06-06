package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.service.EmailCodeService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
@PropertySource("classpath:config/config.properties")
public class EmailCodeServiceImpl implements EmailCodeService {
    @Value("${emailHostName}")
    private String emailHostName;
    @Value("${emailCharset}")
    private String emailCharset;
    @Value("${emailFrom}")
    private String emailFrom;
    @Value("${emailName}")
    private String emailName;
    @Value("${emailCode}")
    private String emailCode;
    @Override
    public JSONObject sendEmailCode(String emailName) throws EmailException {
        HtmlEmail email = new HtmlEmail();
        email.setHostName(emailHostName);
        email.setCharset(emailCharset);
        email.addTo(emailName);
        email.setFrom(emailFrom,emailName);
        email.setAuthentication(emailFrom,emailCode);
        email.setSubject("测试");
        int max = 999999;
        int min = 100000;
        int floor = new Random().nextInt(max-min)+min;
        email.setMsg("您的验证码是："+floor);
        String send = email.send();
        JSONObject json = new JSONObject();
        json.put("status",200);
        json.put("msg",send);
        json.put("code",floor);
        return json;
    }
}
