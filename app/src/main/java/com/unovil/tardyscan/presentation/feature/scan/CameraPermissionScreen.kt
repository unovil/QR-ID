package com.unovil.tardyscan.presentation.feature.scan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unovil.tardyscan.R

@Preview
@Composable
fun CameraPermissionScreen(onClick: () -> Unit = { }) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(R.string.camera_permissions_needed_title),
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(20.dp)
            )
            Text(
                stringResource(R.string.camera_permissions_needed_explanation),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 40.dp)
            )
            Button (
                onClick = onClick,
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Text(stringResource(R.string.grant_permission))
            }
        }
    }
}