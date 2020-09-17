package com.calories.counter.daily.tracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.calories.counter.daily.tracker.Fragments.Weight.ShowWeightData;
import com.calories.counter.daily.tracker.Fragments.Weight.WeightDBModel;
import com.calories.counter.daily.tracker.MealDatabase.CaloriesDatabase;
import com.calories.counter.daily.tracker.Fragments.BeforeAfter.BeforeAfter;
import com.calories.counter.daily.tracker.Fragments.Dashboard.Dashboard;
import com.calories.counter.daily.tracker.Fragments.DailyNotepad.DialyNotepad;
import com.calories.counter.daily.tracker.Fragments.Excerise.Exercise;
import com.calories.counter.daily.tracker.Fragments.HealthBlog.HealthBlogs;
import com.calories.counter.daily.tracker.Fragments.Meal.Meals;
import com.calories.counter.daily.tracker.Fragments.MyPlans.MyPlan;
import com.calories.counter.daily.tracker.Fragments.RecipesAndFacts.RecipesFacts;
import com.calories.counter.daily.tracker.Fragments.Vitamins.Vitamins;
import com.calories.counter.daily.tracker.Fragments.Water.Water;
import com.calories.counter.daily.tracker.Fragments.Weight.Weight;
import com.calories.counter.daily.tracker.MealDatabase.ModelClasses.WeightModel;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    SQLiteDatabase database;
    CaloriesDatabase helperDatabase;
    FrameLayout frameLayout;
    private int vl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById();
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.Dashboard_nav);
        onNavigationItemSelected(navigationView.getMenu().getItem(0));
        helperDatabase = new CaloriesDatabase(this);
        database = helperDatabase.getWritableDatabase();

     }

    public void findViewById() {
        Button button = (Button) findViewById(R.id.getdatabutton);
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer);
        navigationView = (NavigationView) findViewById(R.id.main_navigationview);
        frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.Dashboard_nav:
                fragment = new Dashboard();
                break;
            case R.id.Meals_nav:
                fragment = new Meals();
                break;
            case R.id.Weight_nav:
               int val =  helperDatabase.getProfilesCount(database);
                if(val == 0) {
                    fragment = new Weight();
                }
                else
                {
                    fragment = new ShowWeightData();
                }
                break;
            case R.id.Excerise_nav:
                fragment = new Exercise();
                break;
            case R.id.Water_nav:
                fragment = new Water();
                break;
            case R.id.Notepad_nav:
                fragment = new DialyNotepad();
                break;
            case R.id.Vitamins_nav:
                fragment = new Vitamins();
                break;
            case R.id.MyPlans_nav:
                fragment = new MyPlan();
                break;
            case R.id.BeforeAndAfter_nav:
                fragment = new BeforeAfter();
                break;
            case R.id.Recipes_nav:
                fragment = new RecipesFacts();
                break;
            case R.id.healthblog_nav:
                fragment = new HealthBlogs();
                break;
            case R.id.shareit_nav:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                item.setCheckable(false);
                break;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}