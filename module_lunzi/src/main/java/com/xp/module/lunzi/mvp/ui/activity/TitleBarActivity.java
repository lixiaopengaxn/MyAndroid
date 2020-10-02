package com.xp.module.lunzi.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.xp.coms.layout.titlebar.OnTitleBarListener;
import com.xp.coms.layout.titlebar.TitleBar;
import com.xp.module.lunzi.R2;
import com.xp.module.lunzi.di.component.DaggerTitleBarComponent;
import com.xp.module.lunzi.mvp.contract.TitleBarContract;
import com.xp.module.lunzi.mvp.presenter.TitleBarPresenter;

import com.xp.module.lunzi.R;


import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/30/2020 19:01
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class TitleBarActivity extends BaseActivity<TitleBarPresenter> implements TitleBarContract.View {

    @BindView(R2.id.base_title_bar)
    TitleBar mTitleBar;
    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerTitleBarComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.lun_activity_title_bar; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        mTitleBar.setOnTitleBarListener(new OnTitleBarListener() {

            @Override
            public void onLeftClick(View v) {
                ArmsUtils.snackbarText("左项 View 被点击");
            }

            @Override
            public void onTitleClick(View v) {
                ArmsUtils.snackbarText("中间 View 被点击");
            }

            @Override
            public void onRightClick(View v) {
                ArmsUtils.snackbarText("右项 View 被点击");
            }
        });
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
