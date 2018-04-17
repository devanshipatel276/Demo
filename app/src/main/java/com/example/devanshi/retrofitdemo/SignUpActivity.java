package com.example.devanshi.retrofitdemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.devanshi.retrofitdemo.db_handler.DataBaseHandler;
import com.example.devanshi.retrofitdemo.model.User;
import com.example.devanshi.retrofitdemo.util.Mypref;

public class SignUpActivity extends AppCompatActivity {
    private static final int SELECT_IMAGE = 58;
    private static final int SELECT_PICTURE = 100;
    EditText name, email, password, phone;
    Button register;
    RadioGroup radionbuttonGroup;
    RadioButton rb;
    String value;
    int selectedId;

    ImageView image;
    String picpath;
    TextInputLayout tName, tEmail, tPassword, tPhone, tGender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);



        name = findViewById(R.id.etSignUp_name);
        email = findViewById(R.id.etSignUp_email);
        password = findViewById(R.id.etSignUp_password);
        phone = findViewById(R.id.etSignUp_phone);
        register = findViewById(R.id.btn_register_SignUp);
        radionbuttonGroup = findViewById(R.id.radiobutton);
        image = findViewById(R.id.SignUp_image);


        tName = findViewById(R.id.text_input_name);
        tEmail = findViewById(R.id.text_input_email);
        tPassword = findViewById(R.id.text_input_password);
        tPhone = findViewById(R.id.text_input_phone);
        tGender = findViewById(R.id.text_input_gender);

        name.addTextChangedListener(new MyTextWatcher(name));
        email.addTextChangedListener(new MyTextWatcher(email));
        password.addTextChangedListener(new MyTextWatcher(password));

//         selectedId=radionbuttonGroup.getCheckedRadioButtonId();
//        rb=(RadioButton)findViewById(selectedId);
//        value=rb.getText().toString();

        final DataBaseHandler db = new DataBaseHandler(this);

        requestAccountPermission();

        radionbuttonGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                rb = group.findViewById(checkedId);

                value = rb.getText().toString();
                selectedId = checkedId;

            }
        });

        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                imagepicker();


//
             Toast.makeText(SignUpActivity.this, "Hey You Clicked!..", Toast.LENGTH_SHORT).show();
            }
        });
//


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                db.addUser(new User(name.getText().toString(), email.getText().toString(), password.getText().toString(), phone.getText().toString(), value,picpath));
                submitForm();
                Toast.makeText(SignUpActivity.this, "Done", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(i);
            }
        });

    }



    private void requestAccountPermission()
    {

        if (ContextCompat.checkSelfPermission(SignUpActivity.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(SignUpActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SignUpActivity.this,
                    new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    101);
        }

    }



    private void imagepicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, SELECT_PICTURE);
    }

               public void onActivityResult(int requestCode, int resultCode, Intent data)
               {
                   super.onActivityResult(requestCode, resultCode, data);
                   if (resultCode == RESULT_OK)
                   {
                       if (requestCode == SELECT_PICTURE)
                       {
                           Uri selectedImage = data.getData();
                           String[] filePath = {MediaStore.Images.Media.DATA};
                           Cursor c = getContentResolver().query(selectedImage, filePath, null, null, null);
                           c.moveToFirst();
                           int columnIndex = c.getColumnIndex(filePath[0]);
                           String picturePath = c.getString(columnIndex);
                           c.close();
                           Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                           Log.d("HEY","IMAGE path Filename:- " +picturePath);
                          picpath = picturePath;
                           Mypref mypref=new Mypref();

                            mypref.Glide(picpath,SignUpActivity.this,image);

                           image.setImageBitmap(thumbnail);
                       }
                   }
               }



    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults)
    {
        switch (requestCode)
        {
            case 101:
                {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {


                }
                else
                    {
                       // requestAccountPermission();


                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    private void submitForm()
    {
        if (!validateName())
        {
            return;
        }

        if (!validateEmail())
        {
            return;
        }

        if (!validatePassword())
        {
            return;
        }
        if (!validatePhone())
        {
            return;
        }
        if (!validateRadio())
        {
            return;
        }

        //Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();

    }

    private boolean validatePhone()
    {
        if (phone.getText().toString().isEmpty() || !isValidPhone(phone.getText().toString()))
        {
            tPhone.setError("Enter phone number");
            return false;
        } else
            {
            tPhone.setErrorEnabled(false);
        }
        return true;
    }

    private boolean isValidPhone(String phone)
    {
        return Patterns.PHONE.matcher(phone).matches();
    }

    private boolean validatePassword()
    {
        if (password.getText().toString().isEmpty())
        {
            tPassword.setError("Enter password number");
            return false;
        } else
            {
            tPassword.setErrorEnabled(false);
        }
        return true;
    }


    private boolean validateEmail()
    {
        String Email = email.getText().toString();

        if (Email.isEmpty() || !isValidEmail(Email))
        {
            tEmail.setError("Enter valid email address");
            return false;
        } else
            {
            tEmail.setErrorEnabled(false);
        }
        return true;
    }

    private boolean isValidEmail(String email)
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    private boolean validateName()
    {
        if (name.getText().toString().isEmpty())
        {
            tName.setError("Enter Your name");
            return false;
        } else
            {
            tName.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateRadio()
    {
        if (selectedId == 0)
        {
            tGender.setError("Select gender");
            return false;
        } else
            {
            tGender.setErrorEnabled(false);
        }
        return true;
    }

    private class MyTextWatcher implements TextWatcher
    {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.etSignUp_name:
                    validateName();
                    break;
                case R.id.etSignUp_email:
                    validateEmail();
                    break;
                case R.id.etSignUp_password:
                    validatePassword();
                    break;
                case R.id.etSignUp_phone:
                    validatePhone();
                    break;
                case R.id.radiobutton:
                    validateRadio();
                    break;
            }
        }
    }
}
