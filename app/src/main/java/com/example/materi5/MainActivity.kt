package com.example.materi5

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.materi5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val sharedPrefFile = "kotlinsharedpreference"
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPreferences : SharedPreferences = this.getSharedPreferences(sharedPrefFile, MODE_PRIVATE)

        binding.btnSave.setOnClickListener{
            val id : Int = Integer.parseInt(binding.etInputId.text.toString())
            val name : String = binding.etInputName.text.toString()
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            editor.putInt("id_key", id)
            editor.putString("name_key", name)
            editor.apply()

            Toast.makeText(this, "Data Berhasil Tersimpan", Toast.LENGTH_SHORT).show()
        }

        binding.btnView.setOnClickListener{
            val sharedIdValue = sharedPreferences.getInt("id_key",0)
            val sharedNameValue = sharedPreferences.getString("name_key", "default_name")

            if (sharedIdValue.equals(0) && (sharedNameValue.equals("default_name"))){
                binding.tvShowName.setText("default_name : ${sharedNameValue}").toString()
                binding.tvShowId.setText("id_key : ${sharedIdValue}")
                sharedPreferences.contains("id_key")

                Toast.makeText(this,"data view kosong", Toast.LENGTH_SHORT).show()
            }
            else{
                binding.tvShowName.setText(sharedNameValue)
                binding.tvShowId.setText(sharedIdValue.toString())

                Toast.makeText(this,"data view ditampilkan", Toast.LENGTH_SHORT).show()
            }

        }

        binding.btnClear.setOnClickListener{
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            binding.tvShowName.setText("")
            binding.tvShowId.setText("")

            Toast.makeText(this,"data terhapus", Toast.LENGTH_SHORT).show()
        }




    }




}