package com.xp.module.ele.app.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.utils.ArmsUtils;
import com.xp.comsdk.core.RouterHub;
import com.xp.comservice.ele.bean.EleInfo;
import com.xp.comservice.ele.service.EleInfoService;
import com.xp.module.ele.R;

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
 * @title: EleInfoServiceImpl
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/255:16 PM
 */
@Route(path = RouterHub.ELE_I.ELE_SERVICE_ELEINFOSERVIEW,name = "电力信息服务")
public class EleInfoServiceImpl implements EleInfoService {
    private Context mContext;

    @Override
    public EleInfo getInfo() {
        return new EleInfo(ArmsUtils.getString(mContext, R.string.public_name_ele));
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
