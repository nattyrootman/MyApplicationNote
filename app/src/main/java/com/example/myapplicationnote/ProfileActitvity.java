package com.example.myapplicationnote;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileActitvity extends AppCompatActivity {


    CircleImageView circleImageView;

    TextInputEditText inputEditText;
    Button profBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_actitvity);

         circleImageView=findViewById(R.id.Circleimage);
        inputEditText=findViewById(R.id.textInputLayout);
       profBtn=findViewById(R.id.UpdateProfile);



    }
}