package com.bawei.huwanjun.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.huwanjun.R;
import com.bawei.huwanjun.base.BaseFragment;
import com.bawei.huwanjun.base.BasePresenter;

import java.security.Key;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthersFragment extends BaseFragment {
    private TextView tv;


    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected void initView(View inflate) {
        tv=inflate.findViewById(R.id.tv);

    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_others;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();

        if (arguments != null) {
            String s = tv.getText().toString();
            tv.setText(s);
        }

    }

    public static OthersFragment getInstance(String values) {

        OthersFragment othersFragment = new OthersFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",values);
        othersFragment.setArguments(bundle);
        return othersFragment;
    }
}
