package com.ranidu.petcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ForgetPasswordActivity extends AppCompatActivity {

    TextView et_mob_number;
    RelativeLayout btn_send_otp;
    private String MobilePattern = "^\\+[0-9]{10,13}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        et_mob_number = findViewById(R.id.et_mob_number);
        btn_send_otp = findViewById(R.id.btn_send_otp);

        btn_send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
    }

    private void validateFields() {
        String mob_number;
        mob_number = et_mob_number.getText().toString();

        if(!(mob_number.isEmpty())) {
            if(mob_number.matches(MobilePattern)) {
                Toast.makeText(ForgetPasswordActivity.this, "You will get a code", Toast.LENGTH_SHORT).show();
            }else{
                et_mob_number.setError("Enter a valid mobile number. (Ex: +94776006495)");
            }
        }else{
            et_mob_number.setError("Please fill this field");
        }
    }
}