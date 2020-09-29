package com.xp.module.wan.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.integration.AppManager;
import com.jess.arms.utils.ArmsUtils;
import com.xp.coms.view.ClearEditText;
import com.xp.coms.view.PButton;
import com.xp.coms.view.PTextView;
import com.xp.coms.view.PasswordEditText;
import com.xp.coms.view.ScaleImageView;
import com.xp.module.wan.R;
import com.xp.module.wan.R2;
import com.xp.module.wan.di.component.DaggerLoginComponent;
import com.xp.module.wan.mvp.contract.LoginContract;
import com.xp.module.wan.mvp.model.LoginModel;
import com.xp.module.wan.mvp.presenter.LoginPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/27/2020 12:00
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {

    @BindView(R2.id.wan_login_logo)
    ScaleImageView mWanLoginLogo;
    @BindView(R2.id.wan_clear_login_phone)
    ClearEditText mWanClearLoginPhone;
    @BindView(R2.id.wan_ps_login_password)
    PasswordEditText mWanPsLoginPassword;
    @BindView(R2.id.wan_login_forget)
    PTextView mWanLoginForget;
    @BindView(R2.id.wan_login_register)
    PTextView mWanLoginRegister;
    @BindView(R2.id.wan_btn_login_commit)
    PButton mWanBtnLoginCommit;
    @BindView(R2.id.wan_iv_login_qq)
    ScaleImageView mWanIvLoginQq;
    @BindView(R2.id.wan_iv_login_wechat)
    ScaleImageView mWanIvLoginWechat;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.wan_activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ArmsUtils.statuInScreen(this);
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


    @OnClick({R2.id.wan_login_logo, R2.id.wan_clear_login_phone, R2.id.wan_ps_login_password, R2.id.wan_login_forget, R2.id.wan_btn_login_commit, R2.id.wan_iv_login_qq, R2.id.wan_iv_login_wechat,R2.id.wan_login_register})
    public void onClick(View v) {

        if (v.getId() == R.id.wan_btn_login_commit) {
            mPresenter.logIn("bzzguo@qq.com", "lp15034561572..");
        } else if(v.getId() == R.id.wan_login_register){
            ArmsUtils.startActivity(RegisterActivity.class);
        }
/*        switch (v.getId()) {
            default:
                break;
            case R.id.wan_login_logo:

                break;
            case R.id.wan_clear_login_phone:
                break;
            case R.id.wan_ps_login_password:
                break;
            case R.id.wan_login_forget:
                break;
            case R.id.wan_btn_login_commit:
                mPresenter.logIn("bzzguo@qq.com","lp15034561572..");
                break;
            case R.id.wan_iv_login_qq:
                break;
            case R.id.wan_iv_login_wechat:
                break;
        }*/
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
