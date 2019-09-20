package pers.justep.crawlerbilibili.crawler;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pers.justep.crawlerbilibili.crawler.fix.HttpClientDownloader;
import us.codecraft.webmagic.Spider;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author JustEP
 * @version 1.0
 * @classname RankCrawlerTest
 * @description TODO
 * @createtime 2019/09/19 23:03:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class RankCrawlerTest {
    @Autowired
    private RankCrawler rankCrawler;
    @Test
    void startCrawler() {
        /*
        * b站排行榜url https://www.bilibili.com/ranking/
        * type:all全站榜,origin原创榜,bangumi新番榜,cinema影视榜,rookie新人榜
        * subType:
        * 0全站,1动画区,168国创相关,3音乐,129舞蹈,4游戏,36科技,188数码,160生活,119鬼畜,155时尚,5娱乐,181影视
        * 13番剧,167国产动画
        * 177纪录片,23电影,11电视剧
        * contributeType:
        * 0全部投稿,1近期投稿
        * termType:
        * 3三日排行,1日排行,7周排行,30月排行
        * */
        Spider.create(rankCrawler).setDownloader(new HttpClientDownloader()).addUrl("https://www.bilibili.com/ranking/all/1/1/3/").thread(5).run();
    }
}