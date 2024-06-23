package com.mrmxolisi.identityscan

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mrmxolisi.identityscan.ui.theme.IdentityScanTheme

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IdentityScanTheme {
                WelcomeScreen {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(onContinueClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.id_card),
                contentDescription = "App Logo",
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "IdentityScan",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onContinueClicked,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.labelLarge.copy(
                        //fontSize = 18.sp
                    )
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Version 1.0",
            style = MaterialTheme.typography.bodySmall.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    IdentityScanTheme {
        WelcomeScreen {}
    }
}
