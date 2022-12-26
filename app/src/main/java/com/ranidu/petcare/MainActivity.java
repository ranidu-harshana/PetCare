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

public class MainActivity extends AppCompatActivity {
    TextView tv_signup, tv_forget_pass;
    EditText et_username, et_password;
    RelativeLayout btn_login;

    private String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private String MobilePattern = "^\\+[0-9]{10,13}$";
    private String PasswordPattern = "[a-zA-Z0-9\\\\!\\\\@\\\\#\\\\$]{8,24}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_signup = findViewById(R.id.tv_signup);
        tv_forget_pass = findViewById(R.id.tv_forget_pass);
        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        btn_login = findViewById(R.id.btn_login);

        String text = "<font>Don't have an account?</font><font weight=bold> SIGNUP</font>";
        tv_signup.setText(Html.fromHtml(text));

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateFields();
            }
        });

        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        tv_forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    private void validateFields() {
        String username, password;
        username = et_username.getText().toString();
        password = et_password.getText().toString();

        if(!(username.isEmpty())) {
            if(!(password.isEmpty())) {
                if(username.matches(EmailPattern)) {
                    if(password.matches(PasswordPattern)) {
                        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
                        loginUser();

                    }else{
                        et_password.setError("Password must be include simple, capital and special character and must be between 8-24 characters");
                    }
                }else{
                    et_username.setError("Enter a valid email address");
                }
            }else{
                et_password.setError("Please fill this field");
            }
        }else{
            et_username.setError("Please fill this field");
        }
    }
}