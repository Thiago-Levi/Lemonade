package com.example.lemonade


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

@Composable
fun LemonadeApp() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        HeaderApp()
        Spacer(Modifier.weight(1f))
        TapImagesApp()
        Spacer(Modifier.weight(1f))
    }
}

@Composable
fun HeaderApp(headerTopColor: Int = R.color.main_color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .background(color = colorResource(id = headerTopColor)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Lemonade", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun TapImagesApp() {
    //fazer com que a imagem e o texto mudem ao clicar na imagem. Fluxo completo
    var currentImage by remember { mutableStateOf(R.drawable.lemon_tree) }
    var currentText by remember { mutableStateOf(R.string.lemon_tree_legend) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {


        Image(
            contentDescription = stringResource(id = R.string.lemon_tree_content_description),
            painter = painterResource(id = currentImage),
            modifier = Modifier
                .background(
                    colorResource(id = R.color.bg_color_images_app),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(12.dp).clickable {
                    currentImage = R.drawable.lemon_squeeze
                    currentText = R.string.keep_tapping_lemon_legend

                }
        )
        Text(
            text = stringResource(id = currentText),
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewDefault() {
    LemonadeTheme {
        LemonadeApp()
    }
}

