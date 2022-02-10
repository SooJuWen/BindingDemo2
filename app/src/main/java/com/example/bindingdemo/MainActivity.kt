package com.example.bindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.bindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val student = Student("W333", "Ali")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myData = student           //throw the whole student with its data into the binding

        binding.btnUpdate.setOnClickListener {
            student.name = "Alex"

            //load again the data
            binding.apply {
                invalidateAll()
            }
        }
        //binding.tvStudentId.text = student.id
        //binding.tvStudentName.text = student.name




    }
}