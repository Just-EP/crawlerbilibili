package pers.justep.crawlerbilibili.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoPojo;
import pers.justep.crawlerbilibili.mapper.BiliBiliRankInfoMapper;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @classname BiliBiliRankInfoServiceImpl
 * @description 实现
 * @createtime 2019/09/18 23:15:00
 */
@Service
public class BiliBiliRankServiceImpl implements BiliBiliRankService{
    private BiliBiliRankInfoMapper mapper;
    @Autowired
    public void setMapper(BiliBiliRankInfoMapper mapper) {
        this.mapper = mapper;
    }
    @Override
    public void handleRankInfo(List<BiliBiliRankInfoPojo> rankInfos) {
        //没什么需要处理的,直接调用mapper入库
        for (BiliBiliRankInfoPojo rankInfo : rankInfos) {
            mapper.insertRankInfo(rankInfo);
        }
    }

    @Override
    public List<BiliBiliRankInfoPojo> queryAllRankInfo() {
        return mapper.queryAllRankInfo();
    }
}
