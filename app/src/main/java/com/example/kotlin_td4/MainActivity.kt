package com.example.kotlin_td4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_td4.ui.theme.Kotlin_td4Theme
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlin_td4.sampledata.LoginScreen
import com.example.kotlin_td4.sampledata.WelcomeArea
import com.example.kotlin_td4.sampledata.WelcomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_td4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

enum class Tab {
    LOGIN,
    MARHABAN
}

class User(val name:String,val firstName:String , val lastName :String, val password:String) {

}



@Composable
fun App(){
    val users  = mutableListOf<User>( User("JohnDoe", "Salah", "Aitouahman", "password1"),
    User("JaneDoe", "Jane", "Doe", "password2"),
     User("AliceSmith", "Alice", "Smith", "password3"),
     User("BobJohnson", "Bob", "Johnson", "password4"),
     User("EveBrown", "Eve", "Brown", "password5"))

    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var lastName by remember {
        mutableStateOf("")
    }
    var FirstName by remember {
        mutableStateOf("")
    }
    var isTrue = false
    val text = "creadentials incorrect"
    val duration = Toast.LENGTH_SHORT
    val context = LocalContext.current
    val toast = Toast.makeText(context,text,duration)

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Tab.LOGIN.name,
        modifier = Modifier
    ){
        composable(route = Tab.LOGIN.name){
            LoginScreen(name ,
                onNameChange = {name = it} ,
                password,
                onPasswordChange = {password = it} ,
                onLogin = {
                    users.forEach { user ->
                        if (user.name == name && user.password == password) {
                            FirstName = user.firstName
                            lastName = user.lastName
                            navController.navigate(Tab.MARHABAN.name)
                            isTrue = true
                        }
                    }

                    name = ""
                    password = ""
                    if(!isTrue)
                    toast.show()
                }

            )
        }
        composable(route = Tab.MARHABAN.name){
            WelcomeScreen(
                name = FirstName,
                lastName = lastName,
                onBack = {
                    navController.navigate(Tab.LOGIN.name)
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Kotlin_td4Theme {
        App()
    }
}

