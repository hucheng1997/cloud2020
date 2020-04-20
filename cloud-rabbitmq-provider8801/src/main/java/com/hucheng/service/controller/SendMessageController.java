package com.hucheng.service.controller;

import com.hucheng.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HuChan
 */
@RestController
public class SendMessageController {
    @Autowired
    private IMessageProvider provider;

    @GetMapping("/sendMessage")
    public void sendMessage() {
         provider.send();
    }
}
