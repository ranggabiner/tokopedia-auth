package com.biner.tokopediaauth.Views

import TokopediaTheme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.biner.tokopediaauth.Views.Components.BackButton
import com.biner.tokopediaauth.Views.Components.Header
import com.biner.tokopediaauth.Views.Components.TextFieldCustom
import com.biner.tokopediaauth.Views.Components.ButtonCustom
import com.biner.tokopediaauth.Views.Components.TextNote
import com.biner.tokopediaauth.Views.Components.Footer

@Composable
fun SignUpView(email: String, password: String, navController: NavController) {
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
                BackButton(navController)
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
                    ButtonCustom(label = "Lanjut", color = MaterialTheme.colorScheme.primary) {
                        navController.navigate("VerifyView")
                    }
                    TextNote()
                }
            }
            Footer(question = "Sudah punya akun? ", action = "Masuk", onClick = {
                navController.navigateUp()
            })
        }
    }
}

@Preview (
    showSystemUi = true,
)
@Composable
fun SignUpViewPreview() {
    SignUpView("2310501014@mahasiswa.upnvj.ac.id", "password123", navController = rememberNavController())
}