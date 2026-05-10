package com.example.test_project

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.test_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.buttonRegister.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()
            val confirmPassword = binding.editTextConfirmPassword.text.toString()
            val fullName = binding.editTextFullName.text.toString()

            if(username.isEmpty()){
                binding.editTextUsername.error = "Username Tidak Boleh Kosong"
            }
            if(password.isEmpty()){
                binding.editTextPassword.error = "Password Tidak Boleh Kosong"
            }
            if(confirmPassword.isEmpty()){
                binding.editTextConfirmPassword.error = "Confirm Password Tidak Boleh Kosong"
            }
            if(fullName.isEmpty()){
                binding.editTextFullName.error = "Full Name Tidak Boleh Kosong"
            }

            if(username.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() && fullName.isNotEmpty()){
                if(password == confirmPassword){
                    Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, LoginActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    intent.putExtra("PASSWORD", password)
                    intent.putExtra("FULLNAME", fullName)
                    startActivity(intent)
                }
                else{
                    binding.editTextPassword.error = "Password dan Confirm Password tidak sama"
                    binding.editTextConfirmPassword.error = "Password dan Confirm Password tidak sama"
                    Toast.makeText(this, "Cocokan Password dan confirm password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}