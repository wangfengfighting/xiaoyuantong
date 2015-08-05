package com.example.school.xiaoyuantong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class TestFragment extends Fragment {
	private String textString;
	public static String layout="";
	public TestFragment(String textString) {
		this.textString = textString;
	}

	public static TestFragment newInstance(String textString) {
		TestFragment mFragment = new TestFragment(textString);
		return mFragment;

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.fragment_main, container, false);
		return view;
	}
}
