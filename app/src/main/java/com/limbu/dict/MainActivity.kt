package com.limbu.dict

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme { // Automatically handles Dark/Light mode
                DictionaryScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryScreen() {
    var searchQuery by remember { mutableStateOf("") }
    
    // This is where your dictionary list will live
    Scaffold(
        topBar = {
            TextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                placeholder = { Text("Search Limbu...") }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text("Search results will appear here", modifier = Modifier.padding(16.dp))
        }
    }
}
