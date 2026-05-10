package com.example.test_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test_project.databinding.ActivityLoginBinding
import kotlin.jvm.java

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val usernameRegis = intent.getStringExtra("USERNAME")
        val passwordRegis = intent.getStringExtra("PASSWORD")
        val fullNameRegis = intent.getStringExtra("FULLNAME")

        binding.buttonLogin.setOnClickListener {
            val userIn = binding.editTextUsername.text.toString()
            val passIn = binding.editTextPassword.text.toString()

            if (userIn == usernameRegis && passIn == passwordRegis) {
                val intent = Intent(this, HomepageActivity::class.java)
                intent.putExtra("NAMA_TAMPIL", fullNameRegis)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Data tidak cocok!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}