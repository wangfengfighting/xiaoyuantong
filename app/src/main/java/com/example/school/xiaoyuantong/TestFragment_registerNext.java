package com.example.school.xiaoyuantong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class TestFragment_registerNext extends Fragment {
	private String textString;
	public static String layout="";
	public TestFragment_registerNext(String textString) {
		this.textString = textString;
	}

	public static TestFragment_registerNext newInstance(String textString) {
		TestFragment_registerNext mFragment = new TestFragment_registerNext(textString);
		return mFragment;

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.fragemt_registernext, container, false);
		return view;
	}
}
