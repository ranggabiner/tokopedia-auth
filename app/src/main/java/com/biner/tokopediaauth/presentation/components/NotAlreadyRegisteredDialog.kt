package com.biner.tokopediaauth.presentation.components

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NotAlreadyRegisteredDialog() {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = spacedBy(14.dp)
            ) {
            Text("Email Belum Terdaftar", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text("Lanjut daftar dengan email ini 2310501014@mahasiswa.upnvj.ac.id?", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.secondary, textAlign = TextAlign.Center)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = spacedBy(12.dp)
            ) {
                SmallButton(
                    label = "Ubah",
                    onClick = { /* TODO: Handle No Click */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp),
                    textColor = MaterialTheme.colorScheme.secondary,
                    buttonColor = Color.Transparent
                )
                SmallButton(
                    label = "Ya, Daftar",
                    onClick = { /* TODO: Handle No Click */ },
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp),
                    textColor = MaterialTheme.colorScheme.onPrimary,
                    buttonColor = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun SmallButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    textColor: Color,
    buttonColor: Color
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = textColor
        )
    ) {
        Text(text = label, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun NotAlreadyRegisteredDialogPreview() {
    NotAlreadyRegisteredDialog()
}