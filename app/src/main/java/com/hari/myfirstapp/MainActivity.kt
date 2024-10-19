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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hari.myfirstapp.ui.theme.MyFirstAppTheme
import kotlin.math.roundToInt

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
    val dropDownSelection = remember { mutableStateOf("Meter") }
    val dropDownSelection2 = remember { mutableStateOf("Meter") }
    var inputValue by remember {mutableStateOf("")}
    var result by remember { mutableStateOf(0.0) }
    var conversionFactor by remember { mutableStateOf(1.0) }
    var oConversionFactor by remember { mutableStateOf(1.0) }
    var resultString by remember { mutableStateOf("") }


    val customTextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 34.sp,
    )

    fun convertUnits() {
        // ?: -> ternary operator in kotlin
        // example result.toDoubleOrNull() ?: 0.0

        result = ((inputValue.toDouble() * conversionFactor *100.0 / oConversionFactor)/100).toDouble();

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally
    ) {

        Text(
            text = "Unit Converter ",
            modifier = Modifier.padding(15.dp),
            style = MaterialTheme.typography.headlineLarge

        )

        OutlinedTextField(value= inputValue,
            onValueChange = {value:String ->
                run {
                    if(value.toDoubleOrNull() != null) {

                        inputValue= value
                        convertUnits()
                    }
                }
            }, label = {Text(text = "Enter Value")})
        Spacer(modifier=Modifier.height(15.dp))
        Row {

           Box{
                Button(onClick = {
                    showUnitDropDown.value = !showUnitDropDown.value;
                }) {

                    Text(dropDownSelection.value)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
               DropdownMenu(expanded = showUnitDropDown.value, onDismissRequest = {
                   showUnitDropDown.value = false
               }) {
                   DropdownMenuItem(text = {Text("Centimeter")},onClick = {
                       dropDownSelection.value = "Centimeter"
                       showUnitDropDown.value = false
                       conversionFactor = 0.01
                       convertUnits()
                   })
                   DropdownMenuItem(text = {Text("Meter")},onClick = {
                       dropDownSelection.value = "Meter"
                       showUnitDropDown.value = false
                       conversionFactor = 1.0
                       convertUnits()
                   })
                   DropdownMenuItem(text = {Text("Feet")},onClick = {
                       dropDownSelection.value = "Feet"
                       showUnitDropDown.value = false
                       conversionFactor = 0.3048
                       convertUnits()
                   })
                   DropdownMenuItem(text = {Text("Millimeter")},onClick = {
                       dropDownSelection.value = "Millimeter"
                       showUnitDropDown.value = false
                       conversionFactor = 0.001
                       convertUnits()
                   })

               }

           }
            Spacer(modifier=Modifier.width(15.dp))
            Box {
                Button(onClick = {
                    showUnitDropDown2.value = !showUnitDropDown2.value
                }) {
                    Text(dropDownSelection2.value)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                }
                DropdownMenu(expanded = showUnitDropDown2.value, onDismissRequest = {
                    showUnitDropDown2.value = false
                }) {
                    DropdownMenuItem(text = {Text("Centimeter")},onClick = {
                        dropDownSelection2.value = "Centimeter"
                        showUnitDropDown2.value = false
                        oConversionFactor = 0.01
                        convertUnits()
                    })
                    DropdownMenuItem(text = {Text("Meter")},onClick = {
                        dropDownSelection2.value = "Meter"
                        showUnitDropDown2.value = false
                        oConversionFactor = 1.0
                        convertUnits()
                    })
                    DropdownMenuItem(text = {Text("Feet")},onClick = {
                        dropDownSelection2.value = "Feet"
                        showUnitDropDown2.value = false
                        oConversionFactor = 0.3048
                        convertUnits()
                    })
                    DropdownMenuItem(text = {Text("Millimeter")},onClick = {
                        dropDownSelection2.value = "Millimeter"
                        showUnitDropDown2.value = false
                        oConversionFactor = 0.001
                        convertUnits()
                    })
                }
            }

        }
        Spacer(modifier = Modifier.height(15.dp))
        Text("Result : ${result} ${dropDownSelection2.value}", style = MaterialTheme.typography.bodyLarge)
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
