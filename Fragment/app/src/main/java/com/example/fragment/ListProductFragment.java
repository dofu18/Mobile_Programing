package com.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ListProductFragment extends Fragment {
    public interface OnProductSelectedListener {
        void onProductSelected(String productName);
    }

    private OnProductSelectedListener callback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnProductSelectedListener) {
            callback = (OnProductSelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnProductSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_product, container, false);
        ListView listView = view.findViewById(R.id.product_list);

        final String[] products = {"Perfume A", "Perfume B", "Perfume C"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedProduct = products[position];
            if (callback != null) {
                callback.onProductSelected(selectedProduct);
            }
        });

        return view;
    }
}
