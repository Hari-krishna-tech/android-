package com.hari.myfirstapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hari.myfirstapp.ui.theme.MyFirstAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyFirstAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {
    val showUnitDropDown = remember { mutableStateOf(false) }
    val showUnitDropDown2 = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally
    ) {

        Text(
            text = "Unit Converter ",
            modifier = Modifier.padding(15.dp)
        )

        OutlinedTextField(value= "",
            onValueChange = {value:String -> println(value)})
        Spacer(modifier=Modifier.height(15.dp))
        Row {

           Box{
                Button(onClick = {
                    showUnitDropDown.value = !showUnitDropDown.value;
                }) {

                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
               DropdownMenu(expanded = showUnitDropDown.value, onDismissRequest = {
                   showUnitDropDown.value = false
               }) {
                   DropdownMenuItem(text = {Text("Centimeter")},onClick = {})
                   DropdownMenuItem(text = {Text("Meter")},onClick = {})
                   DropdownMenuItem(text = {Text("Feet")},onClick = {})
                   DropdownMenuItem(text = {Text("Millimeter")},onClick = {})

               }

           }
            Spacer(modifier=Modifier.width(15.dp))
            Box {
                Button(onClick = {
                    showUnitDropDown2.value = !showUnitDropDown2.value
                }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = showUnitDropDown2.value, onDismissRequest = {
                    showUnitDropDown2.value = false
                }) {
                    DropdownMenuItem(text = {Text("Centimeter")},onClick = {})
                    DropdownMenuItem(text = {Text("Meter")},onClick = {})
                    DropdownMenuItem(text = {Text("Feet")},onClick = {})
                    DropdownMenuItem(text = {Text("Millimeter")},onClick = {})
                }
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        Text("Result")
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    MyFirstAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) {
            UnitConverter()
        }

    }
}
