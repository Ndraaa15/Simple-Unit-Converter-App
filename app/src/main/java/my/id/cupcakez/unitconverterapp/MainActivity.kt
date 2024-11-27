package my.id.cupcakez.unitconverterapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import my.id.cupcakez.unitconverterapp.ui.theme.UnitConverterAppTheme

// Inheritance from component activity
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterAppTheme {
                // Scaffold is a layout component that provides a material design structure for the screen
                // Modifier.fillMaxSize() is a modifier that makes the composable fill the maximum available size
                UnitConverter(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

// Because the function is composable, it can used any composable function
@Composable
fun UnitConverter(modifier: Modifier) {
    // Remember keyword is a keyword that is used to define a variable that can be changed
    // Mutable state of is a composable function that holds a value and allows the value to be changed
    // We can get straight the value of the text field by using the "by" keyword
    var inputValue by remember { mutableStateOf("")}
    var outputValue by remember { mutableStateOf("")}
    var inputUnit by remember { mutableStateOf("Centimeters")}
    var outputUnit by remember { mutableStateOf("Centimeters")}
    var isDropDownMenuInputExpanded by remember { mutableStateOf(false)}
    var isDropDownMenuOutputExpanded by remember { mutableStateOf(false)}
    var conversionFactor by remember { mutableDoubleStateOf(0.01) }
    var outputConversionFactor  by remember { mutableDoubleStateOf(0.01) }

    fun convertUnits() {
        // ?: is a null coalescing operator that returns the value on the left if it is not null, otherwise it returns the value on the right
        val input = inputValue.toDoubleOrNull() ?: 0.0
        outputValue = (input * conversionFactor / outputConversionFactor).toString()
    }

    Column (
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Unit Converter", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue,
            placeholder = { Text("Enter value") },
            // it is a default parameter that holds the value of the text field
            // it is a lambda that is called when the value of the text field is changed
            onValueChange = {
                inputValue = it
            } ,
            modifier = Modifier.fillMaxWidth(),
            label = {Text("Enter Value")}
        )
        // UI elements are placed in a column
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box{
                Button(onClick = {
                    isDropDownMenuInputExpanded  = true
                }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
                DropdownMenu(expanded = isDropDownMenuInputExpanded, onDismissRequest = { isDropDownMenuInputExpanded = false }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                        inputUnit = "Centimeters"
                        isDropDownMenuInputExpanded = false
                        conversionFactor = 0.01
                    })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        inputUnit = "Meters"
                        isDropDownMenuInputExpanded = false
                        conversionFactor = 1.0
                    })
                    DropdownMenuItem(text = { Text("Feets") }, onClick = {
                        inputUnit = "Feets"
                        isDropDownMenuInputExpanded = false
                        conversionFactor = 0.3048
                    })
                    DropdownMenuItem(text = { Text("Inches") }, onClick = {
                        inputUnit = "Inches"
                        isDropDownMenuInputExpanded = false
                        conversionFactor = 0.0254
                    })
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                // Text is a composable that displays text
                Button(onClick = {
                    isDropDownMenuOutputExpanded = true
                }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
                DropdownMenu(expanded = isDropDownMenuOutputExpanded, onDismissRequest = {
                    isDropDownMenuOutputExpanded = false
                }) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {
                        outputUnit = "Centimeters"
                        isDropDownMenuOutputExpanded = false
                        outputConversionFactor = 0.01
                    })
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {
                        outputUnit = "Meters"
                        isDropDownMenuOutputExpanded = false
                        outputConversionFactor = 1.0
                    })
                    DropdownMenuItem(text = { Text("Feets") }, onClick = {
                        outputUnit = "Feets"
                        isDropDownMenuOutputExpanded = false
                        outputConversionFactor = 0.3048
                    })
                    DropdownMenuItem(text = { Text("Inches") }, onClick = {
                        outputUnit = "Inches"
                        isDropDownMenuOutputExpanded = false
                        outputConversionFactor = 0.0254
                    })
                }
            }
        }

        // context is a variable that holds the current context
        // LocalContext is a composable function that provides the current context
        // val context = LocalContext.current

        // Toast is a message that pops up on the screen
        // Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show()

        // Button is a material design button
        // The onClick parameter is a lambda that is called when the button is clicked
        // Toast is a message that pops up on the screen
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { convertUnits() }) {
            Text("Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Result: $outputValue $outputUnit", style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterAppTheme {
        UnitConverter(modifier = Modifier.fillMaxSize())
    }
}


