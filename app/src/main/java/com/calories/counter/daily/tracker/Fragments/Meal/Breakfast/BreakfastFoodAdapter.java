package com.calories.counter.daily.tracker.Fragments.Meal.Breakfast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.calories.counter.daily.tracker.R;

import java.util.ArrayList;

public class BreakfastFoodAdapter extends RecyclerView.Adapter<BreakfastFoodAdapter.ViewHolder>
{
    Context context;
    ArrayList<Model_ClassBreakfast> model_classBreakfasts;

    public BreakfastFoodAdapter(Context context, ArrayList<Model_ClassBreakfast> model_classBreakfasts) {
        this.context = context;
        this.model_classBreakfasts = model_classBreakfasts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.customrecyclerview_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       Model_ClassBreakfast breakfast = model_classBreakfasts.get(position);
       holder.img.setImageResource(breakfast.getFoodImages());
       holder.FoodName.setText(breakfast.getFoodName());
       holder.Calories.setText(breakfast.getFoodCalories()+"/");
       holder.Measurement.setText(breakfast.getFoodMeasurement());

       holder.FoodName.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               MealBreakfast breakfastfragment = new MealBreakfast();

               context..beginTransaction()
                       .replace(R.id.fragment_container, breakfastfragment, "null")
                       .addToBackStack(null).commit();
           }
       });
    }

    @Override
    public int getItemCount() {
        return model_classBreakfasts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView FoodName,Calories,Measurement;

        public ViewHolder(@NonNull View itemView ,int position) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.foodImage_id);
            FoodName = (TextView)itemView.findViewById(R.id.food_Nameid);
            Calories = (TextView)itemView.findViewById(R.id.foodcalories_id);
            Measurement = (TextView)itemView.findViewById(R.id.foodmeasurement_id);


        }
    }
}
