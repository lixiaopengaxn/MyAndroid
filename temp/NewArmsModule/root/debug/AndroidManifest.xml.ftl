<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="${packageName}">

    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE"/>
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    
    <application
    	android:name="com.jess.arms.base.BaseApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:networkSecurityConfig="@xml/public_network_security_config"
        android:supportsRtl="true"
        android:theme="@style/public_AppTheme">

        <activity
            android:name=".mvp.ui.activity.HomeActivity"
            android:configChanges="orientation|screenSize"
            android:screenOrientation="portrait">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>

                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>

        <!-- 只要依赖 AutoSize 就必须填写设计图尺寸, 否则报错, 不想使用 AutoSize 就不要依赖 AutoSize
        只要填写完设计图的尺寸, AutoSize 就会自动启动, 以下 dp 尺寸是根据公式 px / (dpi / 160) 求出, 运算时使用测试机的 dpi 即可
        AutoSize 的详细介绍请看这里 https://juejin.im/post/5bce688e6fb9a05cf715d1c2
        -->
        <meta-data
            android:name="design_width_in_dp"
            android:value="360"/>
        <meta-data
            android:name="design_height_in_dp"
            android:value="640"/>

        <!-- arms配置 -->
        <meta-data
            android:name="com.xp.comsdk.core.GlobalConfiguration"
            android:value="ConfigModule" />
        
        <meta-data
            android:name="${packageName}.app.GlobalConfiguration"
            android:value="ConfigModule"/>
    </application>
</manifest>