package pers.justep.crawlerbilibili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.telegram.telegrambots.ApiContextInitializer;

/**
 * 启动类
 * @author JustEP
 * */
@SpringBootApplication
@MapperScan("pers.justep.crawlerbilibili.mapper")
@EnableRedisRepositories("pers.justep.crawlerbilibili.redis")
@EnableScheduling
public class CrawlerbilibiliApplication {
    public static void main(String[] args)
    {
        //本机设置代理
        String proxyHost = "127.0.0.1";
        String proxyPort = "10808";
        System.setProperty("socksProxyHost", proxyHost);
        System.setProperty("socksProxyPort", proxyPort);

        ApiContextInitializer.init();
        SpringApplication.run(CrawlerbilibiliApplication.class, args);
    }
}
