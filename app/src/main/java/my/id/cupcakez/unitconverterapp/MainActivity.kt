package my.id.cupcakez.unitconverterapp

import android.os.Bundle
import android.widget.Space
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Unit Converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = "",
            placeholder = { Text("Enter value") },
            onValueChange = {
            // here hoes what should happen when the value changes }
            } ,
            modifier = Modifier.fillMaxWidth()
        )
        // UI elements are placed in a column
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Box{
                Button(onClick = {}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
                DropdownMenu(expanded = false, onDismissRequest = {}) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {})
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {})
                    DropdownMenuItem(text = { Text("Feets") }, onClick = {})
                    DropdownMenuItem(text = { Text("Inches") }, onClick = {})
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                // Text is a composable that displays text
                Button(onClick = {}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "Select")
                }
                DropdownMenu(expanded = false, onDismissRequest = {}) {
                    DropdownMenuItem(text = { Text("Centimeters") }, onClick = {})
                    DropdownMenuItem(text = { Text("Meters") }, onClick = {})
                    DropdownMenuItem(text = { Text("Feets") }, onClick = {})
                    DropdownMenuItem(text = { Text("Inches") }, onClick = {})
                }
            }
            
        }
//        // context is a variable that holds the current context
//        val context = LocalContext.current
//
//        // Button is a material design button
//        // The onClick parameter is a lambda that is called when the button is clicked
//        // Toast is a message that pops up on the screen
//        Button(onClick = { Toast.makeText(context, "Thanks for clicking", Toast.LENGTH_LONG).show() }) {
//            Text("Click Me")
//        }
//        Text("Result : ")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterAppTheme {
        UnitConverter(modifier = Modifier.fillMaxSize())
    }
}