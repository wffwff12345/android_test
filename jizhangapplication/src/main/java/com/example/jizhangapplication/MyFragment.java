package com.example.jizhangapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class MyFragment extends Fragment {

    private MaterialButton settingsButton;
    private MaterialButton recordsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);

        settingsButton = view.findViewById(R.id.settingsButton);
        recordsButton = view.findViewById(R.id.recordsButton);

        setupButtons();

        return view;
    }

    private void setupButtons() {
        settingsButton.setOnClickListener(v -> {
            // TODO: 实现跳转到设置页面
            Intent intent = new Intent(requireContext(), SettingsActivity.class);
            startActivity(intent);
        });

        recordsButton.setOnClickListener(v -> {
            // 跳转到记账记录的多维表格地址
            String url = "https://example.com/records"; // TODO: 替换为实际的记账记录URL
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}