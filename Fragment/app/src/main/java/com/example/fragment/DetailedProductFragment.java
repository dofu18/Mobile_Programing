package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailedProductFragment extends Fragment {
    private static final String ARG_PRODUCT_NAME = "product_name";

    public static DetailedProductFragment newInstance(String productName) {
        DetailedProductFragment fragment = new DetailedProductFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PRODUCT_NAME, productName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed_product, container, false);
        TextView productNameTextView = view.findViewById(R.id.product_name);
        Button btnBack = view.findViewById(R.id.btn_back); // Find Back button

        if (getArguments() != null) {
            String productName = getArguments().getString(ARG_PRODUCT_NAME);
            productNameTextView.setText(productName);
        }
        // Handle Back button click
        btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ListProductFragment()) // Navigate back
                    .commit();
        });

        return view;
    }
}
