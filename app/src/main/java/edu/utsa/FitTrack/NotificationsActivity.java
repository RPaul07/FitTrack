package edu.utsa.FitTrack;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notifications);

        TextView textView = findViewById(R.id.textView2);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_notifications);
        navView.setItemIconTintList(null); // Removes icon tint
        navView.setItemTextColor(null);
        navView.setOnItemSelectedListener(item ->  {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_notifications) {
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