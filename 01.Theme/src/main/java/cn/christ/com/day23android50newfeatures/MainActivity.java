package cn.christ.com.day23android50newfeatures;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //setTheme(R.style.AppTheme);  //代码设置主题
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
