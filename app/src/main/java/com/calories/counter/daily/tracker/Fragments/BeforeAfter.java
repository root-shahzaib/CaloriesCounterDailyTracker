package com.calories.counter.daily.tracker.Fragments;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.calories.counter.daily.tracker.R;
public class BeforeAfter extends Fragment {
    RelativeLayout BeforeLayout, AfterLayout;
    ImageView BeforeImg, AfterImg;
    public static final int IMAGE_PICK_CODE = 1000;
    public static final int PERMISSION_CODE = 1001;
    int BL = 0;
    int AL = 0;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beforeafter, null, false);
        findViewByIds(view);
        BeforeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BL =1;
                AL =0;
                ImagePicker();
            }
        });
        AfterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AL =1;
                BL = 0;
               ImagePicker();
            }
        });

        return view;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE && data != null)
        {
            if(BL == 0 && AL == 1)
            {
                Uri value = data.getData();
                AfterImg.setImageURI(value);
            }
            if(BL == 1 && AL == 0)
            {
                Uri value = data.getData();
                BeforeImg.setImageURI(value);
            }

        }

    }
    private void ImagePicker() {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }
    public void findViewByIds(View view) {
        BeforeLayout = (RelativeLayout) view.findViewById(R.id.beforeafter_before_layout);
        AfterLayout = (RelativeLayout) view.findViewById(R.id.beforeafter_after_layout);
        BeforeImg = (ImageView) view.findViewById(R.id.BeforeImg_beforeafter);
        AfterImg = (ImageView) view.findViewById(R.id.afterImg_beforeafter);


    }
}