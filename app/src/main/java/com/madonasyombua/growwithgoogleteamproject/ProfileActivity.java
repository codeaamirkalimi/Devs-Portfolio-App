package com.madonasyombua.growwithgoogleteamproject;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.madonasyombua.growwithgoogleteamproject.ui.fragment.ProfileFragment;

public class ProfileActivity extends AppCompatActivity implements ProfileFragment.OnFragmentInteractionListener{
//to started once the email and password authentication goes through.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.container,new ProfileFragment());
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
