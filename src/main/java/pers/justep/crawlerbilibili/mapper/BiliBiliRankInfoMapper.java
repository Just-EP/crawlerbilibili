package pers.justep.crawlerbilibili.mapper;

import org.springframework.stereotype.Repository;
import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoPojo;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @classname BiliBiliRankInfoPojoMapper
 * @description Mapper
 * @createtime 2019/09/22 13:12:00
 */
@Repository
public interface BiliBiliRankInfoMapper {
    /**
     * 榜单数据入库
     * @param rankInfo bean
     * */
    void insertRankInfo(BiliBiliRankInfoPojo rankInfo);
    /**
     * 查询所有
     * @return list
     * */
    List<BiliBiliRankInfoPojo> queryAllRankInfo();
    /**
     * 分页查询
     * @param start limit开始
     * @param end limit结束
     * @return beans
     * */
    List<BiliBiliRankInfoPojo> queryAllRankInfoByPage(int start, int end);
    /**
     * 查询总数
     * @return count
     * */
    int queryAllRankInfoCount();
}
