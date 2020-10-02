package com.xp.coms.utils;

import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.utils.ArmsUtils;
import com.xp.coms.layout.titlebar.TitleBar;

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
 * @title: ComCustom
 * @projectName MyAndroid
 * @description: TODO
 * @date 2020/9/264:58 PM
 */
public class ComCustom {

    private ComCustom() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    /**
     * 递归获取 ViewGroup 中的 TitleBar 对象
     */
    public static TitleBar obtainTitleBar(ViewGroup group) {
        for (int i = 0; i < group.getChildCount(); i++) {
            View view = group.getChildAt(i);
            if ((view instanceof TitleBar)) {
                return (TitleBar) view;
            } else if (view instanceof ViewGroup) {
                TitleBar titleBar = obtainTitleBar((ViewGroup) view);
                if (titleBar != null) {
                    return titleBar;
                }
            }
        }
        return null;
    }




}
