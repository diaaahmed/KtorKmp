package org.ktor.ktorkmp.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MainRow(
     mainTitle:String,
)
{
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = mainTitle, fontSize = 18.sp)
        SpacerHorizontal15()
        Text(text = "شراء", fontSize = 18.sp)
        SpacerHorizontal15()
        Text(text = "بيع", fontSize = 18.sp,)
    }
}