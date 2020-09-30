package com.xp.module.lunzi.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.xp.module.lunzi.di.module.TitleBarModule;
import com.xp.module.lunzi.mvp.contract.TitleBarContract;

import com.jess.arms.di.scope.ActivityScope;
import com.xp.module.lunzi.mvp.ui.activity.TitleBarActivity;


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
@ActivityScope
@Component(modules = TitleBarModule.class, dependencies = AppComponent.class)
public interface TitleBarComponent {
    void inject(TitleBarActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        TitleBarComponent.Builder view(TitleBarContract.View view);

        TitleBarComponent.Builder appComponent(AppComponent appComponent);

        TitleBarComponent build();
    }
}