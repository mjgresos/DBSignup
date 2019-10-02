package com.gresos.dbsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUser, etPass;
    String username, password;
    int formsuccess = 0;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login =(Button)findViewById(R.id.btnLogin);
        TextView reg = (TextView)findViewById(R.id.btnRegister);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);


        reg.setFocusable(false);
        reg.setClickable(true);
        reg.setInputType(InputType.TYPE_NULL);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, SignupActivity.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username = etUser.getText().toString();
                password = etPass.getText().toString();

                formsuccess = 2;

                // validate username
                if(username.equals("")) {
                    etUser.setError("This field is required");
                    formsuccess--;
                }

                // validate password
                if(password.equals("")) {
                    etPass.setError("This field is required");
                    formsuccess--;
                }

                if(formsuccess == 2) {
                    Toast.makeText(MainActivity.this, "Form Successfully Validated", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

}
