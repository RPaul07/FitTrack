package edu.utsa.lab3;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_help);

        TextView textView = findViewById(R.id.textView2);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        });

        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setSelectedItemId(R.id.navigation_help);
        navView.setItemIconTintList(ColorStateList.valueOf(ContextCompat.getColor(this, android.R.color.white))); // Removes icon tint
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
                return true;
            }
            return false;
        });
    }
}