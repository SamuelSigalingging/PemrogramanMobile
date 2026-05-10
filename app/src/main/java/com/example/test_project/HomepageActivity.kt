package com.example.test_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.test_project.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val namaLengkap = intent.getStringExtra("NAMA_TAMPIL")

        binding.textViewFullName.text = "Selamat Datang ${namaLengkap ?: "Nama Lengkap"}"
    }
}