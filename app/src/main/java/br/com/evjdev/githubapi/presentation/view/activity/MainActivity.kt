package br.com.evjdev.githubapi.presentation.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.evjdev.githubapi.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}