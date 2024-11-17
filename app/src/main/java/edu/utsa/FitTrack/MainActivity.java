package edu.utsa.FitTrack;

import androidx.activity.ComponentActivity;
import androidx.activity.EdgeToEdge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*Each activity is like each page for the user. And each activity has a life cycle.*/
// make sure to pick androidx.activity for ComponentActivity
public class MainActivity extends ComponentActivity {


    //EditText usernameInput;
    //EditText passwordInput;
    //private Button loginBtn;
    //private AssetManager assets;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //assets = getAssets();
        Toast.makeText(this,"Hello World",Toast.LENGTH_SHORT).show();
        setupButton();

    }

    private void setupButton(){
        Button loginBtn = (Button) findViewById(R.id.LoginBtn);
        //Button signupBtn = (Button) findViewById(R.id.signup_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                EditText uText = (EditText) findViewById(R.id.usernameInput);
                EditText uPass = (EditText) findViewById(R.id.passwordInput);
                int id = authentication(uText.getText().toString(),uPass.getText().toString());
                //Account account = authentication(uText.getText().toString(),uPass.getText().toString());
                if(id>0){
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    intent.putExtra("id",id);
                    startActivity(intent);
                }
                else{
                    uText.setText("");
                    uPass.setText("");
                    uText.setError("Incorrect username or password.");
                    uPass.setError("Incorrect username or password.");
                }
            }
        });
        /*
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
         */
    }

    private int authentication(String username, String password){
        Scanner scan;
        String str = "";
        String[] arr = null;
        boolean authenticated = false;
        int id = -1;
        File f = new File(getFilesDir().getAbsolutePath()+"/login.txt");
        try{
            if(f.exists()) {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (username.equalsIgnoreCase(arr[1]) && password.equals(arr[2])) {
                        //authenticated = true;
                        id = Integer.parseInt(arr[0]);
                        break;
                    }

                }
                scan.close();
            }
        }
        catch (IOException e){
            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT);
            //System.out.println("Error: "+ e.getMessage());
        }


        return id;
    }

    //trying to move objects from one activity to another
    /*private Account authentication(String username, String password){
        Scanner scan;
        String str = "";
        String[] arr = null;
        boolean authenticated = false;
        int id = -1;
        Account account;
        File f = new File(getFilesDir().getAbsolutePath()+"/login.txt");
        try{
            if(f.exists()) {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNext()) {
                    str = scan.nextLine();
                    arr = str.split(",");
                    if (username.equalsIgnoreCase(arr[1]) && password.equals(arr[2])) {
                        authenticated = true;
                        id = Integer.parseInt(arr[0]);
                        break;
                    }

                }
                scan.close();
            }
        }
        catch (IOException e){
            Toast.makeText(this,"Error: "+e.getMessage(),Toast.LENGTH_SHORT);
            //System.out.println("Error: "+ e.getMessage());
        }

        if(id>0){
            try{
                scan = new Scanner(assets.open("accounts.txt"));
                while(scan.hasNext()){
                    str = scan.nextLine();
                    arr = str.split(",");
                    if(Integer.parseInt(arr[0]) == id){
                        account = new Account(id,arr[1],arr[2]);
                        return account;
                    }

                }
                scan.close();
            }
            catch (IOException e){
                System.out.println("Error: "+ e.getMessage());
            }
        }



        return null;
    }*/
}
