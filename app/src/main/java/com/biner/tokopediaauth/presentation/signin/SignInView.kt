package com.biner.tokopediaauth.presentation.signin

import TokopediaTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.biner.tokopediaauth.presentation.components.ButtonCustom
import com.biner.tokopediaauth.presentation.components.Header
import com.biner.tokopediaauth.presentation.components.TextFieldCustom
import com.biner.tokopediaauth.presentation.components.TextNote
import com.biner.tokopediaauth.presentation.components.Footer
import com.biner.tokopediaauth.utils.SessionManager

@Composable
fun SignInView(
    viewModel: SignInViewModel = viewModel(),
    navController: NavController,
    sessionManager: SessionManager
) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

    val email = viewModel.email
    val password = viewModel.password

    LaunchedEffect(viewModel.isLoggedIn) {
        if (viewModel.isLoggedIn) {
            navController.navigate("HomeView") {
                popUpTo("SignInView") { inclusive = true }
            }
        }
    }

    TokopediaTheme {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .padding(horizontal = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(verticalArrangement = spacedBy(20.dp)) {
                Header(text = "Masuk dengan Alamat E-mail")

                Column(verticalArrangement = spacedBy(17.dp)) {
                    TextFieldCustom(label = "E-mail", password = false, value = email, onValueChange = { viewModel.email = it })
                    TextFieldCustom(label = "Kata Sandi", password = true, value = password, onValueChange = { viewModel.password = it })
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = spacedBy(12.dp),
                ) {
                    ButtonCustom(label = "Masuk", color = MaterialTheme.colorScheme.primary) {
                        viewModel.signIn(sessionManager)
                    }
                    TextNote()
                    if (viewModel.message.isNotBlank()) {
                        androidx.compose.material3.Text(
                            text = viewModel.message,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            Footer(
                question = "Belum punya akun? ",
                action = "Daftar Sekarang",
                onClick = {
                    navController.navigate("SignUpView")
                }
            )
        }
    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun SignInViewPreview() {
    SignInView(
        TODO(),
        navController = rememberNavController(),
        sessionManager = SessionManager(rememberNavController().context),
    )
}