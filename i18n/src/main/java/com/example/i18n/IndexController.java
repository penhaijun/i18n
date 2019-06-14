package com.example.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping("/msg")
    public String getMsg(String key) {
        return new MessageSourceAccessor(messageSource).getMessage(key);
    }
}
