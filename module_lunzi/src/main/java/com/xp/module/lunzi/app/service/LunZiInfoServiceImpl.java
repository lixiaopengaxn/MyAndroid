package com.xp.module.lunzi.app.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.utils.ArmsUtils;
import com.xp.comsdk.core.RouterHub;
import com.xp.comservice.lunzi.bean.LunZiInfo;
import com.xp.comservice.lunzi.service.LunZiInfoService;
import com.xp.module.lunzi.R;

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
 * @title: LunZiInfoServiceImpl
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/257:26 PM
 */
@Route(path = RouterHub.LUNZI_I.LUNZI_SERVICE_ELEINFOSERVIEW,name = "轮子的木模块")
public class LunZiInfoServiceImpl implements LunZiInfoService {
    private Context mContext;
    @Override
    public LunZiInfo getInfo() {
        return new LunZiInfo(ArmsUtils.getString(mContext, R.string.public_name_lun));
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
