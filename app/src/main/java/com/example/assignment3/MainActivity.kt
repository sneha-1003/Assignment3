package com.example.assignment3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton

import androidx.compose.material3.Text
import androidx.compose.material3.TextField

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreen1()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen1() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedWebsite by remember { mutableStateOf("") }
    val context = LocalContext.current
    val backgroundImage = painterResource(id = R.drawable.background3)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Background image
        Image(
            painter = backgroundImage,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Sign In ",
                style = MaterialTheme.typography.headlineLarge.copy(),
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000080)
            )
            OutlinedTextField(
                value = username,
                onValueChange = { it -> username = it },
                label = { Text(text = "User Name") },
                modifier = Modifier
                    .fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(

                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                    }

                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        selectedWebsite = "Amazon"
                    }
                ) {
                    RadioButton(
                        selected = selectedWebsite == "Amazon",
                        onClick = { selectedWebsite = "Amazon" },
                        modifier = Modifier.padding(4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.amazon),
                        contentDescription = "Sign In to Amazon",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(7.dp)
                    )
                    Text(
                        text = "Amazon",
                        fontSize = 25.sp,
                        color = Color(0xFF000080),
                        fontStyle = FontStyle.Italic,
                    )

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        selectedWebsite = "Myntra"
                    }
                ) {
                    RadioButton(
                        selected = selectedWebsite == "Myntra",
                        onClick = { selectedWebsite = "Myntra" },
                        modifier = Modifier.padding(4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.myntra),
                        contentDescription = "Sign In to Myntra",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(7.dp)
                    )
                    Text(
                        text = "Myntra",
                        fontSize = 25.sp,
                        color = Color(0xFF000080),
                        fontStyle = FontStyle.Italic,)
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        selectedWebsite = "Myntra"
                    }
                ) {
                    RadioButton(
                        selected = selectedWebsite == "Flipkart",
                        onClick = { selectedWebsite = "Flipkart" },
                        modifier = Modifier.padding(4.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.flipkart),
                        contentDescription = "Sign In to Flipkart",
                        modifier = Modifier
                            .size(70.dp)
                            .padding(7.dp)
                    )
                    Text(
                        text = "Flipkart",
                        fontSize = 25.sp,
                        color = Color(0xFF000080),
                        fontStyle = FontStyle.Italic,)
                }

                Spacer(modifier = Modifier.height(28.dp))

                // Button to redirect to the selected website
                Button(
                    onClick = {
                        val websiteUrl = when (selectedWebsite) {
                            "Amazon" -> "https://www.amazon.com"
                            "Myntra" -> "https://www.myntra.com"
                            "Flipkart" -> "https://www.flipkart.com"
                            else -> ""
                        }
                        if (websiteUrl.isNotEmpty()) {
                            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl)))
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Open Website",
                        fontSize = 20.sp)
                }
            }
        }
    }
}
