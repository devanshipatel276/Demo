package com.example.devanshi.retrofitdemo.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.devanshi.retrofitdemo.HomePageActivity;
import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.db_handler.DataBaseHandler;
import com.example.devanshi.retrofitdemo.model.User;
import com.example.devanshi.retrofitdemo.util.Mypref;

import static android.app.Activity.RESULT_OK;


import static com.example.devanshi.retrofitdemo.util.Mypref.Email;
import static com.example.devanshi.retrofitdemo.util.Mypref.Id;
import static com.example.devanshi.retrofitdemo.util.Mypref.Name;
import static com.example.devanshi.retrofitdemo.util.Mypref.Password;
import static com.example.devanshi.retrofitdemo.util.Mypref.Phone;
import static com.example.devanshi.retrofitdemo.util.Mypref.Photo;


public class UpdateFragment extends Fragment
{
     private EditText name,email,phone,password;
   private Button update;
  private   ImageView image;
   private String picpath;
    private User user;
   private Mypref mypref =new Mypref();
   private static String TAG="UpdateFragement";
    private DataBaseHandler db=new DataBaseHandler(getActivity());

    public UpdateFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         user=new User();
        if (getArguments() != null) {

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(), "Clciked!..", Toast.LENGTH_SHORT).show();
                    user.name=name.getText().toString();
                    user.email=email.getText().toString();
                    user.phone=phone.getText().toString();
                    user.password=password.getText().toString();
                    user._img=picpath;
                    db.updateUser(user);
                }
            });


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update, container, false);
        name=view.findViewById(R.id.update_name);
        email=view.findViewById(R.id.update_email);
        phone=view.findViewById(R.id.update_phone);
        update=view.findViewById(R.id.btn_Update);
        password=view.findViewById(R.id.update_password);
        image=view.findViewById(R.id.update_image);

        return view;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        mypref.SharedPreferenceUtils(getActivity());
        name.setText(mypref.getStringValue(Name,""));
        //SharedPreferences[] sharedpreferences ={getActivity().getSharedPreferences(mypreference, Context.MODE_PRIVATE)};

        email.setText(mypref.getStringValue(Email,""));
        phone.setText(mypref.getStringValue(Phone,""));
        password.setText(mypref.getStringValue(Password,""));
        image.setImageURI(Uri.parse(mypref.getStringValue(Photo,"")));
        String value = mypref.getStringValue(Photo,"");
        mypref.Glide(value,getContext(),image);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Update...", Toast.LENGTH_SHORT).show();


                DataBaseHandler db = new DataBaseHandler(getActivity());
                user = new User();
                user.name = name.getText().toString();
                user.email = email.getText().toString();
                user.phone = phone.getText().toString();
                user.password = password.getText().toString();
                user._img = picpath;

                user.id = mypref.getStringValue(Id, "");

                mypref.clear();
                mypref.setValue(Photo,user.get_img());
                mypref.setValue(Name,user.getName());
                mypref.setValue(Email,user.getEmail());
                mypref.setValue(Password, user.getPassword());
                mypref.setValue(Phone, user.getPhone());
                db.updateUser(user);

                Intent i=new Intent(getContext(), HomePageActivity.class);
                startActivity(i);
            }


        });
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {
            if (requestCode == 100)
            {
                Uri selectedImage = data.getData();
                String[] filePath = {MediaStore.Images.Media.DATA};
                Context applicationContext = getContext();
                Cursor c = applicationContext.getContentResolver().query(selectedImage, filePath, null, null, null);
                c.moveToFirst();
                int columnIndex = c.getColumnIndex(filePath[0]);
                String picturePath = c.getString(columnIndex);
                c.close();
                Bitmap thumbnail = (BitmapFactory.decodeFile(picturePath));
                picpath = picturePath;
                Log.d(TAG,"Imagepath" +picpath);
                mypref.Glide(picpath,getContext(),image);
                image.setImageBitmap(thumbnail);
            }
        }
    }

}









