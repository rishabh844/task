package com.example.demoUi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaos.view.PinView;

import java.util.Objects;

public class OtpVerification extends AppCompatActivity {
   PinView pinview;
    Button btn_verify;
    String combineOtp;
    String compareOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        pinview=findViewById(R.id.pinview);
        btn_verify=findViewById(R.id.btn_verify);

         combineOtp= getIntent().getStringExtra("combineOtp");
         btn_verify.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 compareOtp=pinview.getText().toString();
                 if (Objects.equals(combineOtp, compareOtp))
                 {
                     Intent intent=new Intent(OtpVerification.this,EditProfileActivity.class);
                     startActivity(intent);
                 }else
                 {
                     Toast.makeText(OtpVerification.this, "Please Enter Correct OTP", Toast.LENGTH_SHORT).show();
                 }
             }
         });


    }
}