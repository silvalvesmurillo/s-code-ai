package com.scode.ai.httpcat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier

/**
 * Activity that hosts the sign-up screen.
 */
class SignUpActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            HttpCatTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                    SignUpScreen(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}
