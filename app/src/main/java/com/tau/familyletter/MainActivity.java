package com.tau.familyletter;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    /**
     * 底部五个按钮
     */
    private LinearLayout mTabBtnLetter;
    private LinearLayout mTabBtnAlarm;
    private LinearLayout mTabBtnChat;
    private LinearLayout mTabBtnMemoday;
    private LinearLayout mTabBtnSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mTabBtnLetter = (LinearLayout) findViewById(R.id.tab_bottom_letter);
        mTabBtnAlarm = (LinearLayout) findViewById(R.id.tab_bottom_alarm);
        mTabBtnChat = (LinearLayout) findViewById(R.id.tab_bottom_chat);
        mTabBtnMemoday = (LinearLayout) findViewById(R.id.tab_bottom_memoday);
        mTabBtnSettings = (LinearLayout) findViewById(R.id.tab_bottom_setting);

        mTabBtnAlarm.setOnClickListener(this);
        mTabBtnLetter.setOnClickListener(this);
        mTabBtnChat.setOnClickListener(this);
        mTabBtnMemoday.setOnClickListener(this);
        mTabBtnSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_bottom_letter:
                setTabSelection(0);
                break;
            case R.id.tab_bottom_alarm:
                setTabSelection(1);
                break;
            case R.id.tab_bottom_chat:
                setTabSelection(2);
                break;
            case R.id.tab_bottom_memoday:
                setTabSelection(3);
                break;
            case R.id.tab_bottom_setting:
                setTabSelection(4);
                break;

            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     */
    private void setTabSelection(int index) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        // 重置按钮
        resetBtn();
        // 当点击了消息tab时，改变控件的图片和文字颜色
        switch (index) {
            case 0:

                ((ImageView) mTabBtnLetter.findViewById(R.id.imageView_letter))
                        .setImageResource(R.drawable.open56_deep);
                ((TextView) mTabBtnLetter.findViewById(R.id.textView_tab_letter))
                        .setTextColor(Color.parseColor("#15B5E9"));
                mFragmentManager.beginTransaction()
                        .replace(R.id.container, LetterFragment.newInstance("", ""))
                        .commit();
                break;
            case 1:
                ((ImageView) mTabBtnAlarm.findViewById(R.id.imageView_alarm))
                        .setImageResource(R.drawable.alarm12_deep);
                ((TextView) mTabBtnAlarm.findViewById(R.id.textView_tab_alarm))
                        .setTextColor(Color.parseColor("#15B5E9"));
                mFragmentManager.beginTransaction()
                        .replace(R.id.container, AlarmFragment.newInstance("", ""))
                        .commit();
                break;
            case 2:
                ((ImageView) mTabBtnChat.findViewById(R.id.imageView_chat))
                        .setImageResource(R.drawable.walk10_deep);
                ((TextView) mTabBtnChat.findViewById(R.id.textView_tab_chat))
                        .setTextColor(Color.parseColor("#15B5E9"));
                mFragmentManager.beginTransaction()
                        .replace(R.id.container, ChatFragment.newInstance("", ""))
                        .commit();
                break;
            case 3:
                ((ImageView) mTabBtnMemoday.findViewById(R.id.imageView_memoday))
                        .setImageResource(R.drawable.favourite7_deep);
                ((TextView) mTabBtnMemoday.findViewById(R.id.textView_tab_memoday))
                        .setTextColor(Color.parseColor("#15B5E9"));
                mFragmentManager.beginTransaction()
                        .replace(R.id.container, MemorialDayFragment.newInstance("", ""))
                        .commit();
                break;
            case 4:
                ((ImageView) mTabBtnSettings.findViewById(R.id.imageView_setting))
                        .setImageResource(R.drawable.cogwheel4_deep);
                ((TextView) mTabBtnSettings.findViewById(R.id.textView_tab_setting))
                        .setTextColor(Color.parseColor("#15B5E9"));
                mFragmentManager.beginTransaction()
                        .replace(R.id.container, SettingFragment.newInstance("", ""))
                        .commit();
                break;
        }
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void resetBtn() {
        ((ImageView) mTabBtnLetter.findViewById(R.id.imageView_letter))
                .setImageResource(R.drawable.open56);
        ((ImageView) mTabBtnAlarm.findViewById(R.id.imageView_alarm))
                .setImageResource(R.drawable.alarm12);
        ((ImageView) mTabBtnChat.findViewById(R.id.imageView_chat))
                .setImageResource(R.drawable.walk10);
        ((ImageView) mTabBtnMemoday.findViewById(R.id.imageView_memoday))
                .setImageResource(R.drawable.favourite7);
        ((ImageView) mTabBtnSettings.findViewById(R.id.imageView_setting))
                .setImageResource(R.drawable.cogwheel4);

        ((TextView) mTabBtnLetter.findViewById(R.id.textView_tab_letter))
                .setTextColor(Color.parseColor("#80323232"));
        ((TextView) mTabBtnAlarm.findViewById(R.id.textView_tab_alarm))
                .setTextColor(Color.parseColor("#80323232"));
        ((TextView) mTabBtnChat.findViewById(R.id.textView_tab_chat))
                .setTextColor(Color.parseColor("#80323232"));
        ((TextView) mTabBtnMemoday.findViewById(R.id.textView_tab_memoday))
                .setTextColor(Color.parseColor("#80323232"));
        ((TextView) mTabBtnSettings.findViewById(R.id.textView_tab_setting))
                .setTextColor(Color.parseColor("#80323232"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
