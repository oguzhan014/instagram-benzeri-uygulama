package com.oguzhann.loginanime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView t1;

    ImageView image1 ;

    RelativeLayout r1;

    Button btn , btnkyt;

    EditText kAdi,kSifre,eMail;
    private String adi , email,sifre;
    private FirebaseAuth mAuth;
    private DatabaseReference mRef;
    private FirebaseUser mUser;
    private HashMap<String,Object> mData;
    Intent intent;

    public class User {
        private String username;
        private String email;
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User();
        user.setUsername(adi);
        user.setEmail(email);
        user.setPassword(sifre);

        image1 = findViewById(R.id.image1);
        r1 =findViewById(R.id.panelim);
        t1 =findViewById(R.id.t1);
        btn = findViewById(R.id.btngir);
        btnkyt = findViewById(R.id.btnkayit);

        kAdi= findViewById(R.id.personname);
        kSifre = findViewById(R.id.key);
        eMail =findViewById(R.id.emailbutton);
        mAuth=FirebaseAuth.getInstance();
        mRef= FirebaseDatabase.getInstance().getReference();



        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo);
        Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.panelanim);

        image1.startAnimation(anim1);
        r1.startAnimation(anim2);
        t1.startAnimation(anim2);
      btnkyt.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              adi=kAdi.getText().toString();
              email=eMail.getText().toString();
              sifre=kSifre.getText().toString();

              if(!TextUtils.isEmpty(adi)&& ! TextUtils.isEmpty(email)&&!TextUtils.isEmpty(sifre)){
                  mAuth.createUserWithEmailAndPassword(email,sifre)
                          .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  Toast.makeText(MainActivity.this, "veri tabanına kaydınız yapıldı", Toast.LENGTH_SHORT).show();
                              }
                          });
              }

          }
      });
      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              adi = kAdi.getText().toString();
              email = eMail.getText().toString();
              sifre = kSifre.getText().toString();
              if (!TextUtils.isEmpty(adi) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(sifre)) {
                  mAuth.signInWithEmailAndPassword(email,sifre)
                          .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  mUser=mAuth.getCurrentUser();
                                  mData=new HashMap<>();
                                  mData.put("kullanıcı adı :",adi);
                                  mData.put("kullanıcı E-mail :",email);
                                  mData.put("kullanıcı şifresi: ",sifre);
                                  mData.put("kullanıcı ID : ",mUser.getUid());
                                  mRef.child("Kullanıcılar").child(mUser.getUid())
                                                  .setValue(mData)
                                                          .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                              @Override
                                                              public void onComplete(@NonNull Task<Void> task) {
                                                                  Toast.makeText(MainActivity.this, "Realtime veri tabanına kaydedildi", Toast.LENGTH_SHORT).show();
                                                              }
                                                          });
                                  Toast.makeText(MainActivity.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                                  intent=new Intent(MainActivity.this,MainActivity2.class);
                                  intent.putExtra("username", adi);
                                  intent.putExtra("email", email);
                                  intent.putExtra("password", sifre);
                                  startActivity(intent);

                              }
                          });

              }
          }
      });



    }
}