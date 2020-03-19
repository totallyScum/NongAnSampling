package com.chen.nongansampling.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.chen.nongansampling.R;
import com.chen.nongansampling.adapter.ContactAdapter;
import com.chen.nongansampling.bean.OperatingBean;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.bean.name.Contact;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.presenter.MarketPresenter;
import com.chen.nongansampling.presenterView.MarketView;
import com.chen.nongansampling.utils.HanziToPinyin;
import com.chen.nongansampling.widget.SideBar;

import org.json.JSONObject;
import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.ui.BindView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity implements MarketView, SideBar.OnTouchingLetterChangedListener, TextWatcher {
    private MarketPresenter marketPresenter=new MarketPresenter(this);
    private ArrayList<Contact> datas = new ArrayList<>();
    private ContactAdapter mAdapter;


     ListView mListView;



    private TextView mFooterView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//         mListView=findViewById(R.id.school_friend_member);
////
////        mFooterView = (TextView) View.inflate(this, R.layout.item_list_contact_count, null);
////        mListView.addFooterView(mFooterView);
//
//
//
//
//
//                SideBar mSideBar = (SideBar) findViewById(R.id.school_friend_sidrbar);
//        TextView mDialog = (TextView) findViewById(R.id.school_friend_dialog);
//        EditText mSearchInput = (EditText) findViewById(R.id.school_friend_member_search_input);
//
//        mSideBar.setTextView(mDialog);
//        mSideBar.setOnTouchingLetterChangedListener(this);
//        mSearchInput.addTextChangedListener(this);
//
//
//
//
//
//        marketPresenter.onCreate();
//        marketPresenter.BindPresentView(this);
//
//
//        SimpleRequest simpleRequest=new SimpleRequest();
//        simpleRequest.setAccountPkId("1");
//        marketPresenter.getOperatingResponseInfo(simpleRequest);
 Bitmap b=       base64ToBitmap("/9j/4AAQSkZJRgABAQAAAQABAAD/4gIoSUNDX1BST0ZJTEUAAQEAAAIYAAAAAAIQAABtbnRyUkdC\n" +
         "    IFhZWiAAAAAAAAAAAAAAAABhY3NwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAA9tYAAQAA\n" +
         "    AADTLQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAlk\n" +
         "    ZXNjAAAA8AAAAHRyWFlaAAABZAAAABRnWFlaAAABeAAAABRiWFlaAAABjAAAABRyVFJDAAABoAAA\n" +
         "    AChnVFJDAAABoAAAAChiVFJDAAABoAAAACh3dHB0AAAByAAAABRjcHJ0AAAB3AAAADxtbHVjAAAA\n" +
         "    AAAAAAEAAAAMZW5VUwAAAFgAAAAcAHMAUgBHAEIAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAFhZWiAA\n" +
         "    AAAAAABvogAAOPUAAAOQWFlaIAAAAAAAAGKZAAC3hQAAGNpYWVogAAAAAAAAJKAAAA+EAAC2z3Bh\n" +
         "    cmEAAAAAAAQAAAACZmYAAPKnAAANWQAAE9AAAApbAAAAAAAAAABYWVogAAAAAAAA9tYAAQAAAADT\n" +
         "    LW1sdWMAAAAAAAAAAQAAAAxlblVTAAAAIAAAABwARwBvAG8AZwBsAGUAIABJAG4AYwAuACAAMgAw\n" +
         "    ADEANv/bAEMAAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB\n" +
         "    AQEBAQEBAQEBAQEBAQEBAf/bAEMBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB\n" +
         "    AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAf/AABEIA44EOAMBIgACEQEDEQH/xAAVAAEBAAAA\n" +
         "    AAAAAAAAAAAAAAAAC//EABQQAQAAAAAAAAAAAAAAAAAAAAD/xAAUAQEAAAAAAAAAAAAAAAAAAAAA\n" +
         "    /8QAFBEBAAAAAAAAAAAAAAAAAAAAAP/aAAwDAQACEQMRAD8An/gAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA\n" +
         "    AAAAAAAAAAAAAAAAAAAAAAA");


    }
    public static Bitmap base64ToBitmap(String base64Data) {
        byte[] bytes = Base64.decode(base64Data, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }


//    @Override
//    public void initWidget() {
//        super.initWidget();
//
//
//        SideBar mSideBar = (SideBar) findViewById(R.id.school_friend_sidrbar);
//        TextView mDialog = (TextView) findViewById(R.id.school_friend_dialog);
//        EditText mSearchInput = (EditText) findViewById(R.id.school_friend_member_search_input);
//
//        mSideBar.setTextView(mDialog);
//        mSideBar.setOnTouchingLetterChangedListener(this);
//        mSearchInput.addTextChangedListener(this);
//
//        // 给listView设置adapter
//        mFooterView = (TextView) View.inflate(aty, R.layout.item_list_contact_count, null);
//        mListView.addFooterView(mFooterView);
//
//
//        marketPresenter.onCreate();
//        marketPresenter.BindPresentView(this);
//
//
//        SimpleRequest simpleRequest1=new SimpleRequest();
//        simpleRequest1.setAccountPkId("1");
//        marketPresenter.getOperatingResponseInfo(simpleRequest1);
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        mFooterView = (TextView) View.inflate(aty, R.layout.item_list_contact_count, null);
//        mListView.addFooterView(mFooterView);
//
//
//
//
//
//    }

    @Override
    public void getOperatorList(Object resultData) {

        if (resultData!=null)
        {
            Log.d("qqqqqq","onSuccess");

            CallbackData<List<OperatingBean>> callbackData=(CallbackData<List<OperatingBean>>)resultData;




            for (int i = 0; i < callbackData.getData().size(); i++) {
                Contact data = new Contact();
                data.setName( callbackData.getData().get(i).getOperatingHouseholds());
                Log.d("qqqqqq",data.getName());

                data.setUrl("");
                data.setId(i);
                data.setPinyin(HanziToPinyin.getPinYin(data.getName()));
                datas.add(data);
            }
    //        mFooterView.setText(datas.size() + "位联系人");
            mAdapter = new ContactAdapter(mListView, datas);
            mListView.setAdapter(mAdapter);


//            List<OperatingBean>list=callbackData.getData();
//            for (OperatingBean operatingBean:list)
//            {
////                Fragment  fragment = new ArchivesListFragment();
////                fragment_list.add(fragment);
////                tab_title_list.add(market.getName());
////                tabLayout.addTab(tabLayout.newTab().setText(market.getName()));
////                adapter = new BusinessArchivesFragmentAdapter(getChildFragmentManager(), tab_title_list, fragment_list);
////                viewPager.setOffscreenPageLimit(2);
////                viewPager.setAdapter(adapter);//给ViewPager设置适配器
//            }
        }



    }

    @Override
    public void onError(String result) {
        Log.d("qqqqqq",result);
    }

    @Override
    public void onSuccess(Object resultData) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    @Override
    public void onTouchingLetterChanged(String s) {

    }


}
