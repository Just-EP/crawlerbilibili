package pers.justep.crawlerbilibili.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import pers.justep.crawlerbilibili.bot.CommonBot;

/**
 * @author JustEP
 * @version 1.0
 * @classname MessageServiceImpl
 * @description telegram 信息处理内部逻辑
 * @createtime 2019/10/22 22:22:00
 */
@Service
public class MessageServiceImpl implements MessageService{
    private final CommonBot commonBot;

    public MessageServiceImpl(CommonBot commonBot) {
        this.commonBot = commonBot;
    }

    @Override
    public void registerCommonBot(){
        try {
            TelegramBotsApi api = new TelegramBotsApi();
            api.registerBot(commonBot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
