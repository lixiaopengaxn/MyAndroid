package com.xp.module.lunzi.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.xp.module.lunzi.di.module.DialogsModule;
import com.xp.module.lunzi.mvp.contract.DialogsContract;

import com.jess.arms.di.scope.ActivityScope;
import com.xp.module.lunzi.mvp.ui.activity.DialogsActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/26/2020 21:59
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = DialogsModule.class, dependencies = AppComponent.class)
public interface DialogsComponent {
    void inject(DialogsActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        DialogsComponent.Builder view(DialogsContract.View view);

        DialogsComponent.Builder appComponent(AppComponent appComponent);

        DialogsComponent build();
    }
}