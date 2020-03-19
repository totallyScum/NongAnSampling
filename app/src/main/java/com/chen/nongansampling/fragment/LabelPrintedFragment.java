package com.chen.nongansampling.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.chen.nongansampling.R;
import com.chen.nongansampling.adapter.LabelPrintAdapter;
import com.chen.nongansampling.fragment.ui.sample.SampleFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LabelPrintedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LabelPrintedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LabelPrintedFragment extends Fragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<String> list=new ArrayList<>();
    private String left[] = {"样品名称","采样时间","经营户","摊位号","市场名称","检测项目","检测方法","检测结果","检测时间"};//假数据
    private String right[] = {"蒜苗","2020-3-17","陈飞旭","1D13","越秀菜市场","氨基甲酸酯类","酶抑制法","阴性","2020-02-18"};//假数据



    @OnClick(R.id.back_to_sample)
    public void onClick(){
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, SampleFragment.newInstance())
                .commitNow();
    }
    public LabelPrintedFragment() {
        // Required empty public constructor
    }

    public static LabelPrintedFragment newInstance() {
        return new LabelPrintedFragment();
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LabelPrintedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LabelPrintedFragment newInstance(String param1, String param2) {
        LabelPrintedFragment fragment = new LabelPrintedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_label_printed, container, false);



        TextView textView = (TextView) getActivity().findViewById(R.id.sample_tool_bar_name);
        textView.setText("标签打印");

        ButterKnife.bind(this, view);

        return view;
    }

    @BindView(R.id.label_printed_listview)
    ListView ls;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LabelPrintAdapter labelPrintAdapter=new LabelPrintAdapter(Arrays.asList(left),Arrays.asList(right),getContext());
        ls.setAdapter(labelPrintAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
