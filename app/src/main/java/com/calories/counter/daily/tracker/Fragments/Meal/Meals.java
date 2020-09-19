package com.calories.counter.daily.tracker.Fragments.Meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.calories.counter.daily.tracker.Fragments.Meal.Breakfast.MealBreakfast;
import com.calories.counter.daily.tracker.R;

public class Meals extends Fragment implements View.OnClickListener
{
    private CardView BreakFastCardView,LunchCardView,DinnerCardView,SnacksCardView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_meal,null,false);
       BreakFastCardView = (CardView)view.findViewById(R.id.breakfast_cardview_meal);
       LunchCardView = (CardView)view.findViewById(R.id.lunch_cardview_meal);
       DinnerCardView = (CardView)view.findViewById(R.id.dinner_cardview_meal);
       SnacksCardView = (CardView)view.findViewById(R.id.snacks_cardview_meal);
       BreakFastCardView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
       switch (view.getId())
       {
           case R.id.breakfast_cardview_meal :
               Bundle bundle = new Bundle();
               bundle.putString("key","abc");
               MealBreakfast breakfastfragment = new MealBreakfast();
               breakfastfragment.setArguments(bundle);
               getActivity().getSupportFragmentManager().beginTransaction()
                       .replace(R.id.fragment_container, breakfastfragment, "null")
                       .addToBackStack(null).commit();
                         break;
       }

    }
}
