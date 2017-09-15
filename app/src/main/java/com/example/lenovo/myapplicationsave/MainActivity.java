package com.example.lenovo.myapplicationsave;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private Button bt1;
    private  final  static  String SharedPreferencesFileName="config";
    private  final  static  String Key_UserName="UserName";//
    private  final  static  String  Key_LoginDate="LoginDate";//
    private  final  static  String  Key_UserType="UserType";
    SharedPreferences  Preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button)super.findViewById(R.id.button);
        bt1=(Button)super.findViewById(R.id.button2);

        Preferences=getSharedPreferences(SharedPreferencesFileName,
                MODE_PRIVATE);
        editor=Preferences.edit();

        bt.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                String strLoginDate = simpleDateFormat.format(new Date(

                ));
                editor.putString(Key_UserName,"666");
                editor.putString(Key_LoginDate,strLoginDate);
                editor.putInt(Key_UserType,1);
                editor.apply();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strusername = Preferences.getString(Key_UserName, null);
                String strLoginDate = Preferences.getString(Key_LoginDate, null);
                int nuserTpye = Preferences.getInt(Key_UserType, 0);
              //  if (strusername != null && strLoginDate != null)
                    Toast.makeText(MainActivity.this, "用户名:" + strusername + "登录时间:" + strLoginDate + "用户类型:" + nuserTpye, Toast.LENGTH_LONG).show();

             //   else
                 //   Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });

}
}
