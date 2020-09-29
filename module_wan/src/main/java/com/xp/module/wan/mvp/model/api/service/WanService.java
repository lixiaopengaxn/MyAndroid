package com.xp.module.wan.mvp.model.api.service;

import com.xp.module.wan.mvp.model.entity.BaseWanResponse;
import com.xp.module.wan.mvp.model.entity.WanLoginBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.xp.module.wan.mvp.model.api.Api.WAN_DOMAIN_NAME;
import static me.jessyan.retrofiturlmanager.RetrofitUrlManager.DOMAIN_NAME_HEADER;

/**
 * ...--,       .--,
 * .( (  \.---./  ) )
 * ..'.__/o   o\__.'
 * .....{=  ^  =}
 * ......>  -  <
 * ...../       \
 * ....//       \\
 * ...//|   .   |\\
 * ..."'\       /'"_.-~^`'-.
 * ......\  _  /--'         `
 * ....___)( )(___
 * ...(((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
 *
 * @author lipeng
 * @title: WanService
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/272:29 PM
 */
public interface WanService {

    /**
     * 登陆
     */
    @Headers({DOMAIN_NAME_HEADER + WAN_DOMAIN_NAME})
    @POST("user/login")
    @FormUrlEncoded
    Observable<BaseWanResponse<WanLoginBean>> toLogin(@Field("username")String userName,@Field("password")String passWord);

    /**
     * 注册
     */
    @Headers({DOMAIN_NAME_HEADER + WAN_DOMAIN_NAME})
    @POST("user/register")
    Observable<BaseWanResponse<WanLoginBean>> toRegister();

    /**
     * 退出
     */
    @Headers({DOMAIN_NAME_HEADER + WAN_DOMAIN_NAME})
    @GET("user/logout/json")
    Observable<BaseWanResponse<WanLoginBean>> toLogOut();
}
