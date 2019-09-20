package pers.justep.crawlerbilibili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@MapperScan("pers.justep.crawlerbilibili.mapper")
@EnableRedisRepositories("pers.justep.crawlerbilibili.redis")
public class CrawlerbilibiliApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlerbilibiliApplication.class, args);
    }

}
