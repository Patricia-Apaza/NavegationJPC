package com.edu.upeu.navegationjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.edu.upeu.navegationjpc.ui.theme.DarkColorScheme
import com.edu.upeu.navegationjpc.ui.theme.LightColorScheme
import com.edu.upeu.navegationjpc.ui.theme.NavegationJPCTheme
import com.edu.upeu.navegationjpc.ui.theme.ThemeType
import com.edu.upeu.navegationjpc.ui.theme.sBlueDarkScheme
import com.edu.upeu.navegationjpc.ui.theme.sBlueLightScheme
import com.edu.upeu.navegationjpc.utils.conttexto
import com.edu.upeu.navegationjpc.utils.isNight
import pe.edu.upeu.navegationjpc.ui.presentation.component.MyAppDrawer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val themeType= remember { mutableStateOf(ThemeType.RED)}
            val darkthemeX= isNight()
            val darktheme= remember { mutableStateOf(darkthemeX)}
            conttexto.CONTEXTO_APPX=this
            val colorScheme=when(themeType.value){
                ThemeType.RED->{if(darktheme.value) DarkColorScheme else LightColorScheme}
                ThemeType.GREEN->{if(darktheme.value) sBlueDarkScheme else sBlueLightScheme}
                else->{
                    LightColorScheme}
            }

            NavegationJPCTheme (colorScheme = colorScheme){


                MyAppDrawer(darkMode = darktheme, themeType = themeType)
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android DMP",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NavegationJPCTheme (colorScheme = LightColorScheme){
        Greeting("Android")
    }
}