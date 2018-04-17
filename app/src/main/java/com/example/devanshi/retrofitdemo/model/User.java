package com.example.devanshi.retrofitdemo.model;

/**
 * Created by Devanshi on 06-03-2018.
 */

public class User
{
    public String name;
    public String email;
     public String id;

     public String password;
  public String _img;
    public String phone;

    public User(String name, String email, String password, String phone, String gender, String photo)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.gender=gender;
        this._img=photo;
    }

    public User() {

    }

    public String get_img() {
        return _img;
    }

    public void set_img(String _img) {
        this._img = _img;
    }



    public User(String name, String email, String password, String phone)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;

    public User(String name, String email, String password, String phone,String gender)
    {
        this.name=name;
        this.email=email;
        this.password=password;
        this.phone=phone;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
