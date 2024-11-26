package my.id.cupcakez.unitconverterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Text("Unit Converter")
        OutlinedTextField(
            value = "",
            placeholder = { Text("Enter value") },
            onValueChange = {
            // here hoes what shsould happen when the value changes }
            } ,
            modifier = Modifier.fillMaxWidth()
        )
        // UI elements are placed in a column
        Row {

        }

        Text("Result : ")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterAppTheme {
        UnitConverter(modifier = Modifier.fillMaxSize())
    }
}