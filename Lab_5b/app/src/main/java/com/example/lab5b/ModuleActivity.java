package com.example.lab5b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModuleActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADD_ITEM = 1;
    private static final int REQUEST_CODE_EDIT_ITEM = 2;

    ArrayList<Module> moduleList;
    RecyclerView rvModules;
    ModuleAdapter moduleAdapter;
    int editPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvModules = findViewById(R.id.recyclerView);
        moduleList = new ArrayList<>();

        // Add sample data to moduleList
        moduleList.add(new Module("List view trong Android", "ListView là phần tử View được dùng để hiện thị dữ liệu là một danh sách (mảng) từ một nguồn cấp gọi là Adapter", "https://duythanhcse.wordpress.com/wp-content/uploads/2013/04/13_lv_01.png", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d7/Android_robot.svg/1745px-Android_robot.svg.png"));
        moduleList.add(new Module("Xử lý sự kiện trong IOS", "Trong iOS, xử lý sự kiện là quá trình xử lý các hành động hoặc tương tác từ người dùng. ", "https://r2s.edu.vn/wp-content/uploads/2023/10/xu-ly-su-kien-trong-ios-11-1024x576.png", "https://logowik.com/content/uploads/images/ios1780.logowik.com.webp"));

        moduleAdapter = new ModuleAdapter(moduleList, new ModuleAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                editPosition = position;
                Module module = moduleList.get(position);
                Intent intent = new Intent(ModuleActivity.this, AddModuleActivity.class);
                intent.putExtra("EDIT_MODE", true);
                intent.putExtra("ten", module.getTen());
                intent.putExtra("mota", module.getMota());
                intent.putExtra("imageUrl", module.getHinhAnh());
                intent.putExtra("iconUrl", module.getIcon());
                startActivityForResult(intent, REQUEST_CODE_EDIT_ITEM);
            }

            @Override
            public void onDeleteClick(int position) {
                moduleList.remove(position);
                moduleAdapter.notifyItemRemoved(position);
            }
        });
        rvModules.setAdapter(moduleAdapter);
        rvModules.setLayoutManager(new LinearLayoutManager(this));

        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModuleActivity.this, AddModuleActivity.class);
                startActivityForResult(intent, REQUEST_CODE_ADD_ITEM);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            String username = data.getStringExtra("ten");
            String fullName = data.getStringExtra("mota");
            String imageUrl = data.getStringExtra("imageUrl");
            String iconUrl = data.getStringExtra("iconUrl");

            if (requestCode == REQUEST_CODE_ADD_ITEM) {
                Module newModule = new Module(username, fullName, imageUrl, iconUrl);
                moduleList.add(newModule);
                moduleAdapter.notifyItemInserted(moduleList.size() - 1);
                rvModules.scrollToPosition(moduleList.size() - 1);
            } else if (requestCode == REQUEST_CODE_EDIT_ITEM && editPosition != -1) {
                Module updatedModule = moduleList.get(editPosition);
                updatedModule.setTen(username);
                updatedModule.setMota(fullName);
                updatedModule.setHinhAnh(imageUrl);
                updatedModule.setIcon(iconUrl);
                moduleAdapter.notifyItemChanged(editPosition);
                editPosition = -1;
            }
        }
    }
}
