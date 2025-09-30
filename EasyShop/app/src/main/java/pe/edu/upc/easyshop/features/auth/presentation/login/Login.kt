package pe.edu.upc.easyshop.features.auth.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import pe.edu.upc.easyshop.R
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme

@Composable
fun Login(
    viewModel: LoginViewModel = hiltViewModel(),
    onSubmit: () -> Unit
) {

    val username = viewModel.username.collectAsState()
    val password = viewModel.password.collectAsState()
    val isVisible = viewModel.isVisible.collectAsState()
    val user = viewModel.user.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = username.value,
            onValueChange = {
                viewModel.updateUsername(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = null)
            },
            placeholder = {
                Text(stringResource(R.string.placeholder_username))
            }
        )

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                viewModel.updatePassword(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = null
                )
            },
            placeholder = {
                Text(stringResource(R.string.placeholder_password))
            },
            visualTransformation = if (isVisible.value) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        viewModel.toggleVisible()
                    }
                ) {
                    Icon(
                        if (isVisible.value) {
                            Icons.Default.Visibility
                        } else {
                            Icons.Default.VisibilityOff
                        },
                        contentDescription = null
                    )
                }
            }
        )

        Button(
            onClick = {
                viewModel.login()
                onSubmit()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Login")
        }

        user.value?.let {
            Text(it.name)
        }

    }
}

@Preview
@Composable
fun LoginPreview() {
    EasyShopTheme {
        Login {}
    }

}