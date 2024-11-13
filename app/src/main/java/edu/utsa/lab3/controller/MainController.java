package edu.utsa.lab3.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import edu.utsa.lab3.MainActivity;
import edu.utsa.lab3.ProfileActivity;
import edu.utsa.lab3.R;

public class MainController implements View.OnClickListener{

    public MainController(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    MainActivity mainActivity;

   // private static

    @Override
    public void onClick(View v) {

        int idOfButtonPressed = v.getId();
        Context context = v.getContext();

//        String username = usernameInput.getText().toString();
//        String password = passwordInput.getText().toString();
        if(idOfButtonPressed == R.id.login_btn){
            Intent intent = new Intent(mainActivity, ProfileActivity.class);
            mainActivity.startActivity(intent);
            return;
        }
            //    Log.i("Test Credentials", "Username : " + username + " and Password : " + password);


    }
}
