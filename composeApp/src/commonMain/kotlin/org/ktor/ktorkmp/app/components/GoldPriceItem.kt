package org.ktor.ktorkmp.app.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.coil3.CoilImage
import ktorkmp.composeapp.generated.resources.Res
import ktorkmp.composeapp.generated.resources.coin
import org.jetbrains.compose.resources.painterResource
import org.ktor.ktorkmp.domain.entity.GoldPrice

@Composable
fun GoldPriceItem(
    modifier: Modifier = Modifier,
    item: GoldPrice,
    content: @Composable () -> Unit = {}

)
{
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.weight(1.5f),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                CoilImage(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(size = 8.dp)),
                    imageModel = { item.buy},
                    loading = { painterResource(Res.drawable.coin) },
                    failure = { painterResource(Res.drawable.coin) },
                    imageOptions = ImageOptions(
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                )

                SpacerHorizontal15()
                Text(text = item.karat, textAlign = TextAlign.Center, color = Color.Black)

                SpacerHorizontal15()
            }
            Text(
                modifier = Modifier.weight(1f),
                text = item.buy,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
            SpacerHorizontal15()
            Text(
                modifier = Modifier.weight(1f),
                text = item.sell,
                textAlign = TextAlign.Center,
                color = Color.Black
            )

            content()

        }
    }
}
