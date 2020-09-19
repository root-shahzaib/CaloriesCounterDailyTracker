package com.calories.counter.daily.tracker.Fragments.Meal.Breakfast;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.calories.counter.daily.tracker.R;
import java.util.ArrayList;
import java.util.List;


public class MealBreakfast extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<Model_ClassBreakfast> model_classBreakfastArrayList;
    Model_ClassBreakfast model_classBreakfast;
    BreakfastFoodAdapter breakfastFoodAdapter;

    public MealBreakfast() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meal_breakfast, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view_breakfast);
        model_classBreakfastArrayList = new ArrayList<>();
      for (int i = 0; i<BreakFastFoodArray.breakfastfoodName.length; i++){

          model_classBreakfastArrayList.add(new Model_ClassBreakfast(BreakFastFoodArray.breakfastfoodName[i],
                          BreakFastFoodArray. breakfastCalories[i],BreakFastFoodArray.breakfastMeasurement[i],
                          BreakFastFoodArray.breakfastImages[i]));
      }
        breakfastFoodAdapter = new BreakfastFoodAdapter(view.getContext(),model_classBreakfastArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setHasFixedSize(false);
        Toast.makeText(view.getContext(), String.valueOf(model_classBreakfastArrayList.size()), Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(breakfastFoodAdapter);

        return view;
    }
}