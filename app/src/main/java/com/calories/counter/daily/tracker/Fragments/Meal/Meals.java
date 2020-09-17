package com.calories.counter.daily.tracker.Fragments.Meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.calories.counter.daily.tracker.R;

public class Meals extends Fragment
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






















        return view;
    }
}
