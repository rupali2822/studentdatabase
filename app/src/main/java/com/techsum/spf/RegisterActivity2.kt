package com.techsum.spf

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register2.*
import kotlinx.android.synthetic.main.activity_register2.et_password

class RegisterActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register2)

        //sharepreference for ligin
        var spf=getSharedPreferences("spf_sept3",Context.MODE_PRIVATE)

        var spf_edit:SharedPreferences.Editor=spf.edit()

        btn_register.setOnClickListener{
        var username=et_name.text.toString()
            var password=et_password.text.toString()

            spf_edit.putString("uname",username)
            spf_edit.putString("pass",password)

            if(username.isEmpty()){
                et_name.error="Username required"
                return@setOnClickListener
            }else if(password.isEmpty()){
                et_password.error="password required"
                return@setOnClickListener
            }else {

            }

         if(spf_edit.commit()){
             Toast.makeText(this, "Data register successfully.", Toast.LENGTH_SHORT).show()
             startActivity(Intent(this,MainActivity::class.java))
         }else{
             Toast.makeText(this, "Failed to register", Toast.LENGTH_SHORT).show()
         }
            //validations


        }





    }
}