package com.example.mysp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_name;
    private EditText et_pwd;
    private CheckBox rememberPwd;
    private CheckBox autoLogin;
    private Button register;
    private Button login;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("config", MODE_PRIVATE);
        initView();
        boolean spBoolean = sp.getBoolean("rememberPwd", false);
        boolean aBoolean = sp.getBoolean("autoLogin", false);
        if (spBoolean) {
            String name = sp.getString("name", "");
            String pwd = sp.getString("pwd", "");
            et_name.setText(name);
            et_pwd.setText(pwd);
            rememberPwd.setChecked(true);
        }
        if (aBoolean) {
            autoLogin.setChecked(true);
            Toast.makeText(this, "您已经自动登录", Toast.LENGTH_SHORT).show();
        }
    }

    private void initView() {
        et_name = findViewById(R.id.name);
        et_pwd = findViewById(R.id.pwd);
        rememberPwd = findViewById(R.id.rememberPwd);
        autoLogin = findViewById(R.id.autoLogin);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                break;
            case R.id.login:
                String name = et_name.getText().toString().trim();
                String pwd = et_pwd.getText().toString().trim();
                if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
                    Toast.makeText(MainActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (rememberPwd.isChecked()) {
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putString("name", name);
                        edit.putString("pwd", pwd);
                        edit.putBoolean("rememberPwd", true);
                        edit.apply();
                    }
                    if (autoLogin.isChecked()) {
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putBoolean("autoLogin", true);
                        edit.apply();
                    }
                }
                break;
        }

    }
}