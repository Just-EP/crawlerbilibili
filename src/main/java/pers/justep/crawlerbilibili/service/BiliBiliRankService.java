package pers.justep.crawlerbilibili.service;

import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoPojo;
import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoView;

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
    /**
     * 查询所有
     * @return beans
     * */
    List<BiliBiliRankInfoPojo> queryAllRankInfo();
    /**
     * 分页查询,转换分页信息
     * @param limit 每页显示条数
     * @param page 当前页数
     * @param view 返回bean
     * @return beans
     * */
    BiliBiliRankInfoView queryAllRankInfoByPage(String page,String limit,BiliBiliRankInfoView view);
}
