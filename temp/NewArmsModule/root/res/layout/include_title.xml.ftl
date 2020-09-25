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

    <RelativeLayout
        android:id="@+id/toolbar_back"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:gravity="left">

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerVertical="true"
            android:layout_marginLeft="10dp"
            android:layout_marginRight="10dp"
            android:src="@drawable/ic_arrow_back_white_24dp" />
    </RelativeLayout>

    <TextView
        android:id="@+id/toolbar_title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:textColor="@color/public_white"
        android:textSize="18sp"
        tools:text="@string/app_name" />

</androidx.appcompat.widget.Toolbar>