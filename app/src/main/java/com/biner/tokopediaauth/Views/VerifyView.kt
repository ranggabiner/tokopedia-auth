package com.biner.tokopediaauth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun VerifyView(email: String) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .padding(horizontal = 8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Outlined.Email,
            modifier = Modifier.size(23.dp),
            tint = MaterialTheme.colorScheme.primary,
            contentDescription = "Email Icon",
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Masukkan Kode Verifikasi",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                "Kode verifikasi telah dikirim melalui e-mail ke ${email}",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
            TextField(
                value = "",
                onValueChange = {},
                label = { Text("Kode Verifikasi") },
                placeholder = { Text("Masukkan kode verifikasi") },
                singleLine = true,
                maxLines = 1,
                isError = false,
            )
            Row {
                Text(
                    "Tidak menerima kode? ",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
                Text(
                    "Kirim ulang",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.clickable {
                        println("Mengirim ulang kode verifikasi")
                    }
                )
            }
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable
fun VerifyViewPreview() {
    VerifyView("2310501014@maasiswa.ac.id")
}
