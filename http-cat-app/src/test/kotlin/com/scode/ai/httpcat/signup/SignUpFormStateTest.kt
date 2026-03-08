package com.scode.ai.httpcat.signup

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SignUpFormStateTest {

    // region isNameValid

    @Test
    fun `given blank name when validating name then name is invalid`() {
        val state = SignUpFormState(name = "")
        assertFalse(state.isNameValid)
    }

    @Test
    fun `given whitespace-only name when validating name then name is invalid`() {
        val state = SignUpFormState(name = "   ")
        assertFalse(state.isNameValid)
    }

    @Test
    fun `given non-blank name when validating name then name is valid`() {
        val state = SignUpFormState(name = "John Doe")
        assertTrue(state.isNameValid)
    }

    // endregion

    // region isPhoneValid

    @Test
    fun `given phone with exactly 10 digits when validating phone then phone is valid`() {
        val state = SignUpFormState(phone = "6299991111")
        assertTrue(state.isPhoneValid)
    }

    @Test
    fun `given phone with fewer than 10 digits when validating phone then phone is invalid`() {
        val state = SignUpFormState(phone = "629999")
        assertFalse(state.isPhoneValid)
    }

    @Test
    fun `given phone with more than 10 digits when validating phone then phone is invalid`() {
        val state = SignUpFormState(phone = "62999911112")
        assertFalse(state.isPhoneValid)
    }

    @Test
    fun `given empty phone when validating phone then phone is invalid`() {
        val state = SignUpFormState(phone = "")
        assertFalse(state.isPhoneValid)
    }

    // endregion

    // region isEmailValid

    @Test
    fun `given email with at sign when validating email then email is valid`() {
        val state = SignUpFormState(email = "user@example.com")
        assertTrue(state.isEmailValid)
    }

    @Test
    fun `given email with only at sign when validating email then email is valid`() {
        val state = SignUpFormState(email = "@")
        assertTrue(state.isEmailValid)
    }

    @Test
    fun `given email without at sign when validating email then email is invalid`() {
        val state = SignUpFormState(email = "userexample.com")
        assertFalse(state.isEmailValid)
    }

    @Test
    fun `given empty email when validating email then email is invalid`() {
        val state = SignUpFormState(email = "")
        assertFalse(state.isEmailValid)
    }

    // endregion

    // region isPasswordValid

    @Test
    fun `given non-blank password when validating password then password is valid`() {
        val state = SignUpFormState(password = "pass123")
        assertTrue(state.isPasswordValid)
    }

    @Test
    fun `given blank password when validating password then password is invalid`() {
        val state = SignUpFormState(password = "")
        assertFalse(state.isPasswordValid)
    }

    // endregion

    // region isConfirmPasswordValid

    @Test
    fun `given matching non-blank passwords when validating confirm password then confirm is valid`() {
        val state = SignUpFormState(password = "pass123", confirmPassword = "pass123")
        assertTrue(state.isConfirmPasswordValid)
    }

    @Test
    fun `given mismatched passwords when validating confirm password then confirm is invalid`() {
        val state = SignUpFormState(password = "pass123", confirmPassword = "pass456")
        assertFalse(state.isConfirmPasswordValid)
    }

    @Test
    fun `given blank confirm password when validating confirm password then confirm is invalid`() {
        val state = SignUpFormState(password = "pass123", confirmPassword = "")
        assertFalse(state.isConfirmPasswordValid)
    }

    // endregion

    // region isFormValid

    @Test
    fun `given all valid fields when validating form then form is valid`() {
        val state = SignUpFormState(
            name = "John Doe",
            phone = "6299991111",
            email = "john@example.com",
            password = "pass123",
            confirmPassword = "pass123"
        )
        assertTrue(state.isFormValid)
    }

    @Test
    fun `given invalid name when validating form then form is invalid`() {
        val state = SignUpFormState(
            name = "",
            phone = "6299991111",
            email = "john@example.com",
            password = "pass123",
            confirmPassword = "pass123"
        )
        assertFalse(state.isFormValid)
    }

    @Test
    fun `given invalid phone when validating form then form is invalid`() {
        val state = SignUpFormState(
            name = "John Doe",
            phone = "12345",
            email = "john@example.com",
            password = "pass123",
            confirmPassword = "pass123"
        )
        assertFalse(state.isFormValid)
    }

    @Test
    fun `given invalid email when validating form then form is invalid`() {
        val state = SignUpFormState(
            name = "John Doe",
            phone = "6299991111",
            email = "johnexample.com",
            password = "pass123",
            confirmPassword = "pass123"
        )
        assertFalse(state.isFormValid)
    }

    @Test
    fun `given invalid password when validating form then form is invalid`() {
        val state = SignUpFormState(
            name = "John Doe",
            phone = "6299991111",
            email = "john@example.com",
            password = "",
            confirmPassword = ""
        )
        assertFalse(state.isFormValid)
    }

    @Test
    fun `given mismatched confirm password when validating form then form is invalid`() {
        val state = SignUpFormState(
            name = "John Doe",
            phone = "6299991111",
            email = "john@example.com",
            password = "pass123",
            confirmPassword = "different"
        )
        assertFalse(state.isFormValid)
    }

    @Test
    fun `given default form state when validating form then form is invalid`() {
        val state = SignUpFormState()
        assertFalse(state.isFormValid)
    }

    // endregion
}
