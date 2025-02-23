package com.example.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements ListProductFragment.OnProductSelectedListener {
    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Kiểm tra xem có FrameLayout của chế độ ngang hay không
        isLandscape = (findViewById(R.id.fragment_detail_container) != null);

        if (isLandscape) {
            // Chế độ ngang: Hiển thị cả hai Fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_list_container, new ListProductFragment())
                    .replace(R.id.fragment_detail_container, new DetailedProductFragment()) // Mặc định hiển thị màn hình rỗng
                    .commit();
        } else {
            // Chế độ dọc: Chỉ hiển thị ListProductFragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ListProductFragment())
                    .commit();
        }
    }

    @Override
    public void onProductSelected(String productName) {
        if (isLandscape) {
            // Nếu là chế độ ngang, cập nhật Fragment bên phải
            DetailedProductFragment detailFragment = DetailedProductFragment.newInstance(productName);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_detail_container, detailFragment)
                    .commit();
        } else {
            // Nếu là chế độ dọc, chuyển sang màn hình chi tiết
            DetailedProductFragment detailFragment = DetailedProductFragment.newInstance(productName);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailFragment)
                    .addToBackStack(null) // Cho phép quay lại danh sách sản phẩm
                    .commit();
        }
    }
}