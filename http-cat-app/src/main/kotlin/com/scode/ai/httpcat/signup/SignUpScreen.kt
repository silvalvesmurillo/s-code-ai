package com.scode.ai.httpcat.signup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.scode.ai.httpcat.R

private const val TAG = "SignUpScreen"

// Colors from Grocery App UI Kit (Figma)
private val GreenPrimary = Color(0xFF53B175)
private val GrayDisabled = Color(0xFF868889)
private val BackgroundColor = Color(0xFFFFFFFF)
private val FieldBackground = Color(0xFFF2F3F2)
private val LabelColor = Color(0xFF7C7C7C)
private val TextColor = Color(0xFF181725)

/**
 * Sign-up screen that presents a form with 5 fields.
 *
 * The Sign Up button is disabled (gray) until all fields pass validation:
 * - Username: not blank.
 * - Phone: exactly 10 digits matching the Brazilian format `(XX) XXXX-XXXX`.
 * - Email: contains `@`.
 * - Password: not blank.
 * - Confirm Password: not blank and equal to Password.
 *
 * Neither the Sign Up button nor the Log In link trigger navigation; they only emit a log.
 *
 * @param modifier Modifier applied to the root composable.
 */
@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    var formState by remember { mutableStateOf(SignUpFormState()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        SignUpHeader()

        Text(
            text = stringResource(R.string.sign_up_create_account),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Bold,
                color = TextColor
            )
        )

        Text(
            text = stringResource(R.string.sign_up_subtitle),
            style = MaterialTheme.typography.bodyMedium.copy(color = LabelColor)
        )

        SignUpTextField(
            value = formState.name,
            onValueChange = { formState = formState.copy(name = it) },
            label = stringResource(R.string.sign_up_name),
            keyboardType = KeyboardType.Text
        )

        PhoneTextField(
            rawDigits = formState.phone,
            onDigitsChange = { digits -> formState = formState.copy(phone = digits) }
        )

        SignUpTextField(
            value = formState.email,
            onValueChange = { formState = formState.copy(email = it) },
            label = stringResource(R.string.sign_up_email),
            keyboardType = KeyboardType.Email
        )

        PasswordTextField(
            value = formState.password,
            onValueChange = { formState = formState.copy(password = it) },
            label = stringResource(R.string.sign_up_password)
        )

        PasswordTextField(
            value = formState.confirmPassword,
            onValueChange = { formState = formState.copy(confirmPassword = it) },
            label = stringResource(R.string.sign_up_confirm_password)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { Log.d(TAG, "Sign Up button clicked") },
            enabled = formState.isFormValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenPrimary,
                disabledContainerColor = GrayDisabled
            )
        ) {
            Text(
                text = stringResource(R.string.sign_up),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.sign_up_already_account),
                style = MaterialTheme.typography.bodyMedium.copy(color = LabelColor)
            )
            TextButton(onClick = { Log.d(TAG, "Log In clicked") }) {
                Text(
                    text = stringResource(R.string.sign_up_log_in),
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = GreenPrimary
                    )
                )
            }
        }
    }
}

/**
 * Header section with an image placeholder.
 * Replace the emoji with an actual [androidx.compose.foundation.Image] asset when available.
 */
@Composable
private fun SignUpHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(160.dp),
        contentAlignment = Alignment.Center
    ) {
        // Image placeholder — swap for the real asset from the Figma design.
        Text(text = "🛒", fontSize = 80.sp)
    }
}

/**
 * Generic text field following the sign-up design style.
 *
 * @param value Current field value.
 * @param onValueChange Called with the updated value on every keystroke.
 * @param label Field label displayed inside the text field.
 * @param keyboardType Keyboard type hint for the IME.
 * @param modifier Modifier applied to the composable.
 */
@Composable
private fun SignUpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = LabelColor) },
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = GreenPrimary,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = FieldBackground,
            unfocusedContainerColor = FieldBackground
        ),
        singleLine = true
    )
}

/**
 * Phone text field that formats the raw digit input into the Brazilian mask `(XX) XXXX-XXXX`.
 *
 * The formatted value is shown in the field, but only the raw digit string (max 10 chars) is
 * stored in state and passed back via [onDigitsChange].
 *
 * @param rawDigits Current digit-only string (max [SignUpFormState.MAX_PHONE_DIGITS] chars).
 * @param onDigitsChange Called with the updated digit-only string.
 * @param modifier Modifier applied to the composable.
 */
@Composable
private fun PhoneTextField(
    rawDigits: String,
    onDigitsChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = formatBrazilianPhone(rawDigits),
        onValueChange = { input ->
            val digits = input.filter { it.isDigit() }.take(SignUpFormState.MAX_PHONE_DIGITS)
            onDigitsChange(digits)
        },
        label = { Text(text = stringResource(R.string.sign_up_phone), color = LabelColor) },
        placeholder = { Text(text = stringResource(R.string.sign_up_phone_placeholder), color = LabelColor) },
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = GreenPrimary,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = FieldBackground,
            unfocusedContainerColor = FieldBackground
        ),
        singleLine = true
    )
}

/**
 * Password text field with a trailing icon that toggles password visibility.
 *
 * @param value Current password value.
 * @param onValueChange Called with the updated value on every keystroke.
 * @param label Field label displayed inside the text field.
 * @param modifier Modifier applied to the composable.
 */
@Composable
private fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label, color = LabelColor) },
        modifier = modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        trailingIcon = {
            val icon = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            val contentDescription = stringResource(
                if (passwordVisible) R.string.sign_up_password_hide else R.string.sign_up_password_show
            )
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = icon, contentDescription = contentDescription)
            }
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = GreenPrimary,
            unfocusedBorderColor = Color.Transparent,
            focusedContainerColor = FieldBackground,
            unfocusedContainerColor = FieldBackground
        ),
        singleLine = true
    )
}

/**
 * Formats a digit-only string (up to 10 chars) into the Brazilian phone format `(XX) XXXX-XXXX`.
 *
 * Examples:
 * - `""` → `""`
 * - `"62"` → `"(62"`
 * - `"629999"` → `"(62) 9999"`
 * - `"6299991111"` → `"(62) 9999-1111"`
 *
 * @param digits Raw digit characters, at most [SignUpFormState.MAX_PHONE_DIGITS] chars.
 * @return Formatted phone string ready for display.
 */
internal fun formatBrazilianPhone(digits: String): String {
    return when {
        digits.isEmpty() -> ""
        digits.length <= 2 -> "(${digits}"
        digits.length <= 6 -> "(${digits.take(2)}) ${digits.drop(2)}"
        else -> "(${digits.take(2)}) ${digits.drop(2).take(4)}-${digits.drop(6)}"
    }
}

@Preview(showBackground = true, name = "Sign Up Screen - Empty")
@Composable
private fun SignUpScreenEmptyPreview() {
    MaterialTheme {
        SignUpScreen()
    }
}
