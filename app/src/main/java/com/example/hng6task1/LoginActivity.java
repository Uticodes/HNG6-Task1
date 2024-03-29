package com.example.hng6task1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etName.getText().toString();
                String password = etPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);

                //String savedPassword = preferences.getString(password, "");
                //String savedUserName = preferences.getString(user, "");

                String userDetails = preferences.getString(user + password + "data","No information on that user. \n Kindly Register to store your information");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();

                Intent displayScreen = new Intent(LoginActivity.this, DisplayActivity.class);
                startActivity(displayScreen);
            }
        });
    }
}
