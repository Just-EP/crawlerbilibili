package pers.justep.crawlerbilibili.mapper;

import org.springframework.stereotype.Repository;
import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoPojo;

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
}
