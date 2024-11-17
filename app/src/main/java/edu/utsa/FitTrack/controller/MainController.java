package edu.utsa.FitTrack.controller;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import edu.utsa.FitTrack.MainActivity;
import edu.utsa.FitTrack.ProfileActivity;
import edu.utsa.FitTrack.R;

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
        if(idOfButtonPressed == R.id.LoginBtn){
            Intent intent = new Intent(mainActivity, ProfileActivity.class);
            mainActivity.startActivity(intent);
            return;
        }
            //    Log.i("Test Credentials", "Username : " + username + " and Password : " + password);


    }
}
