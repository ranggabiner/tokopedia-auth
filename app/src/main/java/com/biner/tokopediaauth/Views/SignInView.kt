package com.biner.tokopediaauth

import TokopediaTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.fillMaxSize

@Composable
fun SignInView(email: String, password: String) {
    TokopediaTheme {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .padding(bottom = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = spacedBy(20.dp)
            ) {
                Text(
                    "Masuk dengan Alamat E-mail",
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
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
                    ButtonCustom(label = "Masuk") {
                        println("logged")
                    }
                    TextNote()
                }
            }
            Footer()
        }

    }
}

@Preview(
    showSystemUi = true,
)
@Composable
fun SignInViewPreview() {
    SignInView("2310501014@mahasiswa.ac.id", "password123")
}