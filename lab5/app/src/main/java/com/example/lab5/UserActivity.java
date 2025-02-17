package com.example.lab5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab5.adapter.UserAdapter;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    ArrayList<User> userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        RecyclerView rvUser = findViewById(R.id.rvUser);

        userlist = new ArrayList<>();

        userlist.add(new User("NguyenTT", "Tran Thanh Nguyen","Nguyentt@fpt.edu.vn"));
        userlist.add(new User("PhuDHT", "Do Hoang Ty Phu","PhuDHT@fpt.edu.vn"));
        userlist.add(new User("Antv", "Tran Van An","AnTV@fpt.edu.vn"));
        userlist.add(new User("BangTT", "Tran Thanh Bang","BangTT@fpt.edu.vn"));
        userlist.add(new User("KhangTT", "Tran Thanh Khang","KHangTT@fpt.edu.vn"));
        userlist.add(new User("DOPHU", "Do Phu","phudht@gmail.com"));

        UserAdapter adapter = new UserAdapter(userlist);
        rvUser.setAdapter(adapter);
        rvUser.setLayoutManager(new LinearLayoutManager(this));
    }
}