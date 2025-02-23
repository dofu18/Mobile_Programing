package com.example.lab_4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DrinkActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnOrderDrink;
    private ArrayList<Drink> drinkList;
    private ArrayList<Drink> selectedDrinks;
    private Drink selectedDrink = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        listView = findViewById(R.id.listViewDrink);
        btnOrderDrink = findViewById(R.id.btnOrderDrink);
        selectedDrinks = new ArrayList<>();

        drinkList = new ArrayList<>();
        drinkList.add(new Drink("Pepsi", "Nước ngọt có ga", "15000", R.drawable.pepsi));
        drinkList.add(new Drink("Heineken", "Bia Heineken nhập khẩu", "25000", R.drawable.heineken));
        drinkList.add(new Drink("Tiger", "Bia Tiger lon", "22000", R.drawable.tiger));
        drinkList.add(new Drink("Sài Gòn Đỏ", "Bia Sài Gòn truyền thống", "20000", R.drawable.saigondo));

        DrinkAdapter adapter = new DrinkAdapter(this, R.layout.list_item_drink, drinkList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Drink selectedDrink = drinkList.get(position);

            if (selectedDrinks.contains(selectedDrink)) {
                selectedDrinks.remove(selectedDrink);
                Toast.makeText(this, "Bỏ chọn: " + selectedDrink.getName(), Toast.LENGTH_SHORT).show();
            } else {
                selectedDrinks.add(selectedDrink);
                Toast.makeText(this, "Đã chọn: " + selectedDrink.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        btnOrderDrink.setOnClickListener(v -> {
            ArrayList<Drink> selectedDrinks = (ArrayList<Drink>) adapter.getSelectedDrinks();

            if (!selectedDrinks.isEmpty()) {
                Intent intent = new Intent();
                ArrayList<String> selectedNames = new ArrayList<>();
                ArrayList<String> selectedPrices = new ArrayList<>();

                for (Drink drink : selectedDrinks) {
                    selectedNames.add(drink.getName());
                    selectedPrices.add(drink.getPrice());
                }

                intent.putStringArrayListExtra("names", selectedNames);
                intent.putStringArrayListExtra("prices", selectedPrices);

                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(DrinkActivity.this, "Vui lòng chọn ít nhất một đồ uống!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
