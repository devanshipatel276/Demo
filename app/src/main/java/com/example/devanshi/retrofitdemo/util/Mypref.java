package com.example.devanshi.retrofitdemo.util;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.support.v4.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.devanshi.retrofitdemo.R;
import com.example.devanshi.retrofitdemo.fragment.HomeFragment;


/**
 * Created by Devanshi on 13-03-2018.
 */

public class Mypref extends AppCompatActivity {
    protected Context mContext;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mSharedPreferencesEditor;

    public static final String mypreference = "mypref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";
    public static final String Phone = "PhoneKey";
    public static final String Password = "passwordKey";
    public static final String Photo = "photoKey";
    public static final String Id = "idKey";


//    final SharedPreferences[] sharedpreferences = {getSharedPreferences(mypreference,Context.MODE_PRIVATE)};
//    sharedpreferences[0] =  getSharedPreferences(mypreference, Context.MODE_PRIVATE);
//


    public void SharedPreferenceUtils(Context context) {
        mContext = context;
        mSharedPreferences = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        mSharedPreferencesEditor = mSharedPreferences.edit();
    }

//    public void SharedPreferenceUtils getInstance(Context context) {
//
//        if (mSharedPreferenceUtils == null) {
//            mSharedPreferenceUtils = new SharedPreferenceUtils(context.getApplicationContext());
//        }
//        return mSharedPreferenceUtils;
//    }

    public void setValue(String key, String value) {
        mSharedPreferencesEditor.putString(key, value);
        mSharedPreferencesEditor.commit();
    }

    public String getStringValue(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    public void clear() {
        mSharedPreferencesEditor.clear().commit();
    }

    // String value = sharedpreferences[0].getString(Photo, "");

    public void Glide(String value, final Context context, final ImageView image) {
        Glide.with(context).load(value).asBitmap().into(new BitmapImageViewTarget(image) {
            protected void setResource(Bitmap resource) {

                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                image.setImageDrawable(circularBitmapDrawable);
            }

        });
    }


}






