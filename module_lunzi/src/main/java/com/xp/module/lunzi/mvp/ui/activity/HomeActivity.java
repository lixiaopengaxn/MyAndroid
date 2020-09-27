package com.xp.module.lunzi.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.xp.coms.view.PButton;
import com.xp.comsdk.core.RouterHub;
import com.xp.module.lunzi.R;
import com.xp.module.lunzi.R;
import com.xp.module.lunzi.R2;
import com.xp.module.lunzi.di.component.DaggerHomeComponent;
import com.xp.module.lunzi.mvp.contract.HomeContract;
import com.xp.module.lunzi.mvp.presenter.HomePresenter;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnItemClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/25/2020 19:23
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Route(path = RouterHub.LUNZI_I.LUNZI_HOME_ACTIVITY, name = "轮子哥的项目")
public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    @BindView(R2.id.lun_button_1)
    PButton mLunButton1;
    @BindView(R2.id.lun_button_2)
    PButton mLunButton2;
    @BindView(R2.id.lun_button_3)
    PButton mLunButton3;
    @BindView(R2.id.lun_button_4)
    PButton mLunButton4;
    @BindView(R2.id.lun_button_5)
    PButton mLunButton5;
    @BindView(R2.id.lun_button_6)
    PButton mLunButton6;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHomeComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_home; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ArmsUtils.snackbarText("??????");
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

    @OnClick({R2.id.lun_button_1, R2.id.lun_button_2, R2.id.lun_button_3, R2.id.lun_button_4, R2.id.lun_button_5, R2.id.lun_button_6})
    public void onClick(View v) {
        if(v.getId() == R.id.lun_button_1){
            ArmsUtils.startActivity(EditActivity.class);
        } else if(v.getId() == R.id.lun_button_2){
            ArmsUtils.startActivity(DialogsActivity.class);
        } else if(v.getId() == R.id.lun_button_3){
            ArmsUtils.startActivity(BrowserActivity.class);
        } else if(v.getId() == R.id.lun_button_4){

        } else if(v.getId() == R.id.lun_button_5){

        } else if(v.getId() == R.id.lun_button_6){

        }
    }
}
