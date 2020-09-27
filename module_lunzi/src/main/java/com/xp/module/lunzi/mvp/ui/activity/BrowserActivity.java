package com.xp.module.lunzi.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.xp.coms.view.BrowserView;
import com.xp.module.lunzi.R;
import com.xp.module.lunzi.R2;
import com.xp.module.lunzi.di.component.DaggerBrowserComponent;
import com.xp.module.lunzi.mvp.contract.BrowserContract;
import com.xp.module.lunzi.mvp.presenter.BrowserPresenter;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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

public class BrowserActivity extends BaseActivity<BrowserPresenter> implements BrowserContract.View {

    @BindView(R2.id.pb_browser_progress)
    ProgressBar mPbBrowserProgress;
    @BindView(R2.id.wv_browser_view)
    BrowserView mWvBrowserView;
    @BindView(R2.id.toolbar_title)
    TextView mTitle;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerBrowserComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.lun_activity_browser; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        mTitle.setText(R.string.public_comRes_loading);

        mWvBrowserView.setBrowserViewClient(new MyBrowserViewClient());
        mWvBrowserView.setBrowserChromeClient(new MyBrowserChromeClient(mWvBrowserView));

        String url = "https://github.com/JessYanCoding";
        mWvBrowserView.loadUrl(url);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWvBrowserView.canGoBack()) {
            // 后退网页并且拦截该事件
            mWvBrowserView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
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


    private class MyBrowserViewClient extends BrowserView.BrowserViewClient {

        /**
         * 网页加载错误时回调，这个方法会在 onPageFinished 之前调用
         */
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            // 这里为什么要用延迟呢？因为加载出错之后会先调用 onReceivedError 再调用 onPageFinished
            //加载失败重新加载页面
            mWvBrowserView.reload();
        }

        /**
         * 开始加载网页
         */
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            mPbBrowserProgress.setVisibility(View.VISIBLE);
        }

        /**
         * 完成加载网页
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            mPbBrowserProgress.setVisibility(View.GONE);
        }
    }

    private class MyBrowserChromeClient extends BrowserView.BrowserChromeClient {

        private MyBrowserChromeClient(BrowserView view) {
            super(view);
        }

        /**
         * 收到网页标题
         */
        @Override
        public void onReceivedTitle(WebView view, String title) {
            if (title != null) {
                mTitle.setText(title);
            }
        }

        /**
         * 收到加载进度变化
         */
        @SuppressLint("NewApi")
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            mPbBrowserProgress.setProgress(newProgress);
        }
    }


    @Override
    protected void onResume() {
        mWvBrowserView.onResume();
        super.onResume();
    }

    @Override
    protected void onPause() {
        mWvBrowserView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWvBrowserView.onDestroy();
        super.onDestroy();
    }
}
