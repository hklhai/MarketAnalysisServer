package com.hxqh.ma.controller;

import com.hxqh.ma.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Ocean lin on 2017/7/1.
 *
 * @author Lin
 */
@Controller
@RequestMapping("/show")
public class ShowController {

    @Autowired
    private SystemService systemService;


    /**
     * 上映电影页面跳转接口
     *
     * @return
     */
    @RequestMapping("/filming")
    public String filming() {
        return "show/filming";
    }

    /**
     * 电影页面跳转接口
     *
     * @return
     */
    @RequestMapping("/film")
    public String user() {
        return "show/film";
    }

    /**
     * 网络文学页面跳转接口
     *
     * @return
     */
    @RequestMapping("/netLiterature")
    public String netLiterature() {
        return "show/netLiterature";
    }


    /**
     * 电视剧页面跳转接口
     *
     * @return
     */
    @RequestMapping("/tvSeries")
    public String tvSeries() {
        return "show/tvSeries";
    }


    /**
     * 综艺页面跳转接口
     *
     * @return
     */
    @RequestMapping("/variety")
    public String variety() {
        return "show/variety";
    }

    /**
     * 图书页面跳转接口
     *
     * @return
     */
    @RequestMapping("/book")
    public String book() {
        return "show/book";
    }


}
