package pers.justep.crawlerbilibili.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.FileReader;
import java.util.Objects;
import java.util.Properties;

/**
 * @author JustEP
 * @version 1.0
 * @classname RepeatBot
 * @description 复读bot
 * @createtime 2019/10/22 22:12:00
 */
@Component
public class RepeatBot extends TelegramLongPollingBot {
    private static String bot_token =  null;
    private static String bot_name =  null;
    static {
        Properties properties = new Properties();
        try {
            String path = Objects.requireNonNull(RepeatBot.class.getClassLoader().getResource("botconfig.properties")).getPath();
            properties.load(new FileReader(path));
            bot_token = (String) properties.get("bot_token");
            bot_name = (String) properties.get("bot_name");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            System.out.println(update.getMessage().getText());
        }
    }

    @Override
    public String getBotUsername() {
        return bot_name;
    }

    @Override
    public String getBotToken() {
        return bot_token;
    }
}
