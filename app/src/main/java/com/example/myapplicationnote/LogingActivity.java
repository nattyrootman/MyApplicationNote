package com.example.myapplicationnote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class LogingActivity extends AppCompatActivity {




   int result=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loging);


        if (FirebaseAuth.getInstance().getCurrentUser()!=null){

            startActivity(new Intent(this,MainActivity.class));
            this.finish();

        }




    }

    public void Connect(View view) {


        List<AuthUI.IdpConfig>list= Arrays.asList(

                new AuthUI.IdpConfig.EmailBuilder().build(),
                new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
        );

        Intent intent= AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(list)
                .setTosAndPrivacyPolicyUrls("www.amed.com","welcom")
                .setLogo(R.drawable.coran7).build();

        startActivityForResult(intent,result);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        if (requestCode==result){

            if (resultCode==RESULT_OK){

             FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

             if (user.getMetadata().getCreationTimestamp()==user.getMetadata().getLastSignInTimestamp()){

                 Toast.makeText(this,user.getEmail()+" welcom new user ",Toast.LENGTH_LONG).show();


             }else {
                 Toast.makeText(this, user.getEmail()+" welcom again ",Toast.LENGTH_LONG).show();


             }

                startActivity(new Intent(this,MainActivity.class));
                this.finish();



            }
            else {

                IdpResponse response=IdpResponse.fromResultIntent(data);

                if (response==null) {
                    Toast.makeText(getApplicationContext(), "User Cancels", Toast.LENGTH_LONG).show();


                }else {
                    Toast.makeText(getApplicationContext(), "fails to connect", Toast.LENGTH_LONG).show();

                }

            }
        }
    }
}