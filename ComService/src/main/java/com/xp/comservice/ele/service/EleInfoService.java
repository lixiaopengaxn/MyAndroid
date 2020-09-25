package com.xp.comservice.ele.service;

import com.alibaba.android.arouter.facade.template.IProvider;
import com.xp.comservice.ele.bean.EleInfo;

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
 * @title: EleInfoService
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/245:17 PM
 */
public interface EleInfoService extends IProvider {

    EleInfo getInfo();
}
