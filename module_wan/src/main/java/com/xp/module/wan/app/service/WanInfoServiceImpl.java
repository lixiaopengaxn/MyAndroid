package com.xp.module.wan.app.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.utils.ArmsUtils;
import com.xp.comsdk.core.RouterHub;
import com.xp.comservice.wan.bean.WanInfo;
import com.xp.comservice.wan.service.WanInfoService;
import com.xp.module.wan.R;

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
 * @title: WanInfoServiceImpl
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/257:07 PM
 */
@Route(path = RouterHub.WAN_I.WAN_SERVICE_ELEINFOSERVIEW,name = "玩Android服务")
public class WanInfoServiceImpl implements WanInfoService {
    private Context mContext;
    @Override
    public WanInfo getInfo() {
        return new WanInfo(ArmsUtils.getString(mContext, R.string.public_name_wan));
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
