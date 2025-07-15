package com.example.jizhangapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class HomeFragment extends Fragment {

    private AutoCompleteTextView categoryAutoComplete;
    private TextInputEditText amountEditText;
    private TextInputEditText noteEditText;
    private MaterialButton submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        categoryAutoComplete = view.findViewById(R.id.categoryAutoComplete);
        amountEditText = view.findViewById(R.id.amountEditText);
        noteEditText = view.findViewById(R.id.noteEditText);
        submitButton = view.findViewById(R.id.submitButton);

        setupCategoryDropdown();
        setupSubmitButton();

        return view;
    }

    private void setupCategoryDropdown() {
        String[] expenseCategories = {"餐饮", "交通", "购物", "娱乐", "居家", "其他"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, expenseCategories);
        categoryAutoComplete.setAdapter(adapter);
    }

    private void setupSubmitButton() {
        submitButton.setOnClickListener(v -> {
            if (validateForm()) {
                // TODO: 实现记账数据的保存
                Toast.makeText(requireContext(), "记账成功", Toast.LENGTH_SHORT).show();
                clearForm();
            }
        });
    }

    private boolean validateForm() {
        String category = categoryAutoComplete.getText().toString();
        String amount = amountEditText.getText().toString();

        if (category.isEmpty()) {
            Toast.makeText(requireContext(), "请选择分类", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (amount.isEmpty()) {
            Toast.makeText(requireContext(), "请输入金额", Toast.LENGTH_SHORT).show();
            return false;
        }

        try {
            double value = Double.parseDouble(amount);
            if (value <= 0) {
                Toast.makeText(requireContext(), "金额必须大于0", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (NumberFormatException e) {
            Toast.makeText(requireContext(), "请输入有效的金额", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void clearForm() {
        categoryAutoComplete.setText("");
        amountEditText.setText("");
        noteEditText.setText("");
    }
}