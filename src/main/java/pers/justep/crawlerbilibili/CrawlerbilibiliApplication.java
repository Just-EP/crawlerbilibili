package pers.justep.crawlerbilibili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author JustEP
 * */
@SpringBootApplication
@MapperScan("pers.justep.crawlerbilibili.mapper")
@EnableRedisRepositories("pers.justep.crawlerbilibili.redis")
@EnableScheduling
public class CrawlerbilibiliApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrawlerbilibiliApplication.class, args);
    }
}
