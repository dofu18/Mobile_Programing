package com.example.labfragment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.labfragment.ProductAdapter;
import com.example.labfragment.R;
import com.example.labfragment.model.Product;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private List<Product> productList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        productList = getFakeProducts();
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);

        return rootView;
    }

    private List<Product> getFakeProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Nike Shoes", "Comfortable running shoes", 79.99, R.drawable.nike_shoes));
        products.add(new Product("Samsung Galaxy S25 Ultra", "Latest Android smartphone", 999.99, R.drawable.samsung_phone));
        products.add(new Product("Iphone 16 Pro Max", "Latest Apple smartphone", 199.99, R.drawable.iphone16));
        return products;
    }
}
