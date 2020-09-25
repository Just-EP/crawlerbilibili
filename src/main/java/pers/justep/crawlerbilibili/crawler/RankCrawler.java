package pers.justep.crawlerbilibili.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoPojo;
import pers.justep.crawlerbilibili.service.BiliBiliRankService;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.xsoup.Xsoup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @date 2019/09/17 22:03:00
 */
@Component
public class RankCrawler implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    private Logger logger = LoggerFactory.getLogger(RankCrawler.class);

    private BiliBiliRankService rankService;
    @Autowired
    public void setRankService(BiliBiliRankService rankService) {
        this.rankService = rankService;
    }
    @Override
    public void process(Page page) {
        String url = page.getUrl().toString();
        String typeString = url.substring(url.indexOf("ranking/") + 8);
        String[] types = typeString.split("/");
        String type = types[0];
        String subType = types[1];
        String contributeType = types[2];
        String termType = types[3];
        List<String> lis = page.getHtml().xpath("//li[@class='rank-item']").all();
        //每次爬取100名
        List<BiliBiliRankInfoPojo> biliBiliRankInfoPojos = new ArrayList<>(100);
        for (String li : lis) {
            BiliBiliRankInfoPojo rankInfo = new BiliBiliRankInfoPojo();
            //从URL中获取榜单类型字段存入Bean
            rankInfo.setType(type);
            rankInfo.setSubType(subType);
            rankInfo.setContributeType(contributeType);
            rankInfo.setTermType(termType);
            String rank = Xsoup.select(li, "//div[@class='num']/text()").get();
            rankInfo.setRank(Integer.valueOf(rank.trim()));
            String title = Xsoup.select(li, "//div[@class='info']/a/text()").get();
            rankInfo.setTitle(title);
            String videoUrl = Xsoup.select(li, "//div[@class='info']/a/@href").get();
            videoUrl = videoUrl.substring(2);
            rankInfo.setVideoUrl(videoUrl);
            String play = Xsoup.select(li, "//div[@class='detail']/span[1]/text()").get();
            rankInfo.setPlay(play);
            String danmaku = Xsoup.select(li, "//div[@class='detail']/span[2]/text()").get();
            rankInfo.setDanmaku(danmaku);
            String author = Xsoup.select(li, "//div[@class='detail']/a/span/text()").get();
            rankInfo.setAuthor(author);
            String authorUrl = Xsoup.select(li, "//div[@class='detail']/a/@href").get();
            authorUrl = authorUrl.substring(2);
            rankInfo.setAuthorUrl(authorUrl);
            String score = Xsoup.select(li, "//div[@class='pts']/div[1]/text()").get();
            rankInfo.setScore(Integer.valueOf(score.trim()));
            rankInfo.setTime(new Date());
            biliBiliRankInfoPojos.add(rankInfo);
            logger.info("bean:{}",rankInfo);
        }
        rankService.handleRankInfo(biliBiliRankInfoPojos);
    }

    @Override
    public Site getSite() {
        return site;
    }
}
