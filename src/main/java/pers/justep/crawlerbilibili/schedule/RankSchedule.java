package pers.justep.crawlerbilibili.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pers.justep.crawlerbilibili.crawler.RankCrawler;
import pers.justep.crawlerbilibili.crawler.fix.HttpClientDownloader;
import us.codecraft.webmagic.Spider;

import java.util.Date;

/**
 * @author JustEP
 * @version 1.0
 * @classname RankSchedule
 * @description 自动任务
 * @createtime 2019/09/22 21:54:00
 */
@Component
public class RankSchedule {
    private RankCrawler rankCrawler;
    @Autowired
    public void setRankCrawler(RankCrawler rankCrawler) {
        this.rankCrawler = rankCrawler;
    }
    public void start(){
        Spider.create(rankCrawler).setDownloader(new HttpClientDownloader()).addUrl("https://www.bilibili.com/ranking/all/1/1/3/").thread(5).run();
    }
}
