package edu.utsa.lab3;

import android.content.res.AssetManager;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Account implements Parcelable {
    private int id;
    private String fullName;
    private String email;

    public Account(int id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    //not necessary for lab 5
    public Account(int id, AssetManager assets){
        this.id = id;
        setupFromFile(id,assets);
    }

    protected Account(Parcel in) {
        id = in.readInt();
        fullName = in.readString();
        email = in.readString();
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //not necessary for lab 5
    private void setupFromFile(int id, AssetManager assets){
        Scanner scan;
        String str = "";
        String[] arr = null;

        try{
            scan = new Scanner(assets.open(".txt"));
            while(scan.hasNext()){
                str = scan.nextLine();
                arr = str.split(",");
                if(Integer.parseInt(arr[0]) == id){
                    fullName = arr[1];
                    email = arr[2];
                    break;
                }

            }
            scan.close();
        }
        catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(fullName);
        dest.writeString(email);
    }

    private void readFromParcel(Parcel in){
        id = in.readInt();
        fullName = in.readString();
        email = in.readString();

    }
}
