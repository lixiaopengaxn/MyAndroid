package com.xp.module.lunzi.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.xp.module.lunzi.di.module.BrowserModule;
import com.xp.module.lunzi.mvp.contract.BrowserContract;

import com.jess.arms.di.scope.ActivityScope;
import com.xp.module.lunzi.mvp.ui.activity.BrowserActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/26/2020 17:25
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = BrowserModule.class, dependencies = AppComponent.class)
public interface BrowserComponent {
    void inject(BrowserActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        BrowserComponent.Builder view(BrowserContract.View view);

        BrowserComponent.Builder appComponent(AppComponent appComponent);

        BrowserComponent build();
    }
}