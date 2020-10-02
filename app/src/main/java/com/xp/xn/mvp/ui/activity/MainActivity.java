/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xp.xn.mvp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.AppManager;
import com.jess.arms.utils.ArmsUtils;
import com.xp.comsdk.core.RouterHub;
import com.xp.comsdk.utils.Utils;
import com.xp.comservice.ele.service.EleInfoService;
import com.xp.comservice.lunzi.service.LunZiInfoService;
import com.xp.comservice.wan.service.WanInfoService;
import com.xp.xn.R;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * ================================================
 * 宿主 App 的主页
 *
 * @see <a href="https://github.com/JessYanCoding/ArmsComponent/wiki">ArmsComponent wiki 官方文档</a>
 * Created by JessYan on 19/04/2018 16:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
@Route(path = RouterHub.APP_MAINACTIVITY)
public class MainActivity extends BaseActivity {
    @BindView(R.id.bt_ele)
    Button mEleButton;
    @BindView(R.id.bt_wan)
    Button mWanButton;
    @BindView(R.id.bt_lunzi)
    Button mLunZiButton;

    @Autowired(name = RouterHub.ELE_I.ELE_SERVICE_ELEINFOSERVIEW)
    EleInfoService mEleInfoService;
    @Autowired(name = RouterHub.WAN_I.WAN_SERVICE_ELEINFOSERVIEW)
    WanInfoService mWanInfoService;
    @Autowired(name = RouterHub.LUNZI_I.LUNZI_SERVICE_ELEINFOSERVIEW)
    LunZiInfoService mLunZiInfoService;

    private long mPressedTime;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {

    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ArmsUtils.statuInScreen(this);
        ARouter.getInstance().inject(this);
        //这里想展示组件向外提供服务的功能, 模拟下组件向宿主提供一些必要的信息, 这里为了简单就直接返回本地数据不请求网络了
        loadELeInfo();
        loadWanInfo();
        loadLunZiInfo();
    }

    private void loadELeInfo() {
        //当非集成调试阶段, 宿主 App 由于没有依赖其他组件, 所以使用不了对应组件提供的服务
        if (mEleInfoService == null) {
            mEleButton.setEnabled(false);
            return;
        }
        mEleButton.setText(mEleInfoService.getInfo().getName());
    }

    private void loadWanInfo() {
        //当非集成调试阶段, 宿主 App 由于没有依赖其他组件, 所以使用不了对应组件提供的服务
        if (mWanInfoService == null) {
            mWanButton.setEnabled(false);
            return;
        }
        mWanButton.setText(mWanInfoService.getInfo().getName());
    }

    private void loadLunZiInfo() {
        //当非集成调试阶段, 宿主 App 由于没有依赖其他组件, 所以使用不了对应组件提供的服务
        if (mLunZiInfoService == null) {
            mLunZiButton.setEnabled(false);
            return;
        }
        mLunZiButton.setText(mLunZiInfoService.getInfo().getName());
    }

    @Override
    public void onBackPressed() {
        //获取第一次按键时间
        long mNowTime = System.currentTimeMillis();
        //比较两次按键时间差
        if ((mNowTime - mPressedTime) > 2000) {
            ArmsUtils.makeText(getApplicationContext(),
                    "再按一次退出" + ArmsUtils.getString(getApplicationContext(), R.string.public_app_name));
            mPressedTime = mNowTime;
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 这里注意下在组件的页面中(使用了 R2 的页面)使用 {@link butterknife.OnClick} 会有概率出现 id 不正确的问题, 使用以下方式解决
     * <pre>
     * @OnClick({R2.id.button1, R2.id.button2})
     * public void Onclick(View view){
     *      if (view.getId() == R.id.button1){
     *          ...
     *      } else if(view.getId() == R.id.button2){
     *          ...
     *      }
     * }
     * </pre>
     * <p>
     * 在注解上使用 R2, 下面使用 R, 并且使用 {@code if else}, 替代 {@code switch}
     *
     * @param view
     */
    @OnClick({R.id.bt_ele, R.id.bt_wan, R.id.bt_lunzi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ele:
                Utils.navigation(MainActivity.this, RouterHub.ELE_I.ELE_HOME_ACTIVITY);
                break;
            case R.id.bt_wan:
                Utils.navigation(MainActivity.this, RouterHub.WAN_I.WAN_LOGIN_ACTIVITY);
                break;
            case R.id.bt_lunzi:
                Utils.navigation(MainActivity.this, RouterHub.LUNZI_I.LUNZI_HOME_ACTIVITY);
                break;
        }
    }
}
