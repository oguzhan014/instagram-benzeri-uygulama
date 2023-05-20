package com.oguzhann.loginanime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {




    BottomNavigationView bottomNavim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");






        bottomNavim=findViewById(R.id.bnavim);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new Homefrag()).commit();

      bottomNavim.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              switch (item.getItemId()){
                  case R.id.Home:
                      getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new Homefrag()).commit();
                      break;
                  case R.id.Search:
                      getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new Searchfrag()).commit();
                      break;
                  case R.id.person:
                      getSupportFragmentManager().beginTransaction().replace(R.id.fragmentler,new Personfrag()).commit();
                      break;
              }
              return true;
          }
      });

    }
    @Override
    public void onBackPressed() {
        Intent geriintent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(geriintent);

    }
}
