package com.chen.nongansampling.fragment.ui.sample;

import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chen.nongansampling.R;

import com.chen.nongansampling.adapter.ListviewRichTextAdapter;
import com.chen.nongansampling.adapter.ListviewTextAdapter;
import com.chen.nongansampling.adapter.PictureAddGridAdapter;
import com.chen.nongansampling.bean.Callback;
import com.chen.nongansampling.bean.OperatingBean;
import com.chen.nongansampling.bean.SimpleRequest;
import com.chen.nongansampling.bean.sample.TypeList;
import com.chen.nongansampling.bean.sample.TypeListItem;
import com.chen.nongansampling.bean.sample.insert.SamplingInformation;
import com.chen.nongansampling.bean.sample.insert.SamplingRequset;
import com.chen.nongansampling.bean.ui.ListviewBean;
import com.chen.nongansampling.custom.CustomScrollGridView;
import com.chen.nongansampling.fragment.LabelPrintedFragment;
import com.chen.nongansampling.fragment.SampleActivity;
import com.chen.nongansampling.model.CallbackData;
import com.chen.nongansampling.model.Market;
import com.chen.nongansampling.presenter.MarketPresenter;
import com.chen.nongansampling.presenter.SamplePresenter;
import com.chen.nongansampling.presenterView.SampleView;
import com.chen.nongansampling.utils.CommandPhotoUtil;
import com.chen.nongansampling.utils.ImageUtil;
import com.chen.nongansampling.utils.PhotoBitmapUtil;
import com.chen.nongansampling.utils.PhotoSystemOrShoot;
import com.chen.nongansampling.view.LinePathView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SampleFragment extends Fragment implements SampleView {




    /**
     * 存放图片的容器
     */
    private CustomScrollGridView mGridView;

    /**
     * GridView适配器
     */
    private PictureAddGridAdapter gridAdapter;

    /**
     * 管理图片操作
     */
    private CommandPhotoUtil commandPhoto;

    /**
     * 选择图片来源
     */
    private PhotoSystemOrShoot selectPhoto;


    private SamplePresenter samplePresenter=new SamplePresenter(getContext());


    static List<Market> marketList=new ArrayList<>();  //市场列表
    static List<OperatingBean> operatorList=new ArrayList<>();
    private CallbackData<List<TypeList>> typelist;
    private CallbackData<List<TypeList>> typelistDeTypeAndName;


    private List<TypeListItem> typelistname=new ArrayList<>();

    private List<TypeListItem> typelistnametDeTypeAndName=new ArrayList<>();


    private SamplingInformation samplingInformation=new SamplingInformation();      //采样信息
    private SamplingRequset samplingRequset=new SamplingRequset();        //采样请求

    private PopupWindow popupSignWindow;      //签名弹窗

    private  View  view;
    private View mSignView;
private Bitmap signBitmap;


@BindView(R.id.sample)
    LinearLayout linearLayout;


    private SampleViewModel mViewModel;
    public static SampleFragment newInstance() {
        return new SampleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.sample_fragment, container, false);
        mSignView= inflater.inflate(R.layout.popup_sign_window, null);

        ButterKnife.bind(this, view);
  //      return inflater.inflate(R.layout.sample_fragment, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @BindView(R.id.sample_text_listview) ListView textlistView;
 //   @BindView(R.id.add_picture) ImageView addPicture;

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("onDetach","onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("onDetach","onDestroyView");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("onDetach","onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("onDetach","onStop");

    }

    @OnClick(R.id.submit)
public void onClick(){



    samplingRequset.setAccountPkId("1");
//    samplingRequset.setDeTypeId("1");
//    samplingRequset.setDeMethoodPkID("1");

    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式

//   samplingInformation.setSampleNumber(TimeFonew Date().getTime()parse().ToString("yyyyMMdd") + getTreeNumRandom(););
    samplingInformation.setSampleNumber(df.format(new Date())+getTreeNumRandom());
    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    samplingInformation.setSamplingTime(df2.format(new Date()));
    samplingInformation.setSampleAccountId("1");
//    samplingInformation.setSampleType("1");
//    samplingInformation.setOperatingHouseholdId("1");
//    samplingInformation.setSampleAccountId("1");
 //   samplingInformation.setAutograph(ImageUtil.bitmapToBase64(signBitmap));






    signImageView.setDrawingCacheEnabled(true);
    Bitmap bitmap = Bitmap.createBitmap(signImageView.getDrawingCache());
    signImageView.setDrawingCacheEnabled(false);

    //samplingInformation.setAutograph(ImageUtil.toBase64String(signBitmap));
    samplingInformation.setAutograph(ImageUtil.toBase64String(bitmap));




    signImageView.setImageBitmap(bitmap);




    Log.d("base64",ImageUtil.toBase64String(signBitmap));

  //  samplingInformation.setAutograph("");
 //  ViewH =gridAdapter.getItem(0);
Bitmap b=PhotoBitmapUtil.getCompressPhoto((String) gridAdapter.getItem(0));

   // samplingInformation.setSamplePhoto(ImageUtil.bitmapToBase64(b));

    samplingInformation.setSamplePhoto(ImageUtil.toBase64String(b));


 //   img.setImageBitmap(PhotoBitmapUtil.getCompressPhoto(imageItemData.get(position)));

    samplingRequset.setSamplingInformation(samplingInformation);
    samplePresenter.getInsertSamplingResponseInfo(samplingRequset);

}

    public String getTreeNumRandom()
    { int iResult;
        iResult = (int)(Math.random()*900)+100;        //Response.Write(iResult.ToString());
        return iResult+"";
    }


    @BindView(R.id.add_sign)
    ImageView signImageView;


@OnClick(R.id.add_sign)
public void onSign(){
    popupSignWindow= new PopupWindow(getContext());
  //  mSignView= Inflater.inflate(R.layout.popup_select_way_photo, null);

    ColorDrawable dw = new ColorDrawable(0x00000000);
    popupSignWindow.setBackgroundDrawable(dw);
    popupSignWindow.setContentView(mSignView);
    popupSignWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
    popupSignWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
    popupSignWindow.setAnimationStyle(R.style.popup_select_way);
    popupSignWindow.setFocusable(true);


    popupSignWindow.showAtLocation(getView(), Gravity.CENTER, 0, 0);

    View view=popupSignWindow.getContentView();

Button signSave=view.findViewById(R.id.sign_save);
    Button signDel=view.findViewById(R.id.sign_clear);
   final LinePathView linePathView=view.findViewById(R.id.sign_view);

    signDel.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        linePathView.clear();
        }
    });

    signSave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signBitmap=  linePathView.saveToBitmap(true,1);

//            signBitmap=  linePathView.getBitMap();

            signImageView.setImageBitmap(signBitmap);
            popupSignWindow.dismiss();


        }
    });
}
//    @OnClick(R.id.sign_save)
//    public void onSignSave() {
//    }
//    LinePathView linePathView;
//
//    @OnClick(R.id.sign_clear)
//    public void onSignClear() {
//   //     @BindView(R.id.sign_view)
//         linePathView=getActivity().findViewById(R.id.sign_view);
//        linePathView.clear();
//    }



//    @BindView(R.id.sample_iamge_listview) ListView imagelistView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SampleViewModel.class);




        initUI();
        addPlus();
        // TODO: Use the ViewModel

    }


    @Override
    public void onResume() {
        super.onResume();
        samplePresenter.BindPresentView(this);
        samplePresenter.onCreate();
        initRequest();


        initListView();
    }

    private void initUI() {
        mGridView = (CustomScrollGridView) getActivity().findViewById(R.id.gv_all_photo);




    }

    /**
     * 实例化组件
     */
    private void addPlus() {
        gridAdapter = new PictureAddGridAdapter(view.getContext(), 12);
        mGridView.setAdapter(gridAdapter);

    //   getActivity().getSupportFragmentManager().saveFragmentInstanceState(SampleFragment.newInstance());
        // 选择图片获取途径
        selectPhoto = new PhotoSystemOrShoot(view.getContext()) {
            @Override
            public void onStartActivityForResult(Intent intent, int requestCode) {

                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                    intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                    Uri contentUri = FileProvider.getUriForFile(context,"com.skyrin.bingo.fileprovider",apkFile);
//                    intent.setDataAndType(contentUri,"application/vnd.android.package-archive");
                startActivityForResult(intent, requestCode);

                }else {
            //        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    intent.setDataAndType(
//                            Uri.fromFile(apkFile),
//                            "application/vnd.android.package-archive");
                startActivityForResult(intent, requestCode);

                }

            }
        };
        commandPhoto = new CommandPhotoUtil(getContext(), mGridView, gridAdapter, selectPhoto);
    }

    public void initListView(){
    //    listView=getView().findViewById(R.id.sample_text_listview);
        ListviewBean<String> list1=new ListviewBean();
        list1.setData("请选择");
        list1.setImageSrc(R.mipmap.market_name);
        list1.setName("市场名称");






        ListviewBean<String> list2=new ListviewBean();
        list2.setData("请选择");
        list2.setImageSrc(R.mipmap.listview_text_operator);
        list2.setName("经营户");



        ListviewBean<String> list3=new ListviewBean();
        list3.setData("请选择");
        list3.setImageSrc(R.mipmap.sample_category);
        list3.setName("样品类别");



        ListviewBean<String> list4=new ListviewBean();
        list4.setData("请选择");
        list4.setImageSrc(R.mipmap.listview_sample_name);
        list4.setName("样品名称");


        ListviewBean<String> list5=new ListviewBean();
        list5.setData("请选择");
        list5.setImageSrc(R.mipmap.listview_text_test_type);
        list5.setName("检测类型");




        ListviewBean<String> list6=new ListviewBean();
        list6.setData("请选择");
        list6.setImageSrc(R.mipmap.listview_text_test_method);
        list6.setName("检测方法");




//        ListviewBean<Bitmap> list6=new ListviewBean();
//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher, null);
//        list6.setData(bitmap);
//        list6.setImageSrc(R.mipmap.listview_text_test_method);
//        list6.setName("采样照片");
//        list6.setComplicated(true);



        List<ListviewBean> list=new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
       list.add(list6);


        textlistView.setAdapter(new ListviewTextAdapter(list,getContext()));


textlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position)
        {
            case 0:{


                if (marketList.size()!=0) {

                    String s[]=new String[marketList.size()];
                    for (int i=0;i<marketList.size();i++)
                    {
                        s[i]=marketList.get(i).getName();
                    }


                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("请选择市场");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setItems(s, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            TextView t = view.findViewById(R.id.listview_text_data);
                            t.setText(marketList.get(which).getName());
                        }
                    });
                    builder.create().show();

                }

            }break;
            case 1:{
                if (operatorList!=null&&operatorList.size()!=0) {

                    String s[]=new String[operatorList.size()];
                    for (int i=0;i<operatorList.size();i++)
                    {
                        s[i]=operatorList.get(i).getOperatingHouseholds();
                    }


                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("请选择经营户");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setItems(s, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            TextView t = view.findViewById(R.id.listview_text_data);
                            t.setText(operatorList.get(which).getOperatingHouseholds());
                            samplingInformation.setOperatingHouseholdId(operatorList.get(which).getPkId());


                        }
                    });
                    builder.create().show();

                }

            }break;
            case 2:{

                if (typelist.getData()!=null) {

                    String s[]=new String[typelist.getData().size()];
                    for (int i=0;i<typelist.getData().size();i++)
                    {
                        s[i]=typelist.getData().get(i).getTypeName();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("请选择样品类别");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setItems(s, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            TextView t = view.findViewById(R.id.listview_text_data);
                            t.setText(typelist.getData().get(which).getTypeName());
                            samplingInformation.setSampleType(typelist.getData().get(which).getTypeId());

                            typelistname=typelist.getData().get(which).getList();
                        }
                    });
                    builder.create().show();

                }

            }break;
            case 3:{
                if (typelistname.size()!=0) {

                    String s[]=new String[typelistname.size()];
                    for (int i=0;i<typelistname.size();i++)
                    {
                        s[i]=typelistname.get(i).getName();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("请选择样品名称");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setItems(s, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            TextView t = view.findViewById(R.id.listview_text_data);
                            t.setText(typelistname.get(which).getName());
                            samplingInformation.setSampleName(typelistname.get(which).getNameId());

                        }
                    });
                    builder.create().show();

                }else {
                    Toast.makeText(getContext(),"请先选择样品类别",Toast.LENGTH_LONG).show();
                }





            }break;

            case 4:{
//                final String items[] = {"A", "B", "C"};
//                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
//                builder.setTitle("请选择市场");
//                builder.setIcon(R.mipmap.ic_launcher);
//                builder.setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                        TextView t=view.findViewById(R.id.listview_text_data);
//                        t.setText(items[which]);
//                    }
//                });
//                builder.create().show();
                if (typelistDeTypeAndName!=null) {
                    Log.d("请选择检测类型",typelistDeTypeAndName.getData().size()+"");
                    String s[]=new String[typelistDeTypeAndName.getData().size()];
                    for (int i=0;i<typelistDeTypeAndName.getData().size();i++)
                    {
                        s[i]=typelistDeTypeAndName.getData().get(i).getTypeName();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("请选择检测类型");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setItems(s, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            TextView t = view.findViewById(R.id.listview_text_data);
                            t.setText(typelistDeTypeAndName.getData().get(which).getTypeName());
                            typelistnametDeTypeAndName=typelistDeTypeAndName.getData().get(which).getList();
                            samplingRequset.setDeTypeId(typelistDeTypeAndName.getData().get(which).getTypeId());
                        }
                    });
                    builder.create().show();

                }
            }break;

            case 5:{
                if (typelistnametDeTypeAndName.size()!=0) {

                    String s[]=new String[typelistnametDeTypeAndName.size()];
                    for (int i=0;i<typelistnametDeTypeAndName.size();i++)
                    {
                        s[i]=typelistnametDeTypeAndName.get(i).getName();
                    }

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("请选择检测方法");
                    builder.setIcon(R.mipmap.ic_launcher);
                    builder.setItems(s, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            TextView t = view.findViewById(R.id.listview_text_data);
                            t.setText(typelistnametDeTypeAndName.get(which).getName());
                            samplingRequset.setDeMethoodPkID(typelistnametDeTypeAndName.get(which).getNameId());



                        }
                    });
                    builder.create().show();

                }else {
                    Toast.makeText(getContext(),"请先选择检测类型",Toast.LENGTH_LONG).show();
                }

            }break;

        }
    }
});

//        imagelistView.setAdapter(new ListviewRichTextAdapter(list,getContext()));







    }

    public  void initRequest(){
        SimpleRequest s=new SimpleRequest();
        s.setAccountPkId("1");
        samplePresenter.getMarketResponseInfo(s);

        samplePresenter.getOperatingResponseInfo(s);
        samplePresenter.getSamplingNameResponseInfo(s);
        samplePresenter.getDeTypeAndNameResponseInfo(s);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (selectPhoto != null) {
            String photoPath = selectPhoto.getPhotoResultPath(requestCode, resultCode, data);
            if (!TextUtils.isEmpty(photoPath)) {
                commandPhoto.showGridPhoto(photoPath);
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);



        //        getActivity().getSupportFragmentManager().    (SampleFragment.newInstance());

    }

    @Override
    public void getMarketList(Object resultData) {


        CallbackData callbackData=(CallbackData<List<Market>>)resultData;
        marketList=(List<Market>)callbackData.getData();
//      final    String items[] =
//         (String[]) list.toArray();

//            List list= list.toArray();
//            items= (String[]) list.toArray();
    }

    @Override
    public void getOperatorList(Object resultData) {
        CallbackData callbackData=(CallbackData<List<OperatingBean>>)resultData;
        operatorList=(List<OperatingBean>)callbackData.getData();


    }

    @Override
    public void getSamplingName(Object resultData) {

        typelist=(CallbackData<List<TypeList>> )resultData;


   //     Log.d("typelist",typelistDeTypeAndName.getData().get(0).getList().get(0).getName()+"");





    }

    @Override
    public void getDeTypeAndName(Object resultData) {
        typelistDeTypeAndName=(CallbackData<List<TypeList>> )resultData;

    }

    @Override
    public void getInsertSamplingResponseInfo(Object resultData) {
        Callback callbackData=(Callback)resultData;

        Log.d("getAlertMessage", callbackData.getAlertMessage()+callbackData.getState());


        if (callbackData.getState()==1)
        {
//            if (savedInstanceState == null) {
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container, LabelPrintedFragment.newInstance())
//                        .commit();
//            }

            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LabelPrintedFragment.newInstance())
                    .commitNow();


        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d("onDetach","onDestroy");

    }

    @Override
    public void onError(String result) {
        Log.d("getAlertMessage",        result);

    }


//    @Override
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

}
