package edu.utsa.lab3;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ProfileActivity extends AppCompatActivity {

    private Account profileInfo =null;
    //private AssetManager assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        //assets = getAssets();
        setupProfile();
        //setProfile2();

    }

    public void setupProfile(){
        Intent intent = getIntent();
        int id = intent.getIntExtra("id",-1);

        //profileInfo = new Account(id,assets);

        File f = new File(getFilesDir().getAbsolutePath()+"/accounts.txt");
        Scanner scan;
        String str = "";
        String[] arr = null;

        try{
            if(f.exists()) {
                scan = new Scanner(openFileInput("accounts.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (Integer.parseInt(arr[0]) == id) {
                        profileInfo = new Account(id, arr[1], arr[2]);
                        break;
                    }

                }
                scan.close();
            }
        }
        catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }

        if(profileInfo != null) {
            TextView fullName = (TextView) findViewById(R.id.full_name);
            TextView email = (TextView) findViewById(R.id.email);
            fullName.setText(profileInfo.getFullName());
            email.setText(profileInfo.getEmail());
        }
    }

    private void setProfile2(){
        Intent intent = getIntent();
        //1:43:22
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            profileInfo = intent.getParcelableExtra("account",Account.class);
        }
        TextView fullName = (TextView) findViewById(R.id.full_name);
        TextView email = (TextView) findViewById(R.id.email);
        fullName.setText(profileInfo.getFullName());
        email.setText(profileInfo.getEmail());


    }
}