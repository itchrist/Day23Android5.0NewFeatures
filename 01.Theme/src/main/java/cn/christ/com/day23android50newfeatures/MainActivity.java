package cn.christ.com.day23android50newfeatures;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends /*AppCompat*/Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme);  //代码设置主题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
