package edu.utsa.FitTrack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.ComponentActivity;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class RegisterActivity extends ComponentActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        //Toast.makeText(this,"Hello World",Toast.LENGTH_SHORT).show();
        setupButton();

    }

    private void setupButton(){
        Button signupBtn = (Button) findViewById(R.id.signIN);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                int id = -1;
                EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
                EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
                EditText emailInput = (EditText) findViewById(R.id.emailInput);
                EditText nameInput = (EditText) findViewById(R.id.fullnameInput);

                if(validateAccountInfo()){
                    id = createLogin();
                    if(id>0){
                        createAccount(id);
                    }
                    finish();
                }
                else{
                    usernameInput.setText("");
                    passwordInput.setText("");
                    emailInput.setText("");
                    nameInput.setText("");
                    usernameInput.setError("All fields must be filled out.");
                    passwordInput.setError("All fields must be filled out.");
                    emailInput.setError("All fields must be filled out.");
                    nameInput.setError("All fields must be filled out.");

                }
            }
        });
    }

    private boolean validateAccountInfo(){
        EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
        EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
        EditText emailInput = (EditText) findViewById(R.id.emailInput);
        EditText nameInput = (EditText) findViewById(R.id.fullnameInput);

        if(!usernameInput.getText().toString().equals("") && !passwordInput.getText().toString().equals("") &&
                !emailInput.getText().toString().equals("") && !nameInput.getText().toString().equals("")){
            return true;
        }
        return false;
    }

    private int createLogin(){
        EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
        EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
        String username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        File f = new File(getFilesDir().getAbsolutePath()+"/login.txt");
        OutputStreamWriter w = null;
        Scanner scan;
        int id = -1;
        String str = null;
        String[] arr;
        if(!f.exists()){
            id = 1;
            try{
                w =new OutputStreamWriter(openFileOutput("login.txt",MODE_PRIVATE));
                w.write(id+","+username+","+password);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(), "IOException"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

        else{
            try {
                scan = new Scanner(openFileInput("login.txt"));
                while (scan.hasNextLine()) {
                    str = scan.nextLine();
                }
                if(str != null){
                    arr = str.split(",");
                    if(arr.length == 3){
                        id = Integer.parseInt(arr[0]) + 1;
                    }
                }
                scan.close();

                w =new OutputStreamWriter(openFileOutput("login.txt",MODE_APPEND));
                w.append("\n"+id+","+username+","+password);
                w.close();
            }
            catch(IOException e){
                Toast.makeText(getBaseContext(), "IOException"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        return id;
    }

    private void createAccount(int id){
        EditText nameInput = (EditText) findViewById(R.id.fullnameInput);
        EditText emailInput = (EditText) findViewById(R.id.emailInput);
        String name = nameInput.getText().toString();
        String email = emailInput.getText().toString();

        File f = new File(getFilesDir().getAbsolutePath()+"/accounts.txt");
        OutputStreamWriter w = null;

        if(!f.exists()){
            try{
                w =new OutputStreamWriter(openFileOutput("accounts.txt",MODE_PRIVATE));
                w.write(id+","+name+","+email);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(), "IOException"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
        else{
            try {
                w = new OutputStreamWriter(openFileOutput("accounts.txt", MODE_APPEND));
                w.append("\n" + id + "," + name + "," + email);
                w.close();
            }
            catch (IOException e){
                Toast.makeText(getBaseContext(), "IOException"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    }
}
