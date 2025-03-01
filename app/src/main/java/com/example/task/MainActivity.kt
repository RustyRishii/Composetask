package com.example.task

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.TaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    QuadrantFinal(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TaskCompleted (modifier: Modifier = Modifier, compliment: String, status: String) {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image (
            painter = image,
            contentDescription = null,
        )
        Text(
            text = status,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = compliment,
            fontSize = 16.sp,
        )
    }
}

// Q2Title: String, Q2Desc:String, Q3Title: String, Q3Desc:String, Q4Title: String, Q4Desc:String,
@Composable
fun QuadrantFinal (modifier: Modifier = Modifier)
{
    Row (){
        Quadrant1( q1Desc = "Displays text and follows the recommended Material Design guidelines.", q1Title = "Text Composable")
        Quadrant2( q2Desc = "Displays the images ", q2Title = "Image Composable")
    }
}

@Composable
fun Quadrant1 ( q1Title: String, q1Desc: String) {
        Box(
            modifier = Modifier
                .background(Color(0xFFB69DF8)),
        )
        {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,) {
                Text( 
                    text = q1Title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp),
                )
                Text(
                    text = q1Desc,
                )
            }
        }
}


@Composable
fun Quadrant2 ( q2Title: String, q2Desc: String) {
    Box(
        modifier = Modifier
            .background(Color(0xFFD0BCFF)),
    )
    {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,) {
            Text(
                text = q2Title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Text(
                text = q2Desc,
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TaskThemePreview() {
    TaskCompleted(
        modifier = Modifier,
        compliment = "Nice work",
        status = "All tasks completed"
    )
}
