package pers.justep.crawlerbilibili.service;

import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoPojo;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @classname BiliBiliRankInfoService
 * @description interface
 * @createtime 2019/09/18 23:12:00
 */
public interface BiliBiliRankService {
    /**
     * 处理RankInfo
     * @param rankInfos 获取的rank数据
     * */
    void handleRankInfo(List<BiliBiliRankInfoPojo> rankInfos);
}
