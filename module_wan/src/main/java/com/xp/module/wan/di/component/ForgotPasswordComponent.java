package com.xp.module.wan.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.xp.module.wan.di.module.ForgotPasswordModule;
import com.xp.module.wan.mvp.contract.ForgotPasswordContract;

import com.jess.arms.di.scope.ActivityScope;
import com.xp.module.wan.mvp.ui.activity.ForgotPasswordActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/27/2020 12:02
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = ForgotPasswordModule.class, dependencies = AppComponent.class)
public interface ForgotPasswordComponent {
    void inject(ForgotPasswordActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ForgotPasswordComponent.Builder view(ForgotPasswordContract.View view);

        ForgotPasswordComponent.Builder appComponent(AppComponent appComponent);

        ForgotPasswordComponent build();
    }
}