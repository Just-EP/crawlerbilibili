package pers.justep.crawlerbilibili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.justep.crawlerbilibili.service.MessageService;

/**
 * @author JustEP
 * @version 1.0
 * @classname MessageController
 * @description 可接收telegram发送来的信息作为请求
 * @createtime 2019/10/22 22:09:00
 */
@RestController()
@RequestMapping("/message")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @RequestMapping("/start")
    public String startBot() {
        System.out.println("Hello");
        service.registerCommonBot();
        return null;
    }
}
