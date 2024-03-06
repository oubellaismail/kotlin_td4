package com.example.kotlin_td4.sampledata

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlin_td4.R

@Composable
fun WelcomeScreen(name : String,lastName:String, onBack : () -> Unit,){
    Column (modifier = Modifier.fillMaxSize()
        .padding(16.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally)
    {
        GetImage()
        WelcomeArea(name = name,lastName = lastName)
        Button(onClick = onBack) {
            Text(text = "Logout")
        }
    }
}

@Composable
fun GetImage(){
    val image = painterResource(R.drawable.pc_wallpaper)
    Image(
        painter = image,
        contentDescription = null
    )
}

@Composable
fun WelcomeArea(name : String,lastName:String){
    Column {
        Text(text = "Marhaban")
        Text(text = name)
        Text(text = lastName)
    }
}