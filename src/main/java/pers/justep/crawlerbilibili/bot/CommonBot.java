package pers.justep.crawlerbilibili.bot;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Properties;

/**
 * @author JustEP
 * @version 1.0
 * @classname CommonBot
 * @description 接收发送信息Bot
 * @createtime 2019/10/22 22:12:00
 */
@Component
public class CommonBot extends TelegramLongPollingBot {
    private static String bot_token =  null;
    private static String bot_name =  null;
    static {
        Properties properties = new Properties();
        try {
            String path = Objects.requireNonNull(CommonBot.class.getClassLoader().getResource("botconfig.properties")).getPath();
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
            //当输入天气时返回天气预报
            //可以使用httpclient访问api
            CloseableHttpClient client = HttpClients.createDefault();
            String message = update.getMessage().getText();
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            String url = "https://api.openweathermap.org/data/2.5/weather?q=beijing&units=metric&appid=";
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
