package dev.lchang.appue.presentation.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import dev.lchang.appue.data.model.CountryModel
import dev.lchang.appue.data.model.MusicaModel

val Musica = listOf(
    MusicaModel("Karma Police", "Radiohead", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQHRjOMX5rcnNB5eRH46jRZAp5NoeKzr4YW4Q&s"),
    MusicaModel("No Surprises", "Radiohead", "https://es.rollingstone.com/wp-content/uploads/2025/08/Radiohead-regresa-a-su-album-mas-controversial-para-un-disco-en-vivo-espectacular.jpg"),
    MusicaModel("Video Games", "Lana Del Rey", "https://los40.com/resizer/v2/ZGROAFOURVAJNFFXXUMB3ODSCM.jpg?auth=ca8ff8be95aa4c88385453e997403b4d51ea5ab43b4898a84a061e93e28127e2&quality=70&width=1200&height=544&smart=true"),
    MusicaModel("Born To Die", "Lana Del Rey", "https://assets.mubicdn.net/images/film/101371/image-w1280.jpg?1745491395"),
    MusicaModel("Summertime Sadness", "Lana Del Rey", "https://es.rollingstone.com/wp-content/uploads/2023/03/Lana-del-Rey-de-la-oscuridad-a-la-luz.jpg")
)

@Composable
fun HomeScreen() {

    val headerImg = "https://images.unsplash.com/photo-1511379938547-c1f69419868d?q=80&w=1600&auto=format&fit=crop"

    val Pink = Color(0xFFA8B7FF)
    val PinkDark = Color(0xFF111A79)
    val PinkSoft = Color(0xFF9AB6D9)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(headerImg),
                contentDescription = "music",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(PinkDark.copy(alpha = 0.65f), Color.Transparent),
                            startY = 0f,
                            endY = Float.POSITIVE_INFINITY
                        )
                    )
            )
            // Titulo
            Text(
                text = "TODAY'S TOP HITS",
                fontFamily = FontFamily.Cursive,
                //negrita
                style = MaterialTheme.typography.titleLarge,


                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(16.dp)
            )
        }

        Spacer(Modifier.height(8.dp))


        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Black,
                                PinkDark.copy(alpha = 0.25f)
                            )
                        )
                    )
            ) {
                items(Musica) { music ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF0E0E0E) // casi negro
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(music.imageUrl),
                                contentDescription = music.name,
                                modifier = Modifier
                                    .size(64.dp)
                                    .clip(MaterialTheme.shapes.medium),
                                contentScale = ContentScale.Crop
                            )

                            Spacer(Modifier.width(16.dp))

                            Column(Modifier.weight(1f)) {
                                Text(
                                    text = music.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Pink
                                )
                                Text(
                                    text = "Artist: ${music.artist}",
                                    color = Color.White.copy(alpha = 0.85f)
                                )
                            }

                            IconButton(onClick = { /*  */ }) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "More",
                                    tint = PinkSoft
                                )
                            }
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Black, Color.Transparent) //
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black)
                        )
                    )
            )
        }
    }
}
