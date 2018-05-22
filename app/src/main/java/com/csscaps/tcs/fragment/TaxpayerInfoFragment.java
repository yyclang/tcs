package com.csscaps.tcs.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.csscaps.common.base.BaseFragment;
import com.csscaps.common.utils.AppSP;
import com.csscaps.tcs.R;
import com.csscaps.tcs.model.MyTaxpayer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by tl on 2018/5/21.
 */

public class TaxpayerInfoFragment extends BaseFragment {
    @BindView(R.id.tin)
    TextView mTin;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.local_name)
    TextView mLocalName;
    @BindView(R.id.tel)
    TextView mTel;
    @BindView(R.id.preferred_language)
    TextView mPreferredLanguage;
    @BindView(R.id.physical_address)
    TextView mPhysicalAddress;
    @BindView(R.id.state)
    TextView mState;
    @BindView(R.id.business_activities)
    TextView mBusinessActivities;
    @BindView(R.id.main_taxable_activity)
    TextView mMainTaxableActivity;
    @BindView(R.id.remarks)
    TextView mRemarks;
    @BindView(R.id.id_type)
    TextView mIdType;
    @BindView(R.id.id_no)
    TextView mIdNo;
    @BindView(R.id.hit)
    TextView mHit;
    @BindView(R.id.scrollView)
    ScrollView mScrollView;

    @Override
    protected int getLayoutResId() {
        return R.layout.taxpayer_info_fragment;
    }

    @Override
    protected void onInitPresenters() {

    }

    @Override
    public void initView(Bundle savedInstanceState) {
        String myTaxpayerString = AppSP.getString("MyTaxpayer");
        if (!TextUtils.isEmpty(myTaxpayerString)) {
            MyTaxpayer myTaxpayer = JSON.parseObject(myTaxpayerString, MyTaxpayer.class);
            mTin.setText(myTaxpayer.getTin());
            mName.setText(myTaxpayer.getName_in_english());
            mLocalName.setText(myTaxpayer.getName_in_second_lang());
            mIdNo.setText(myTaxpayer.getId_number());
            mIdType.setText(myTaxpayer.getId_type());
            mPreferredLanguage.setText(myTaxpayer.getPreferred_language());
            mPhysicalAddress.setText(myTaxpayer.getPhysical_address());
            mTel.setText(myTaxpayer.getTelphone());
            mState.setText(myTaxpayer.getState());
            mMainTaxableActivity.setText(myTaxpayer.getMain_taxpable_activity());
            mRemarks.setText(myTaxpayer.getRemark());
            mBusinessActivities.setText(myTaxpayer.getTaxpayer_category());
        } else {
            mScrollView.setVisibility(View.GONE);
        }
    }


    @OnClick(R.id.back)
    public void onClick() {
        getActivity().finish();
    }



}
