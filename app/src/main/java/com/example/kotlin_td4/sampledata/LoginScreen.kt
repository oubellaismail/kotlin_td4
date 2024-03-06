package com.example.kotlin_td4.sampledata

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    name : String,
    onNameChange : (String) -> Unit,
    password : String,
    onPasswordChange : (String) -> Unit,
    onLogin : () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = onNameChange,
            singleLine = true,
            label = {Text("Name")},
        )
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            singleLine = true,
            label = {Text("Password")},
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = onLogin) {
            Text(text = "Login")
        }

    }
}