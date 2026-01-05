package com.limbu.dict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This detects if your phone is in Dark Mode and changes colors
            val isDark = isSystemInDarkTheme()
            val colorScheme = if (isDark) darkColorScheme() else lightColorScheme()
            
            // Define your Limbu Font
            val limbuFont = FontFamily(Font(R.font.noto_sans_limbu))

            MaterialTheme(colorScheme = colorScheme) {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    DictionaryApp(limbuFont)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryApp(limbuFont: FontFamily) {
    var searchQuery by remember { mutableStateOf("") }
    
    // In a full version, we'd load JSON here. For now, this is the UI structure.
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Limbu Dictionary") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search word...") },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                shape = androidx.compose.foundation.shape.CircleShape
            )
            
            // This displays a list of words
            LazyColumn {
                item {
                    Card(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            // Limbu Word using custom font
                            Text(
                                text = "ᤁᤠᤂᤡ", 
                                fontFamily = limbuFont, 
                                fontSize = 32.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "Meaning: Example definition here", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}
