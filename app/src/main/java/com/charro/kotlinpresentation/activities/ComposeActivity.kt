package com.charro.kotlinpresentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.charro.kotlinpresentation.R

class ComposeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text("Hello world!")
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
        NewsStory()
}

@Composable
fun NewsStory() {
    var image = imageResource(R.drawable.ic_launcher_foreground)

    Column(modifier = Modifier.padding(all = 16.dp)) {
        Image(image)
        Text("This is our compose example")
        Text("with some text")
    }
}