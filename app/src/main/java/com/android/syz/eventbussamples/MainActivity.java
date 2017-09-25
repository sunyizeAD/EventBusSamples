package com.android.syz.eventbussamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.text);
        initView();
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("孙一泽",24));
            }
        });
    }

    private void initView() {
        fl_one = (FrameLayout) findViewById(R.id.fl_one);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onClickText(MessageEvent event){
        Toast.makeText(this,"测试EventBus"+event.getName()+"---"+event.getAge(),Toast.LENGTH_LONG).show();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_one,new FramLayoutOne()).commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    public void clickbtn(View view){
        Toast.makeText(this,"点击fragment1按钮",Toast.LENGTH_SHORT).show();
    }
}
