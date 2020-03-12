package com.chen.nongansampling.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import com.chen.nongansampling.R;
import com.chen.nongansampling.fragment.ui.businessarchives.BusinessArchivesFragment;

public class BusinessArchivesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.business_archives_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, BusinessArchivesFragment.newInstance())
                    .commitNow();
        }


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);//隐藏标题
        toolbar.setNavigationIcon(R.mipmap.back_white);       //加载图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {   //为图标设置监听器
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
