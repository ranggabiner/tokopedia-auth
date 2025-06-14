package com.biner.tokopediaauth

import TokopediaTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpView(email: String, password: String) {
    TokopediaTheme {
        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .padding(horizontal = 8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = spacedBy(20.dp)
            ) {
                Header(text = "Daftar dengan E-mail")
                Column(
                    verticalArrangement = spacedBy(17.dp)
                ) {
                    TextFieldCustom(label = "E-mail", password = false, value = "")
                    TextFieldCustom(label = "Kata Sandi", password = true, value = "")
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = spacedBy(12.dp),
                ) {
                    ButtonCustom(label = "Lanjut") {
                        println("Navigated to next step")
                    }
                    TextNote()
                }
            }
            Footer(question = "Sudah punya akun? ", action = "Masuk", onClick = {
                println("Navigating to Sign Up")
            })
        }
    }
}

@Preview (
    showSystemUi = true,
)
@Composable
fun SignUpViewPreview() {
    SignUpView("2310501014@mahasiswa.upnvj.ac.id", "password123")
}