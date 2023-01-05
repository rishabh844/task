package com.example.demoUi;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class LoginActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    String mobileNumber = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText = findViewById(R.id.ed_MobileNumber);
        button = findViewById(R.id.btn_sendotp);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckValidation();
            }
        });

    }


    private void CheckValidation() {
        if (!editText.getText().toString().isEmpty() && editText.getText().toString().length() == 10) {
            mobileNumber = editText.getText().toString();


            int firstDigit = Integer.parseInt(mobileNumber.substring(0, 2));
            int lastDigit = Integer.parseInt(mobileNumber.substring(mobileNumber.length() - 2));
            int combineNumber = Integer.parseInt(String.valueOf(firstDigit) + String.valueOf(lastDigit));
            String combineOtp = String.valueOf(combineNumber);

            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
            TextView tv = (TextView) layout.findViewById(R.id.txtvw);
            tv.setText(combineOtp);
            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

            Intent intent = new Intent(LoginActivity.this, OtpVerification.class);
            intent.putExtra("combineOtp",combineOtp);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Please enter 10 digit Mobile No", Toast.LENGTH_SHORT).show();


        }
        }
    }
