package com.scode.ai.httpcat

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private const val TAG = "SignUpScreen"
private val SignUpGreen = Color(0xFF53B175)
private val DisabledGray = Color(0xFFC5C5C5)
private val FieldBorderColor = Color(0xFFE2E2E2)
private val SubtitleColor = Color(0xFF7C7C7C)
private val FieldShape = RoundedCornerShape(16.dp)
private const val MAX_PHONE_DIGITS = 11

/**
 * Sign-up screen composable that displays a registration form with
 * name, email, phone (Brazilian mask), password, and confirm password fields.
 * The Signup button is enabled only when all validations pass.
 */
@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val isFormValid by remember {
        derivedStateOf {
            SignUpFormValidator.isFormValid(name, email, phone, password, confirmPassword)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        SignUpLogo()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = stringResource(R.string.sign_up_create_account),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.sign_up_subtitle),
            fontSize = 14.sp,
            color = SubtitleColor,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        SignUpTextField(
            value = name,
            placeholder = stringResource(R.string.sign_up_name),
            onValueChange = { name = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        SignUpTextField(
            value = email,
            placeholder = stringResource(R.string.sign_up_email),
            onValueChange = { email = it },
            keyboardType = KeyboardType.Email
        )

        Spacer(modifier = Modifier.height(16.dp))

        PhoneTextField(
            value = phone,
            onValueChange = { digits ->
                if (digits.length <= MAX_PHONE_DIGITS && digits.all { it.isDigit() }) {
                    phone = digits
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordTextField(
            value = password,
            placeholder = stringResource(R.string.sign_up_password),
            isVisible = passwordVisible,
            onToggleVisibility = { passwordVisible = !passwordVisible },
            onValueChange = { password = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        PasswordTextField(
            value = confirmPassword,
            placeholder = stringResource(R.string.sign_up_confirm_password),
            isVisible = confirmPasswordVisible,
            onToggleVisibility = { confirmPasswordVisible = !confirmPasswordVisible },
            onValueChange = { confirmPassword = it }
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { Log.d(TAG, "Signup button clicked") },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = isFormValid,
            shape = RoundedCornerShape(18.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = SignUpGreen,
                disabledContainerColor = DisabledGray
            )
        ) {
            Text(
                text = stringResource(R.string.sign_up),
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.sign_up_already_account),
                fontSize = 14.sp,
                color = SubtitleColor
            )
            Text(
                text = stringResource(R.string.sign_up_log_in),
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = SignUpGreen,
                modifier = Modifier.clickable {
                    Log.d(TAG, "Log In text clicked")
                }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

/**
 * Placeholder logo composable matching the Figma green "R" design.
 * Replace with actual image resource when available.
 */
@Composable
private fun SignUpLogo(modifier: Modifier = Modifier) {
    Text(
        text = "R",
        modifier = modifier.size(80.dp),
        fontSize = 56.sp,
        fontWeight = FontWeight.Bold,
        color = SignUpGreen,
        textAlign = TextAlign.Center
    )
}

/**
 * Standard text field for the sign-up form with rounded border styling.
 */
@Composable
private fun SignUpTextField(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder, color = SubtitleColor) },
        singleLine = true,
        shape = FieldShape,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = FieldBorderColor,
            focusedBorderColor = SignUpGreen
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

/**
 * Phone text field with Brazilian phone mask visual transformation.
 * Accepts only digits and limits to [MAX_PHONE_DIGITS] characters.
 */
@Composable
private fun PhoneTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = stringResource(R.string.sign_up_phone_placeholder),
                color = SubtitleColor
            )
        },
        singleLine = true,
        shape = FieldShape,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = FieldBorderColor,
            focusedBorderColor = SignUpGreen
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = BrazilianPhoneVisualTransformation()
    )
}

/**
 * Password text field with show/hide toggle icon.
 */
@Composable
private fun PasswordTextField(
    value: String,
    placeholder: String,
    isVisible: Boolean,
    onToggleVisibility: () -> Unit,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = placeholder, color = SubtitleColor) },
        singleLine = true,
        shape = FieldShape,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = FieldBorderColor,
            focusedBorderColor = SignUpGreen
        ),
        visualTransformation = if (isVisible) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButton(onClick = onToggleVisibility) {
                Icon(
                    imageVector = if (isVisible) {
                        Icons.Filled.Visibility
                    } else {
                        Icons.Filled.VisibilityOff
                    },
                    contentDescription = if (isVisible) {
                        stringResource(R.string.sign_up_password_hide)
                    } else {
                        stringResource(R.string.sign_up_password_show)
                    },
                    tint = SubtitleColor
                )
            }
        }
    )
}

/**
 * VisualTransformation that formats raw digits into Brazilian phone format.
 * - 10 digits (landline): (XX) XXXX-XXXX
 * - 11 digits (mobile):   (XX) XXXXX-XXXX
 */
class BrazilianPhoneVisualTransformation : VisualTransformation {

    override fun filter(text: AnnotatedString): TransformedText {
        val raw = text.text
        val mask = if (raw.length > 10) "(##) #####-####" else "(##) ####-####"

        val result = StringBuilder()
        val originalToTransformedOffsets = IntArray(raw.length + 1)
        val transformedToOriginalOffsets = mutableListOf<Int>()
        var rawIndex = 0

        for (maskChar in mask) {
            if (rawIndex >= raw.length) break

            if (maskChar == '#') {
                originalToTransformedOffsets[rawIndex] = result.length
                result.append(raw[rawIndex])
                transformedToOriginalOffsets.add(rawIndex)
                rawIndex++
            } else {
                result.append(maskChar)
                transformedToOriginalOffsets.add(rawIndex)
            }
        }

        originalToTransformedOffsets[rawIndex] = result.length
        transformedToOriginalOffsets.add(rawIndex)

        val formattedLength = result.length
        val rawLength = raw.length
        val transToOrigArray = transformedToOriginalOffsets.toIntArray()

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int =
                originalToTransformedOffsets[offset.coerceIn(0, rawLength)]

            override fun transformedToOriginal(offset: Int): Int =
                transToOrigArray[offset.coerceIn(0, formattedLength)]
        }

        return TransformedText(AnnotatedString(result.toString()), offsetMapping)
    }
}
