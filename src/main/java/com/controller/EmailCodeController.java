package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.service.EmailCodeService;
import jdk.nashorn.internal.runtime.JSONListAdapter;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class EmailCodeController {
    @Autowired
    EmailCodeService emailCodeService;
    @RequestMapping("/email")
    public JSONObject email(@RequestParam(value = "email")String emailName) throws EmailException {
        return emailCodeService.sendEmailCode(emailName);
    }
}
