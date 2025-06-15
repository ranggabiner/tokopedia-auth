package com.biner.tokopediaauth.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.biner.tokopediaauth.presentation.components.ButtonCustom
import com.biner.tokopediaauth.utils.SessionManager

@Composable
fun HomeView(
    navController: NavController,
    sessionManager: SessionManager,
    viewModel: HomeViewModel = viewModel()
) {
    val token = sessionManager.getUserToken()
    val profile by viewModel.profile.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchProfile( token)
        print("TOKENNYA: " + token)
    }

    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .padding(horizontal = 8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Halo Coy",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.primary
                )
                if (profile != null) {
                    Text(
                        profile?.email ?: "-",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        "ID: ${profile?.id ?: "-"}",
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                } else {
                    Text("Lagi ngambil data user...", style = MaterialTheme.typography.bodyMedium)
                }
            }

            ButtonCustom(
                label = "Keluar",
                color = MaterialTheme.colorScheme.error
            ) {
                viewModel.signOut(token) {
                    sessionManager.logout()
                    navController.navigate("SignInView") {
                        popUpTo("HomeView") { inclusive = true }
                        }
                    }
                }
            }
        }
    }

@Preview(showSystemUi = true)
@Composable
private fun HomeViewPreview() {
    HomeView(
        navController = rememberNavController(),
        sessionManager = SessionManager(rememberNavController().context)
    )
}