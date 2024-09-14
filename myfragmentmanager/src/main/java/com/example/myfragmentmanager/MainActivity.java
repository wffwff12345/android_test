package com.example.myfragmentmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.fmbt);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.fmbt2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fmbt:
                Bundle bundle = new Bundle();
                bundle.putString("message","信息");
                BlankFragment blankFragment = new BlankFragment();
                blankFragment.SetFragmentCallBack(new IFragmentCallBack() {
                    @Override
                    public void sendMsgToActivity(String msg) {
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public String GetMsgFromActivity(String msg) {
                        return "接受来自activity的消息";
                    }
                });

                //blankFragment.setArguments(bundle);
                replaceFragment(blankFragment);
                break;
            case R.id.fmbt2:
                replaceFragment(new ItemFragment());
                break;

        }
    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fmf,fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}