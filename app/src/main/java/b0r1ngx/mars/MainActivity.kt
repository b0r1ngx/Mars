package b0r1ngx.mars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import b0r1ngx.mars.overview.MarsViewModel
import b0r1ngx.mars.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    private val marsViewModel: MarsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Mars(marsViewModel)
                }
            }
        }
    }
}

@Composable
fun Mars(marsViewModel: MarsViewModel) {
    val mars by marsViewModel.status.observeAsState()

    mars?.let {
        CenterText(str = it)
    }
}

@Composable
fun CenterText(str: String) {
    Text(text = str, textAlign = TextAlign.Center)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestTheme {
        CenterText("Android")
    }
}