package com.unovil.tardyscan.presentation.feature.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.unovil.tardyscan.R
import com.unovil.tardyscan.presentation.common.AuthorizeButton
import com.unovil.tardyscan.presentation.common.PasswordTextField

@Composable
fun SignIn(
    viewModel: SignInViewModel? = hiltViewModel(),
    email: State<String> = viewModel!!.email.collectAsState(),
    password: State<String> = viewModel!!.password.collectAsState(),
    signInErrorMessage: State<String> = viewModel!!.signInErrorMessage.collectAsState(),
    isSuccessfulSignIn: State<Boolean> = viewModel!!.isSuccessfulSignIn.collectAsState(),
    onEmailChange: (String) -> Unit = { viewModel?.onEmailChange(it) },
    onPasswordChange: (String) -> Unit = { viewModel?.onPasswordChange(it) },
    onSignIn: () -> Unit = { viewModel?.onSignIn() },
    onSuccess: () -> Unit,
    onSwitchToSignUp: () -> Unit
) {
    LaunchedEffect(isSuccessfulSignIn.value) {
        if (isSuccessfulSignIn.value) onSuccess()
    }

    Column(
        modifier = Modifier.width(IntrinsicSize.Min),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "Sign in",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = email.value,
            onValueChange = onEmailChange,
            label = { Text(stringResource(R.string.email_address)) },
            placeholder = { Text(stringResource(R.string.email_address)) }
        )

        PasswordTextField(
            value = password.value,
            onValueChange = onPasswordChange
        )

        Text(
            text = signInErrorMessage.value,
            color = MaterialTheme.colorScheme.error,
            style = MaterialTheme.typography.bodySmall
        )

        AuthorizeButton(
            enabled = (password.value.isNotBlank() && email.value.isNotBlank()),
            buttonText = stringResource(R.string.sign_in)
        ) {
            onSignIn()
        }

        TextButton(onClick = onSwitchToSignUp) {
            Text(
                text = stringResource(R.string.switch_to_sign_up),
                textDecoration = TextDecoration.Underline
            )
        }
    }
}

@Preview(name = "SignIn", showSystemUi = true)
@Composable
fun SignInPreview() {
    SignIn(
        viewModel = null,
        onSuccess = { },
        onSwitchToSignUp = { }
    )
}