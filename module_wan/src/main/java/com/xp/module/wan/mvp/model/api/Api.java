package com.xp.module.wan.mvp.model.api;

import retrofit2.http.GET;

/**
 * ================================================
 * 存放一些与 API 有关的东西,如请求地址,请求码等
 * <p>
 * Created by MVPArmsTemplate on 09/25/2020 17:59
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
public interface Api {
    /**
     * base_url
     */
    String APP_DOMAIN = "https://www.wanandroid.com/";


    String WAN_DOMAIN_NAME = "wan";

    /**
     * 获取公众号列表
     * GET
     */
    String wx_article_chapters = "/wxarticle/chapters/json";
}
