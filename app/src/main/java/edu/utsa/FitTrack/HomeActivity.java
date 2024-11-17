package edu.utsa.FitTrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        TextView textView = findViewById(R.id.textView2);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        });

        Button quickWorkout = findViewById(R.id.button2);
        quickWorkout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), QuickWorkoutActivity.class);
            startActivity(intent);
        });

        Button newWorkout = findViewById(R.id.button3);
        newWorkout.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), WorkoutsActivity.class);
            startActivity(intent);
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setItemIconTintList(null); // Removes icon tint
        navView.setItemTextColor(null);
        navView.setOnItemSelectedListener(item ->  {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_notifications) {
                startActivity(new Intent(getApplicationContext(), NotificationsActivity.class));
                finish();
                return true;
            } else if (itemId == R.id.navigation_calorie) {
                startActivity(new Intent(getApplicationContext(), CalorieActivity.class));
                finish();
                return true;
            } else if(itemId == R.id.navigation_goals){
                startActivity(new Intent(getApplicationContext(), GoalsActivity.class));
                finish();
                return true;
            }
            else if(itemId == R.id.navigation_help) {
                startActivity(new Intent(getApplicationContext(), HelpActivity.class));
                finish();
                return true;
            }
            return false;
        });
    }

}