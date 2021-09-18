package com.techsum.spf

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_student2.*

class MainActivity : AppCompatActivity() {

    private fun validateForm(user: String, password: String): Boolean? {
     return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spf=getSharedPreferences("spf_sept3",Context.MODE_PRIVATE)

btn_sign_in.setOnClickListener{
    var username=et_username.text.toString()
    var password=et_password.text.toString()

    var un=spf.getString("uname","admin")
    var ps=spf.getString("pass","admin")

    Log.d("uname",un.toString());
    Log.d("pass",ps.toString());


    if(username.isEmpty()){
        et_username.error="Username required"
        return@setOnClickListener
    }else if(password.isEmpty()){
       et_password.error="password required"
        return@setOnClickListener
    }else{
        //Toast.makeText(this, "Validation completed", Toast.LENGTH_SHORT).show()
    }



    if(un.equals(username) && ps.equals(password))
    {

       var intent=Intent(this,StudentActivity2::class.java)
        intent.putExtra("user",username)
        startActivity(intent)
    }else{
        Toast.makeText(this, "invalid username or password", Toast.LENGTH_SHORT).show()
}



}
      textRegister.setOnClickListener{
          startActivity(Intent(this,RegisterActivity2::class.java))
      }
    }


}