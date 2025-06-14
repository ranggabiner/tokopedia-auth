package com.biner.tokopediaauth.Views.Components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextNote() {
    Text(
        "Setelah ini kamu perlu masukkan kode verifikasi yang akan dikirimkan ke e-mail di atas.",
        style = MaterialTheme.typography.bodySmall, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.secondary,
    )
}