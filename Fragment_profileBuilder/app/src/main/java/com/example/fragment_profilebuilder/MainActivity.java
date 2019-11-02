package com.example.fragment_profilebuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener, AvatarFragment.returnImage, DisplayFragment.OnFragmentInteractionListener{
    static SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         sharedPref = this.getPreferences(Context.MODE_PRIVATE);


        if(sharedPref.contains("profilebuild")){
             getSupportFragmentManager().beginTransaction()
                     .add(R.id.container,new DisplayFragment(), "display_fragment")
                     .commit();
         }
         else {

             getSupportFragmentManager().beginTransaction()
                     .add(R.id.container, new ProfileFragment(), "profile_porifle")
                    .commit();

         }
    }



    @Override
    public void gotoNext() {
                        getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new AvatarFragment(), "avatar_fragment" )
                        .commit();
    }

    @Override
    public void addProfile(Profile profile) {
        SharedPreferences.Editor prefsEditor = sharedPref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(profile);
        prefsEditor.putString("profilebuild",json);
        prefsEditor.commit();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,new DisplayFragment())
                .commit();

    }


    @Override
    public void getImage(int tagid) {

        sharedPref.edit().putInt("tagid",tagid).commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ProfileFragment())
                .commit();



    }


    @Override
    public void editFunctioncall() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ProfileFragment(), "profile_fragment")
                .commit();
    }
}
