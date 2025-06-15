package com.biner.tokopediaauth.presentation.verify

import TokopediaTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.biner.tokopediaauth.presentation.components.BackButton
import com.biner.tokopediaauth.utils.SessionManager

@Composable
fun VerifyView(
    email: String,
    navController: NavController,
    viewModel: VerifyViewModel = viewModel()
) {
    val context = LocalContext.current
    val sessionManager = remember { SessionManager(context) }

    LaunchedEffect(Unit) {
        viewModel.email = email
    }

    LaunchedEffect(viewModel.isVerified) {
        println("LaunchedEffect jalan. isVerified = ${viewModel.isVerified}")
        if (viewModel.isVerified) {
            navController.navigate("HomeView") {
                popUpTo("VerifyView") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp, horizontal = 16.dp),
    ) {
        BackButton(navController)

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Icon(
                imageVector = Icons.Outlined.Email,
                contentDescription = "Email Icon",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(36.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Masukkan Kode Verifikasi",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Kode telah dikirim ke $email",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextField(
                value = viewModel.otp,
                onValueChange = { input ->
                    viewModel.otp = input.filter { it.isDigit() }.take(6)
                },
                modifier = Modifier.width(200.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                textStyle = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    unfocusedIndicatorColor = Color.Gray
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (viewModel.message.isNotBlank()) {
                Text(
                    text = viewModel.message,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { viewModel.verifyOtp(sessionManager = sessionManager) },
                enabled = !viewModel.isLoading
            ) {
                Text(text = if (viewModel.isLoading) "Memverifikasi..." else "Verifikasi")
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Tidak menerima kode?")
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Kirim ulang",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        // TODO: Kirim ulang OTP (future implementation)
                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun VerifyViewPreview() {
    TokopediaTheme {
        VerifyView(email = "2310501014@mahasiswa.ac.id", navController = rememberNavController())
    }
}