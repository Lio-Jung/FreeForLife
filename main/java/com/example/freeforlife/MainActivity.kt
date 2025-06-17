package com.example.freeforlife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.freeforlife.ui.theme.FreeForLifeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FreeForLifeTheme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "FFL에 오신 것을 환영합니다!")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* 버튼 눌렀을 때 동작 */ }) {
            Text("눌러보세요!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FreeForLifeTheme {
        HomeScreen()
    }
}
