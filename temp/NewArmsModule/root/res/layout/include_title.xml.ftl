<?xml version="1.0" encoding="utf-8"?>

<androidx.appcompat.widget.Toolbar xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/toolbar"
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:background="?attr/colorPrimary"
    app:contentInsetStart="0dp"
    tools:ignore="ResourceName">

            <com.xp.coms.layout.titlebar.TitleBar
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginTop="20dp"
                android:layout_marginBottom="20dp"
                android:background="@drawable/public_shape_gradient"
                app:public_barStyle="transparent"
                app:public_leftBackground="@null"
                app:public_leftTitle="@string/public_res_back"
                app:public_rightBackground="@null"
                app:public_rightTitle="@string/public_res_setting"
                app:public_title="@string/public_app_name"
                app:public_titleColor="@null" />

</androidx.appcompat.widget.Toolbar>