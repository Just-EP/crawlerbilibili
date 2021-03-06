package pers.justep.crawlerbilibili.bean;

import lombok.Data;

import java.util.List;

/**
 * @author JustEP
 * @version 1.0
 * @date 2019/09/18 22:35:00
 * LayUi数据表格
 */
@Data
public class BiliBiliRankInfoView {
    private Integer code;
    private String msg;
    private Integer count;
    private List<BiliBiliRankInfoPojo> data;
}
