package com.calories.counter.daily.tracker.Fragments.Meal.Breakfast;

public class Model_ClassBreakfast {

    private String FoodName;
    private String FoodCalories;
    private String FoodMeasurement;
    private int FoodImages;

    public Model_ClassBreakfast(String FoodName, String FoodCalories, String FoodMeasurement, int FoodImages) {

       this.FoodName = FoodName;
        this. FoodCalories = FoodCalories;
        this. FoodMeasurement = FoodMeasurement;
        this. FoodImages = FoodImages;
    }

    public String getFoodName() {
        return FoodName;
    }

    public void setFoodName(String foodName) {
        FoodName = foodName;
    }


    public String getFoodCalories() {
        return FoodCalories;
    }

    public void setFoodCalories(String foodCalories) {
        FoodCalories = foodCalories;
    }

    public String getFoodMeasurement() {
        return FoodMeasurement;
    }

    public void setFoodMeasurement(String foodMeasurement) {
        FoodMeasurement = foodMeasurement;
    }

    public int getFoodImages() {
        return FoodImages;
    }

    public void setFoodImages(int foodImages) {
        FoodImages = foodImages;
    }



}
