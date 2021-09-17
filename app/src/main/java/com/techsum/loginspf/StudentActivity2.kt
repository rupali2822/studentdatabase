package com.techsum.loginspf

import android.content.ContentValues
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.database.sqlite.SQLiteDatabase
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_student2.*

class StudentActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student2)

        //1.create db
        var sqlitedb = openOrCreateDatabase("DB_11_Sept", Context.MODE_PRIVATE, null)

        //create table
        sqlitedb.execSQL("create table if not exists studentinfo(_id INTEGER PRIMARY KEY AUTOINCREMENT,sroll Integer,sname varchar(25),sedu varchar(10),smark varchar(10))")

        //insert(),query(),update(),delete()
        btn_insert.setOnClickListener {
            var roll_number = et_roll.text.toString()
            var student_name = et_sname.text.toString()
            var education = et_edu.text.toString()
            var student_marks = et_marks.text.toString()

            var cv = ContentValues()
            cv.put("sroll", roll_number)
            cv.put("sname", student_name)
            cv.put("sedu", education)
            cv.put("smark", student_marks)


            var status = sqlitedb.insert("studentinfo", null, cv)

            if (status == (-1).toLong()) {
                Toast.makeText(this, "Unable to insert data", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Data insert successfully", Toast.LENGTH_SHORT).show()
            }
        }

        //cursor Adapter
        btn_show.setOnClickListener {
            var cursor = sqlitedb.query("studentinfo", null, null, null, null, null, null)
            var fromarray = arrayOf("sroll", "sname", "sedu", "smarks")
            var intArray = intArrayOf(R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4)

            var cursoradapter = SimpleCursorAdapter(this,
                    R.layout.studentdata,
                    cursor,
                    fromarray,
                    intArray)

            List_view.adapter = cursoradapter
        }
        btn_update.setOnClickListener {
            var roll_number = et_roll.text.toString()
            var student_name = et_sname.text.toString()
            var education = et_edu.text.toString()
            var student_marks = et_marks.text.toString()

            var cv = ContentValues()
            cv.put("sroll", roll_number)
            cv.put("sname", student_name)
            cv.put("sedu", education)
            cv.put("smark", student_marks)

            var status = sqlitedb.update("studentinfo", cv, "sroll=?", arrayOf(roll_number))
            if (status > 0) {
                Toast.makeText(this, "Data update successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show()
            }
        }
        btn_delete.setOnClickListener {
            var roll_number = et_roll.text.toString()
            var status = sqlitedb.delete("studentinfo", "sroll=?,", arrayOf(roll_number))
            if (status > 0) {
                Toast.makeText(this, "Data deleted successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to delete data", Toast.LENGTH_SHORT).show()
            }
        }
    }
//back button code

}

