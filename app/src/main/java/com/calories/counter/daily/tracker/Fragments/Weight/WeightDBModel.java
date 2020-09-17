package com.calories.counter.daily.tracker.Fragments.Weight;

public class WeightDBModel
{
    String Name,Gender,Height;
    int Age,CurrentWeight,TargetWeight;


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getHeight() {
        return Height;
    }

    public void setHeight(String height) {
        Height = height;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getCurrentWeight() {
        return CurrentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        CurrentWeight = currentWeight;
    }

    public int getTargetWeight() {
        return TargetWeight;
    }

    public void setTargetWeight(int targetWeight) {
        TargetWeight = targetWeight;
    }
}
