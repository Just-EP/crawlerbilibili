package pers.justep.crawlerbilibili.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.justep.crawlerbilibili.bean.BiliBiliRankInfoView;
import pers.justep.crawlerbilibili.service.BiliBiliRankService;

/**
 * @author JustEP
 * @version 1.0
 * @classname IndexController
 * @description 首页
 * @createtime 2019/09/13 11:21:00
 */
@Controller
public class IndexController {
    private BiliBiliRankService service;
    @Autowired
    public void setService(BiliBiliRankService service) {
        this.service = service;
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "/index";
    }

    @RequestMapping(value = "/query")
    @ResponseBody
    public BiliBiliRankInfoView query(String page,String limit){
        BiliBiliRankInfoView view = new BiliBiliRankInfoView();
        view = service.queryAllRankInfoByPage(page, limit, view);
        return view;
    }
}
