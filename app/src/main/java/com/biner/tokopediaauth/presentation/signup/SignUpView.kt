package com.biner.tokopediaauth.presentation.signup

import TokopediaTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.biner.tokopediaauth.presentation.components.BackButton
import com.biner.tokopediaauth.presentation.components.Header
import com.biner.tokopediaauth.presentation.components.TextFieldCustom
import com.biner.tokopediaauth.presentation.components.ButtonCustom
import com.biner.tokopediaauth.presentation.components.TextNote
import com.biner.tokopediaauth.presentation.components.Footer
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun SignUpView(viewModel: SignUpViewModel = viewModel(), navController: NavController) {
    val email = viewModel.email
    val password = viewModel.password
    val message = viewModel.message
    val isLoading = viewModel.isLoading
    val scope = rememberCoroutineScope()

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
                BackButton(navController)
                Header(text = "Daftar dengan E-mail")
                Column(verticalArrangement = spacedBy(17.dp)) {
                    TextFieldCustom(
                        label = "E-mail",
                        password = false,
                        value = email,
                        onValueChange = { viewModel.email = it }
                    )
                    TextFieldCustom(
                        label = "Kata Sandi",
                        password = true,
                        value = password,
                        onValueChange = { viewModel.password = it }
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = spacedBy(12.dp)
                ) {
                    ButtonCustom(
                        label = if (isLoading) "Loading..." else "Lanjut",
                        color = MaterialTheme.colorScheme.primary
                    ) {
                        scope.launch {
                            val success = viewModel.signUp()
                            if (success) {
                                navController.navigate("VerifyView?email=${email}")
                            }
                        }
                    }

                    TextNote()

                    if (message.isNotBlank()) {
                        androidx.compose.material3.Text(
                            text = message,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }

            Footer(
                question = "Sudah punya akun? ",
                action = "Masuk",
                onClick = { navController.navigateUp() }
            )
        }
    }
}

@Preview (
    showSystemUi = true,
)
@Composable
fun SignUpViewPreview() {
    SignUpView(viewModel = TODO(), navController = rememberNavController())
}