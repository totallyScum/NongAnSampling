package com.chen.nongansampling.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ArchivesListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ArchivesListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ArchivesListFragment extends Fragment  implements MarketView, SideBar.OnTouchingLetterChangedListener, TextWatcher {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;


    private MarketPresenter marketPresenter=new MarketPresenter(getContext());
    private ArrayList<Contact> datas = new ArrayList<>();
    private ContactAdapter mAdapter;
    ListView mListView;



    public ArchivesListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ArchivesListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ArchivesListFragment newInstance(String param1, String param2) {
        ArchivesListFragment fragment = new ArchivesListFragment();
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
        return inflater.inflate(R.layout.fragment_archives_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mListView=getActivity().findViewById(R.id.school_friend_member);





        SideBar mSideBar = (SideBar) getActivity().findViewById(R.id.school_friend_sidrbar);
        TextView mDialog = (TextView) getActivity().findViewById(R.id.school_friend_dialog);
        EditText mSearchInput = (EditText) getActivity().findViewById(R.id.school_friend_member_search_input);

        mSideBar.setTextView(mDialog);
        mSideBar.setOnTouchingLetterChangedListener(this);
        mSearchInput.addTextChangedListener(this);





        marketPresenter.onCreate();
        marketPresenter.BindPresentView(this);


        SimpleRequest simpleRequest=new SimpleRequest();
        simpleRequest.setAccountPkId("1");
        marketPresenter.getOperatingResponseInfo(simpleRequest);





    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void getOperatorList(Object resultData) {

        if (resultData != null) {
            Log.d("qqqqqq", "onSuccess");

            CallbackData<List<OperatingBean>> callbackData = (CallbackData<List<OperatingBean>>) resultData;


            for (int i = 0; i < callbackData.getData().size(); i++) {
                Contact data = new Contact();
                data.setName(callbackData.getData().get(i).getOperatingHouseholds());
                Log.d("qqqqqq", data.getName());

                data.setUrl("");
                data.setId(i);
                data.setPinyin(HanziToPinyin.getPinYin(data.getName()));
                datas.add(data);
            }
            //        mFooterView.setText(datas.size() + "位联系人");
            mAdapter = new ContactAdapter(mListView, datas);
            mListView.setAdapter(mAdapter);

        }
    }

    @Override
    public void onError(String result) {

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
