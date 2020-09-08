package com.calories.counter.daily.tracker.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.calories.counter.daily.tracker.R;

public class RecipesFacts extends Fragment {

    private WebView HealthBlog;
    private ImageView loadingimg;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipesfacts, null, false);

        loadingimg = (ImageView)view.findViewById(R.id.recipesfacts_loadingimg);
        HealthBlog = (WebView)view.findViewById(R.id.recipesfacts_webview);
        HealthBlog.setWebViewClient(new WebViewClient());
        HealthBlog.loadUrl("https://pinchofyum.com/");





        return view;
    }
}