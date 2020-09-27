package com.xp.module.lunzi.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.xp.module.lunzi.di.module.EditModule;
import com.xp.module.lunzi.mvp.contract.EditContract;

import com.jess.arms.di.scope.ActivityScope;
import com.xp.module.lunzi.mvp.ui.activity.EditActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/25/2020 23:59
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = EditModule.class, dependencies = AppComponent.class)
public interface EditComponent {
    void inject(EditActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        EditComponent.Builder view(EditContract.View view);

        EditComponent.Builder appComponent(AppComponent appComponent);

        EditComponent build();
    }
}