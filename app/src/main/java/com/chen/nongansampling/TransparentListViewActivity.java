package com.chen.nongansampling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import butterknife.BindView;

public class TransparentListViewActivity extends AppCompatActivity {
    @BindView(R.id.transparent_listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent_list_view);
    //    listView.s
    }
}
