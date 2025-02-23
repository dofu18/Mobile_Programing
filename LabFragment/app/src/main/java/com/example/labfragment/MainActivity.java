package com.example.labfragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ✅ Set Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // ✅ Custom Title
        TextView title = findViewById(R.id.toolbar_title);
        title.setText("Shoppe Phake"); // Change dynamically if needed

        // ✅ Search Click Event
        ImageView search = findViewById(R.id.toolbar_search);
        search.setOnClickListener(view ->
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
        );

        // ✅ Profile Click Event
        ImageView profile = findViewById(R.id.toolbar_profile);
        profile.setOnClickListener(view ->
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show()
        );

        // ✅ Initialize Views
        viewPager = findViewById(R.id.view_pager);
        bottomNavigationView = findViewById(R.id.nav_view);

        // ✅ Set Up ViewPager Adapter
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // ✅ Sync BottomNavigationView with ViewPager2
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                viewPager.setCurrentItem(0);
                return true;
            } else if (itemId == R.id.navigation_dashboard) {
                viewPager.setCurrentItem(1);
                return true;
            } else if (itemId == R.id.navigation_notifications) {
                viewPager.setCurrentItem(2);
                return true;
            }
            return false;
        });

        // ✅ Sync ViewPager2 with BottomNavigationView
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });
    }
}

