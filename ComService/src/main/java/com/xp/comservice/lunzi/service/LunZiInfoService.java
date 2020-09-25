package com.xp.comservice.lunzi.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.xp.comservice.lunzi.bean.LunZiInfo;

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
 * @title: LunZiInfoService
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/257:29 PM
 */
public interface LunZiInfoService extends IProvider {
    LunZiInfo getInfo();
}
