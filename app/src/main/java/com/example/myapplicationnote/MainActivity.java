
package com.example.myapplicationnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
