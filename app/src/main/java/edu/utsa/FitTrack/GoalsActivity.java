package edu.utsa.FitTrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GoalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_goals);

        TextView textView = findViewById(R.id.textView2);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        });

        Button setGoal = findViewById(R.id.setGoalBtn);
        setGoal.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), NewGoalActivity.class);
            startActivity(intent);
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_goals);
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