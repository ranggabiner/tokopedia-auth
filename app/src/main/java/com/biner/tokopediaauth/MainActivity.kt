package com.biner.tokopediaauth // Ganti dengan package aplikasi Anda

import TokopediaTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TokopediaTheme {
                Surface(
                    modifier = Modifier.padding(8.dp).fillMaxSize(),
                    color = Color.White
                ) {
                    SignInView("2310501014@mahasiswa.ac.id", "password123" )
                }
            }
        }
    }
}

@Composable
fun Greeting(email: String, password: String) {
    Text(
        "Masuk dengan Alamat E-mail", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold
    )
}

@Preview(
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
            Greeting("2310501014@mahasiswa.ac.id", "password123" )
}