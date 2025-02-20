package com.example.lab05inclass;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab05inclass.adapter.UserAdapter;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);

        //lookup the RecycleView in Activity layout
        RecyclerView rvUser = findViewById(R.id.rvUser);

        //initialize user list
        userList = new ArrayList<>();
        userList.add(new User("NguyenTT","Tran Thanh Nguyen","Nguyentt@fpt.edu.vn"));
        userList.add(new User("PhuDHT","Do Hoang Ty Phu","Phudht@fpt.edu.vn"));
        userList.add(new User("ANV","Nguyen Van A","Avn@fpt.edu.vn"));
        userList.add(new User("BTT","Tran Thi B","Btt@fpt.edu.vn"));
        userList.add(new User("BangTT","Tran Thanh Bang","Bangtt@fpt.edu.vn"));
        userList.add(new User("KhangTT","Tran Thanh Khang","Khangtt@fpt.edu.vn"));
        userList.add(new User("BaoTT","Tran Thanh Bao","Baott@fpt.edu.vn"));
        userList.add(new User("HungVH","Vu Huy Hung","Hungvv@fpt.edu.vn"));

        //Create adapter passing in the sample user data
        UserAdapter adapter = new UserAdapter(userList);

        //Attach the adapter to the recyclerview to populate items
        rvUser.setAdapter(adapter);

        //Set layout manager to position the items
        rvUser.setLayoutManager(new LinearLayoutManager(this));
    }
}