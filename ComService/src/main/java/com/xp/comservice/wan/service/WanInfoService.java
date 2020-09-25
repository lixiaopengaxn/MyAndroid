package com.xp.comservice.wan.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.xp.comservice.wan.bean.WanInfo;

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
 * @title: WanInfoService
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/256:13 PM
 */
public interface WanInfoService extends IProvider {
    WanInfo getInfo();
}
