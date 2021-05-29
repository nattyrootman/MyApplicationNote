
package com.example.myapplicationnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

public class MainActivity extends AppCompatActivity implements FirebaseAuth.AuthStateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    private void setAuthentification(){


        startActivity(new Intent(this,LogingActivity.class));
        this.finish();

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth.getInstance().addAuthStateListener(this);


    }

    @Override
    protected void onStop() {
        super.onStop();


        FirebaseAuth.getInstance().removeAuthStateListener(this);
    }

    @Override
    public void onAuthStateChanged(FirebaseAuth firebaseAuth) {

        if (firebaseAuth.getCurrentUser()==null){

            setAuthentification();
            return;
        }

        firebaseAuth.getCurrentUser().getIdToken(true)
                .addOnSuccessListener(new OnSuccessListener<GetTokenResult>() {
                    @Override
                    public void onSuccess(GetTokenResult getTokenResult) {

                        Toast.makeText(getApplicationContext(),"successfull",Toast.LENGTH_LONG).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure( Exception e) {

                Toast.makeText(getApplicationContext(),"successfull",Toast.LENGTH_LONG).show();


            }
        });

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);

        // SHA1: B1:CE:CF:EE:0D:83:65:82:4B:FA:CF:7E:62:A5:91:CA:4E:28:9C:D2

        return super.onCreateOptionsMenu(menu);



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){


            case R.id.profile:

                startActivity(new Intent(this,ProfileActitvity.class));

                return true;
            case R.id.logout:



                startActivity(new Intent(this,LogingActivity.class));

                return true;

            case R.id.setting:

                return true;





        }

        return super.onOptionsItemSelected(item);
    }


}
