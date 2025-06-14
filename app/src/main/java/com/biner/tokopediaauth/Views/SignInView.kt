package com.biner.tokopediaauth.Views

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
import com.biner.tokopediaauth.Views.Components.ButtonCustom
import com.biner.tokopediaauth.Views.Components.Header
import com.biner.tokopediaauth.Views.Components.TextFieldCustom
import com.biner.tokopediaauth.Views.Components.TextNote
import com.biner.tokopediaauth.Views.Components.Footer

@Composable
fun SignInView(email: String, password: String) {
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
                Header(text = "Masuk dengan Alamat E-mail" )
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
                    ButtonCustom(label = "Masuk", color = MaterialTheme.colorScheme.primary) {
                        println("logged")
                    }
                    TextNote()
                }
            }
            Footer(question = "Belum punya akun? ", action = "Daftar Sekarang", onClick = {
                println("Navigating to Sign Up")
            })
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