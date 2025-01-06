package org.ktor.ktorkmp.app.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import ktorkmp.composeapp.generated.resources.Res
import ktorkmp.composeapp.generated.resources.ic_notification
import ktorkmp.composeapp.generated.resources.ic_refresh
import ktorkmp.composeapp.generated.resources.ic_share
import org.jetbrains.compose.resources.painterResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarScreen(
    onRefreshCLick : ()-> Unit = {},
)
{
   TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    tint = Color.Black,
                    painter = painterResource(Res.drawable.ic_share),
                    contentDescription = "Share icon"
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black
        ),
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "أسعار اليوم",
                    fontWeight = FontWeight.Bold
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    tint = Color.Black,
                    painter = painterResource(Res.drawable.ic_notification),
                    contentDescription = "Notification"
                )
            }
            IconButton(onClick = {
                onRefreshCLick()
            }) {
                Icon(
                    tint = Color.Black,
                    painter = painterResource(Res.drawable.ic_refresh),
                    contentDescription = "Refresh"
                )
            }

        },
    )
}