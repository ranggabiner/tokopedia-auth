package com.biner.tokopediaauth.presentation

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.biner.tokopediaauth.presentation.signin.SignInViewModel
import com.biner.tokopediaauth.presentation.signup.SignUpViewModel
import com.biner.tokopediaauth.presentation.verify.VerifyViewModel
import com.biner.tokopediaauth.presentation.home.HomeView
import com.biner.tokopediaauth.presentation.signin.SignInView
import com.biner.tokopediaauth.presentation.signup.SignUpView
import com.biner.tokopediaauth.presentation.verify.VerifyView
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
                            val signInViewModel = viewModel<SignInViewModel>()
                            SignInView(signInViewModel, navController, sessionManager)
                        }
                        composable("SignUpView") {
                            val signUpViewModel = viewModel<SignUpViewModel>()
                            SignUpView(signUpViewModel, navController)
                        }
                        composable("VerifyView?email={email}") { backStackEntry ->
                            val email = backStackEntry.arguments?.getString("email") ?: ""
                            val verifyViewModel = viewModel<VerifyViewModel>(backStackEntry)
                            VerifyView(email, navController, viewModel = verifyViewModel)
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