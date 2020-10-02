package com.xp.module.lunzi.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.xp.coms.dialog.BaseDialog;
import com.xp.coms.dialog.dialogSig.InputDialog;
import com.xp.coms.dialog.dialogSig.MessageDialog;
import com.xp.coms.layout.titlebar.TitleBar;
import com.xp.coms.view.PButton;
import com.xp.module.lunzi.R;
import com.xp.module.lunzi.R2;
import com.xp.module.lunzi.di.component.DaggerDialogsComponent;
import com.xp.module.lunzi.mvp.contract.DialogsContract;
import com.xp.module.lunzi.mvp.presenter.DialogsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
public class DialogsActivity extends BaseActivity<DialogsPresenter> implements DialogsContract.View {

    @BindView(R2.id.btn_dialog_message)
    PButton mBtnDialogMessage;
    @BindView(R2.id.btn_dialog_input)
    PButton mBtnDialogInput;
    @BindView(R2.id.btn_dialog_bottom_menu)
    PButton mBtnDialogBottomMenu;

    @BindView(R2.id.base_title_bar)
    TitleBar mTitleBar;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerDialogsComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.lun_activity_dialog; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

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


    @OnClick({R2.id.btn_dialog_message, R2.id.btn_dialog_input, R2.id.btn_dialog_bottom_menu})
    public void onClick(View v) {
        if(v.getId() == R.id.btn_dialog_message){
            // 消息对话框
            new MessageDialog.Builder(this)
                    // 标题可以不用填写
                    .setTitle("我是标题")
                    // 内容必须要填写
                    .setMessage("我是内容")
                    // 确定按钮文本
                    .setConfirm(getString(R.string.public_comRes_confirm))
                    // 设置 null 表示不显示取消按钮
                    .setCancel(getString(R.string.public_comRes_cancel))
                    // 设置点击按钮后不关闭对话框
                    //.setAutoDismiss(false)
                    .setListener(new MessageDialog.OnListener() {

                        @Override
                        public void onConfirm(BaseDialog dialog) {
                            ArmsUtils.snackbarText("确定了");
                        }

                        @Override
                        public void onCancel(BaseDialog dialog) {
                            ArmsUtils.snackbarText("取消了");
                        }
                    })
                    .show();
        } else if(v.getId() == R.id.btn_dialog_input){
            // 输入对话框
            new InputDialog.Builder(this)
                    // 标题可以不用填写
                    .setTitle("我是标题")
                    // 内容可以不用填写
                    .setContent("我是内容")
                    // 提示可以不用填写
                    .setHint("我是提示")
                    // 确定按钮文本
                    .setConfirm(getString(R.string.public_comRes_confirm))
                    // 设置 null 表示不显示取消按钮
                    .setCancel(getString(R.string.public_comRes_cancel))
                    // 设置点击按钮后不关闭对话框
                    //.setAutoDismiss(false)
                    .setListener(new InputDialog.OnListener() {

                        @Override
                        public void onConfirm(BaseDialog dialog, String content) {
                            ArmsUtils.snackbarText("确定了：" + content);
                        }

                        @Override
                        public void onCancel(BaseDialog dialog) {
                            ArmsUtils.snackbarText("取消了");
                        }
                    })
                    .show();
        } else if(v.getId() == R.id.btn_dialog_bottom_menu){

        }
/*        else if(v.getId() == R.id.btn_dialog_bottom_menu){

        } else if(v.getId() == R.id.btn_dialog_message){

        } else if(v.getId() == R.id.btn_dialog_message){

        } else if(v.getId() == R.id.btn_dialog_message){

        } else if(v.getId() == R.id.btn_dialog_message){

        }*/
    }
}
