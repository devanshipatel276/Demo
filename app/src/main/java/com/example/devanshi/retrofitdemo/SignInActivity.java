package com.example.devanshi.retrofitdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.devanshi.retrofitdemo.db_handler.DataBaseHandler;
import com.example.devanshi.retrofitdemo.model.User;
import com.example.devanshi.retrofitdemo.util.Mypref;

import java.util.List;

import static com.example.devanshi.retrofitdemo.util.Mypref.Email;
import static com.example.devanshi.retrofitdemo.util.Mypref.Id;
import static com.example.devanshi.retrofitdemo.util.Mypref.Name;
import static com.example.devanshi.retrofitdemo.util.Mypref.Password;
import static com.example.devanshi.retrofitdemo.util.Mypref.Phone;
import static com.example.devanshi.retrofitdemo.util.Mypref.Photo;

public class SignInActivity extends AppCompatActivity
{
//    public static final String mypreference = "mypref";
//    public static final String Name = "nameKey";
//    public static final String Email = "emailKey";
//    public static final String Phone = "PhoneKey";
//    public static final String Password = "passwordKey";
//    public static final String Photo = "photoKey";
//    public static final String Id = "idKey";
    private EditText email,password;
    Mypref mypref=new Mypref();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        email=findViewById(R.id.etSignIn_name);
        password=findViewById(R.id.etSignIn_password);


        mypref.SharedPreferenceUtils(SignInActivity.this);
       String validate = mypref.getStringValue(Id,"");

        if(!validate.equals(""))
        {
            Intent i=new Intent(SignInActivity.this,HomePageActivity.class);
            startActivity(i);
            finish();
        }

        Button btnSignUp=findViewById(R.id.signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(i);
            }
        });

        Button btnSignIn=findViewById(R.id.signin);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String e = email.getText().toString();
                String p = password.getText().toString();

                DataBaseHandler db=new DataBaseHandler(SignInActivity.this);
                List<User> contacts = db.getAllUser();

                for(User un:contacts)
                {
                   if(un.getEmail().equals(e) && un.getPassword().equals(p))
                    {
                        mypref.SharedPreferenceUtils(SignInActivity.this);
                        mypref.setValue(Name,un.getName());
                        mypref.setValue(Email,un.getEmail());
                        mypref.setValue(Phone,un.getPhone());
                        mypref.setValue(Photo,un.get_img());
                        mypref.setValue(Id,un.getId());
                        mypref.setValue(Password,un.getPassword());
                        mypref.SharedPreferenceUtils(SignInActivity.this);

                        Intent i=new Intent(SignInActivity.this,HomePageActivity.class);
                        startActivity(i);
                    }

                }


            }
        });

    }
}
