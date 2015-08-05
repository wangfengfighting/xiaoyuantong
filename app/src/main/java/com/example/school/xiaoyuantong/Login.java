package com.example.school.xiaoyuantong;

import java.util.ArrayList;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends ActionBarActivity {
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private ViewPagerTab mViewPagerTab;
    private ViewPager mPager;
    private ArrayList<Fragment> fragmentsList;
    private LinearLayout ll_top;
    private Button login;
    public TextView userName,passWord;
    String username="",password="";
    Toast tst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__register_view);
       // initView();
        setUpViewPage();
        setUpTab();
        userName=(TextView)findViewById(R.id.username);
        passWord=(TextView)findViewById(R.id.password);
        try {
            username = userName.getText().toString();
            password = passWord.getText().toString();
        }
        catch (Exception e){
            Log.i("ddd",e.toString());
        }
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.BtnLogin:
                if(username==""){
                    tst = Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT);
                    tst.show();
                }
                else if (password=="")
                {
                    tst = Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT);
                    tst.show();
                }
                break;
            case R.id.Btngetcode:
                /**
                 * 获取短信验证码
                 */
                tst = Toast.makeText(this, "短信已发送，注意接收", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.ReBtnReGetcode:
                /**
                 * 重新获取验证码
                 */
                tst = Toast.makeText(this, "重新获取验证码，请注意接收", Toast.LENGTH_SHORT);
                tst.show();
                break;
            case R.id.BtnNext:
                try {
                    Intent intent=new Intent(Login.this,Info_Activity.class);
                    startActivity(intent);


                }
                catch (Exception e)
                {
                    Log.i("info",e.toString());
                }
                break;
            case R.id.Btn_submit:
                Log.i("ddddd","ddddddddddddddddddddddddddddd");
                    tst = Toast.makeText(this, "注册成功，请返回登录", Toast.LENGTH_SHORT);
                    tst.show();
                break;

            default:
                tst = Toast.makeText(this, "nothing", Toast.LENGTH_SHORT);
                tst.show();
                break;
        }
    }

    private void initView() {
        ll_top = (LinearLayout) findViewById(R.id.ll_top);
        mPager = (ViewPager) findViewById(R.id.vPager);
        fragmentsList = new ArrayList<Fragment>();
        Fragment login = TestFragment.newInstance("登录");
        Fragment register = TestFragment_register.newInstance("注册");
        Fragment registernext = TestFragment_register.newInstance("注册next");
        fragmentsList.add(login);
        fragmentsList.add(register);
        fragmentsList.add(registernext);
        mPager.setAdapter(new MyFragmentPagerAdapter(
                getSupportFragmentManager(), fragmentsList));
        mPager.setCurrentItem(0);

        BottomTabBar navigationBar = new BottomTabBar(this);
        navigationBar.attachToParent(ll_top, new String[] { "登录", "注册"}, mPager);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private ArrayList<Fragment> fragmentsList;

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public MyFragmentPagerAdapter(FragmentManager fm,
                                      ArrayList<Fragment> fragments) {
            super(fm);
            this.fragmentsList = fragments;
        }

        @Override
        public int getCount() {
            return fragmentsList.size();
        }

        @Override
        public Fragment getItem(int arg0) {
            return fragmentsList.get(arg0);
        }

        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

    }


    private void setUpTab(){
        mViewPagerTab = (ViewPagerTab) findViewById(R.id.viewpager_tab);
        mViewPagerTab.setViewPager(mViewPager);
        ImageView childView = new ImageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
        childView.setImageResource(R.drawable.line);
        childView.setLayoutParams(params);
        mViewPagerTab.addView(childView);
    }

    private void setUpViewPage(){
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    /**
     * ViewPager适配器
     * @author 王峰
     *
     */
    class ViewPagerAdapter extends FragmentPagerAdapter{

        private Class[] fragments;
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            fragments = new Class[]{Fragment1.class, Fragment3.class};
        }

        @Override
        public Fragment getItem(int position) {
            try {
                return (Fragment) fragments[position].newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

    }

}


