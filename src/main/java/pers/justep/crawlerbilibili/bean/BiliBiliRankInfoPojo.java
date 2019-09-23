package pers.justep.crawlerbilibili.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author JustEP
 * @version 1.0
 * @classname BiliBiliRankInfoPojo
 * @description 排行榜Bean
 * @createtime 2019/09/18 22:35:00
 */
@Data
public class BiliBiliRankInfoPojo {
    private Integer rank;
    private String title;
    private String videoUrl;
    private String play;
    private String danmaku;
    private String author;
    private String authorUrl;
    private Integer score;
    private String type;
    private String subType;
    private String contributeType;
    private String termType;
    private Date time;
}
