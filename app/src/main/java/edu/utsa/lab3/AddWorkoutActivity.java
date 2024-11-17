package edu.utsa.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class AddWorkoutActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private Button addRowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_workout);

        TextView textView = findViewById(R.id.textView2);
        textView.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
        });

        tableLayout = findViewById(R.id.tableLayout);
        addRowButton = findViewById(R.id.addRows);
        addRowButton.setOnClickListener(v -> addNewRow());

        Button addWorkout = findViewById(R.id.addExercise);
        addWorkout.setOnClickListener(v -> {
            EditText excersiseNameEditText = findViewById(R.id.excersiseName);
            String exerciseName = excersiseNameEditText.getText().toString();
            List<String> tableData = new ArrayList<>();
            for (int i = 0; i < tableLayout.getChildCount(); i++) {
                // Get the row
                TableRow row = (TableRow) tableLayout.getChildAt(i);
                // Assume there's a TextView in each row (or adjust for your table structure)
                TextView variable = (TextView) row.getChildAt(0); // Adjust index based on your table's layout
                tableData.add(variable.getText().toString());
            }

            finish();
            //Intent intent = new Intent(AddWorkoutActivity.this, NewWorkoutActivity.class);
            //intent.putStringArrayListExtra("exerciseTableData", new ArrayList<>(tableData));
            //intent.putExtra("exerciseName", exerciseName);
            //startActivity(intent);
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

    private void addNewRow() {
        // Create a new TableRow for the new row of data
        TableRow tableRow = new TableRow(this);

        EditText editSet = new EditText(this);
        editSet.setHint("Set #");
        editSet.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
        editSet.setMinWidth(100);  // Set the minimum width for square shape
        editSet.setMaxWidth(100);  // Set the maximum width for square shape
        editSet.setHeight(100);    // Make the height the same as the width for square shape
        editSet.setBackgroundResource(android.R.drawable.editbox_background); // Set background to border drawable
        editSet.setGravity(android.view.Gravity.CENTER); // Center text

        EditText editPounds = new EditText(this);
        editPounds.setHint("LBS");
        editPounds.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
        editPounds.setMinWidth(100);
        editPounds.setMaxWidth(100);
        editPounds.setHeight(100);
        editPounds.setBackgroundResource(android.R.drawable.editbox_background);
        editPounds.setGravity(android.view.Gravity.CENTER);

        EditText editReps = new EditText(this);
        editReps.setHint("Rep #");
        editReps.setLayoutParams(new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1));
        editReps.setMinWidth(100);
        editReps.setMaxWidth(100);
        editReps.setHeight(100);
        editReps.setBackgroundResource(android.R.drawable.editbox_background);
        editReps.setGravity(android.view.Gravity.CENTER);

        // Add the EditText fields to the TableRow
        tableRow.addView(editSet);
        tableRow.addView(editPounds);
        tableRow.addView(editReps);

        // Add the new TableRow to the TableLayout
        tableLayout.addView(tableRow);
    }
}