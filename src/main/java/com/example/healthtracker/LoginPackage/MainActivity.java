package com.example.healthtracker.LoginPackage;

import androidx.appcompat.app.AppCompatActivity;
import com.example.healthtracker.DbClasses.LoginModule;
import com.example.healthtracker.DbClasses.RegistrationModule;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthtracker.R;

public class MainActivity extends AppCompatActivity {

    private EditText loginId = null;
    private EditText password = null;
    private Button   login =  null;
    private TextView   register = null;
    private LoginModule loginHandle = null;
    private boolean switchMode = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setInitialParams();
        login();
    }
    public void setInitialParams(){
        loginId = (EditText)findViewById(R.id.editEmail);
        password = (EditText)findViewById(R.id.editPassword);
        login = (Button)findViewById(R.id.buttonLogin);
        register = (TextView)findViewById(R.id.buttonRegister);
    }
    /*
        Login Module = On click login validate login Id and password
            Validate from the database the details
            if alright move to dashboard
            else throw error
     */
    public void login(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (LoginUtility.validatePhoneNumber(loginId.toString()) && LoginUtility.validatePassword(password.toString())) {
                    loginHandle = new LoginModule();
                    if (loginHandle.giveLoginStatus(loginId.toString(), password.toString())) {
                        Log.d("Success", "True Login");
                        //redirect to dashboard activity
                    } else {
                        Log.d("Failure", "False Login");
                    }
                } else {
                    Log.d("Validation Failure", "Email or Password or Phone number validation failure");
                    Toast.makeText(getApplicationContext(), "Please Register", Toast.LENGTH_LONG);
                }
            }
        });
    }
    /*******************************************************************************************
     *  on click move it to registration activity
     *******************************************************************************************/
    public void registerMethod(View view){
        Intent menuIntent = new Intent(getApplicationContext(), RegActivity.class);
        startActivity(menuIntent);
    }
}