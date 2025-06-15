package com.biner.tokopediaauth

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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biner.tokopediaauth.Views.HomeView
import com.biner.tokopediaauth.Views.SignInView
import com.biner.tokopediaauth.Views.SignUpView
import com.biner.tokopediaauth.Views.VerifyView
import com.biner.tokopediaauth.utils.SessionManager

class MainActivity : ComponentActivity() {
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this)

        setContent {
            val navController = rememberNavController()
            TokopediaTheme {
                Surface(
                    modifier = Modifier.padding(8.dp).fillMaxSize(),
                    color = Color.White
                ) {
                    val startDestination = if (sessionManager.isLoggedIn()) "HomeView" else "SignInView"

                    NavHost(navController = navController, startDestination = startDestination) {
                        composable("SignInView") {
                            SignInView("2310501014@mahasiswa.ac.id", "password123", navController, sessionManager)
                        }
                        composable("SignUpView") {
                            SignUpView("2310501014@mahasiswa.upnvj.ac.id", "password123", navController)
                        }
                        composable("VerifyView") {
                            VerifyView("2310501014@mahasiswa.upnvj.ac.id",  navController)
                        }
                        composable("HomeView") {
                            HomeView(navController, sessionManager)
                        }
                    }
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