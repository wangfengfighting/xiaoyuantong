package com.example.school.xiaoyuantong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("ValidFragment")
public class TestFragment_register extends Fragment {
	private String textString;
	public static String layout="";
	public TestFragment_register(String textString) {
		this.textString = textString;
	}

	public static TestFragment_register newInstance(String textString) {
		TestFragment_register mFragment = new TestFragment_register(textString);
		return mFragment;

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
	{
		View view=inflater.inflate(R.layout.fragemt_register, container, false);
		return view;
	}
}
