package com.chen.nongansampling.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;

import com.chen.nongansampling.R;
import com.chen.nongansampling.fragment.ui.sample.SampleFragment;
import com.chen.nongansampling.utils.CommandPhotoUtil;
import com.chen.nongansampling.utils.PhotoSystemOrShoot;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.sample_activity);

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

        if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, SampleFragment.newInstance())
//                .addToBackStack("SampleFragment")
                .commitNow();

    }




}


//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putString("k1", "113");
//        super.onSaveInstanceState(outState);
//        outState.putString("k2", "113-k2");
//    }



    private PhotoSystemOrShoot selectPhoto;
    private CommandPhotoUtil commandPhoto;

//        @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        // 获取照片返回
//        if (selectPhoto != null) {
//            String photoPath = selectPhoto.getPhotoResultPath(requestCode, resultCode, data);
//            if (!TextUtils.isEmpty(photoPath)) {
//                commandPhoto.showGridPhoto(photoPath);
//            }
//        }
//    }



    final String STATE_ = "state_";
    SparseArray<Fragment.SavedState> savedStateSparseArray = new SparseArray<>();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSparseParcelableArray(STATE_, savedStateSparseArray);
    }

    /**
     * 手动存状态
     *
     * @param index
     * @param fragment
     */
    private void saveFragmentState(int index, Fragment fragment) {
        Fragment.SavedState savedState = getSupportFragmentManager().saveFragmentInstanceState(fragment);
        savedStateSparseArray.put(index, savedState);
    }

    /**
     * 手动调用 恢复状态
     *
     * @param index
     * @param fragment
     */
    private void restoreFragmentState(int index, Fragment fragment) {
        Fragment.SavedState savedState = savedStateSparseArray.get(index);
        fragment.setInitialSavedState(savedState);
    }

}
