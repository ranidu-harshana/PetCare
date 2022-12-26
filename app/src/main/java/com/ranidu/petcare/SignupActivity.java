package com.ranidu.petcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    TextView tv_login;
    EditText et_username, et_password, et_cpassword;
    RelativeLayout btn_signup;

    private String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String MobilePattern = "^\\+[0-9]{10,13}$";
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        tv_login = findViewById(R.id.tv_login);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        et_cpassword = findViewById(R.id.et_cpassword);
        btn_signup = findViewById(R.id.btn_signup);

        String text = "<font>Already have an account?</font><font weight=bold> LOGIN</font>";
        tv_login.setText(Html.fromHtml(text));

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });
    }

    private void validateFields() {
        String username, password, confirm_password;

        username = et_username.getText().toString();
        password = et_password.getText().toString();
        confirm_password = et_cpassword.getText().toString();

        if(!(username.isEmpty())) {
            if(!(password.isEmpty())) {
                if(!(confirm_password.isEmpty())) {
                    if (username.matches(EmailPattern)) {
                        if (password.matches(PasswordPattern)) {
                            if(password.equals(confirm_password)) {
                                Toast.makeText(SignupActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignupActivity.this, MainActivity2.class);
                                startActivity(intent);
                            }else{
                                et_cpassword.setError("Passwords are not match");
                            }
                        } else {
                            et_password.setError("Password must be include simple, capital and special character and must be between 8-24 characters");
                        }
                    } else {
                        et_username.setError("Enter a valid email address");
                    }
                }else{
                    et_cpassword.setError("Please fill this field");
                }
            }else{
                et_password.setError("Please fill this field");
            }
        }else{
            et_username.setError("Please fill this field");
        }
    }
}