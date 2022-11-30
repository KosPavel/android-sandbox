package com.kospavel.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.kospavel.sandbox.ui.main.MainScreen
import com.kospavel.sandbox.ui.theme.SandboxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SandboxTheme {
                MainScreen()
            }
        }
    }
}