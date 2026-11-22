package com.pabi.splitsmart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*
 * The UI is FINISHED on purpose — you don't touch this file to solve the
 * challenges. All the "math brain" lives in Calculator.kt (YOUR file).
 *
 * Read this later and notice two things:
 *  1. `remember { mutableStateOf(...) }` = "a value the screen remembers;
 *     when it changes, redraw" — that's the core idea of Compose.
 *  2. The results you see on screen come from calling Calculator.* —
 *     your code IS this app's brain.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SplitScreen()
                }
            }
        }
    }
}

@Composable
fun SplitScreen() {
    // Screen state: the bill text, the tip %, and the number of people.
    var billText by remember { mutableStateOf("500") }
    var tipPercent by remember { mutableStateOf(10.0) }
    var people by remember { mutableStateOf(4) }

    // "500" → 500.0, but "abc" → null. That's Kotlin null-safety in action.
    val bill = billText.toDoubleOrNull()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("SplitSmart", fontSize = 32.sp, fontWeight = FontWeight.Bold)
        Text(
            "Split any bill with friends — with a tip.",
            style = MaterialTheme.typography.bodyMedium
        )

        OutlinedTextField(
            value = billText,
            onValueChange = { billText = it },
            label = { Text("Bill amount (₹)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Text("Tip: ${tipPercent.toInt()}%", fontSize = 20.sp)
        Slider(
            value = tipPercent.toFloat(),
            onValueChange = { tipPercent = it.toDouble() },
            valueRange = 0f..50f
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(onClick = { if (people > 1) people-- }) { Text("−") }
            Text("$people people", fontSize = 20.sp)
            Button(onClick = { people++ }) { Text("+") }
        }

        if (bill != null) {
            // ── These two lines call YOUR functions. ──
            val tip = Calculator.tipAmount(bill, tipPercent.toInt())
            val perPerson = Calculator.totalPerPerson(bill, tipPercent.toInt(), people)

            Text("Tip: ₹%.2f".format(tip), fontSize = 22.sp)
            Text(
                "Per person: ₹%.2f".format(perPerson),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        } else {
            Text("Type a number above to see the split.", style = MaterialTheme.typography.bodySmall)
        }
    }
}
