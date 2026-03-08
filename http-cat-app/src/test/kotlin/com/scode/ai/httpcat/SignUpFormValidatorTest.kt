package com.scode.ai.httpcat

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Unit tests for [SignUpFormValidator].
 */
class SignUpFormValidatorTest {

    // region Name validation

    @Test
    fun `Given a non-blank name When validating name Then returns true`() {
        assertTrue(SignUpFormValidator.isNameValid("Smith Mate"))
    }

    @Test
    fun `Given a blank name When validating name Then returns false`() {
        assertFalse(SignUpFormValidator.isNameValid(""))
    }

    @Test
    fun `Given a whitespace-only name When validating name Then returns false`() {
        assertFalse(SignUpFormValidator.isNameValid("   "))
    }

    // endregion

    // region Email validation

    @Test
    fun `Given an email with at sign When validating email Then returns true`() {
        assertTrue(SignUpFormValidator.isEmailValid("user@example.com"))
    }

    @Test
    fun `Given an email without at sign When validating email Then returns false`() {
        assertFalse(SignUpFormValidator.isEmailValid("userexample.com"))
    }

    @Test
    fun `Given an empty email When validating email Then returns false`() {
        assertFalse(SignUpFormValidator.isEmailValid(""))
    }

    @Test
    fun `Given a minimal email with at sign When validating email Then returns true`() {
        assertTrue(SignUpFormValidator.isEmailValid("a@b"))
    }

    // endregion

    // region Phone validation

    @Test
    fun `Given 11 digits When validating phone Then returns true`() {
        assertTrue(SignUpFormValidator.isPhoneValid("62999991111"))
    }

    @Test
    fun `Given 10 digits When validating phone Then returns true`() {
        assertTrue(SignUpFormValidator.isPhoneValid("6299991111"))
    }

    @Test
    fun `Given 9 digits When validating phone Then returns false`() {
        assertFalse(SignUpFormValidator.isPhoneValid("629999111"))
    }

    @Test
    fun `Given 12 digits When validating phone Then returns false`() {
        assertFalse(SignUpFormValidator.isPhoneValid("629999111122"))
    }

    @Test
    fun `Given empty phone When validating phone Then returns false`() {
        assertFalse(SignUpFormValidator.isPhoneValid(""))
    }

    // endregion

    // region Password validation

    @Test
    fun `Given a non-blank password When validating password Then returns true`() {
        assertTrue(SignUpFormValidator.isPasswordValid("secret123"))
    }

    @Test
    fun `Given an empty password When validating password Then returns false`() {
        assertFalse(SignUpFormValidator.isPasswordValid(""))
    }

    @Test
    fun `Given a whitespace-only password When validating password Then returns false`() {
        assertFalse(SignUpFormValidator.isPasswordValid("   "))
    }

    // endregion

    // region Passwords match

    @Test
    fun `Given matching passwords When checking match Then returns true`() {
        assertTrue(SignUpFormValidator.doPasswordsMatch("secret", "secret"))
    }

    @Test
    fun `Given different passwords When checking match Then returns false`() {
        assertFalse(SignUpFormValidator.doPasswordsMatch("secret", "other"))
    }

    @Test
    fun `Given empty password When checking match Then returns false`() {
        assertFalse(SignUpFormValidator.doPasswordsMatch("", ""))
    }

    @Test
    fun `Given empty confirm password When checking match Then returns false`() {
        assertFalse(SignUpFormValidator.doPasswordsMatch("secret", ""))
    }

    // endregion

    // region Full form validation

    @Test
    fun `Given all valid fields When validating form Then returns true`() {
        assertTrue(
            SignUpFormValidator.isFormValid(
                name = "Smith Mate",
                email = "smith@example.com",
                phone = "62999991111",
                password = "secret123",
                confirmPassword = "secret123"
            )
        )
    }

    @Test
    fun `Given invalid name When validating form Then returns false`() {
        assertFalse(
            SignUpFormValidator.isFormValid(
                name = "",
                email = "smith@example.com",
                phone = "62999991111",
                password = "secret123",
                confirmPassword = "secret123"
            )
        )
    }

    @Test
    fun `Given invalid email When validating form Then returns false`() {
        assertFalse(
            SignUpFormValidator.isFormValid(
                name = "Smith Mate",
                email = "smithexample.com",
                phone = "62999991111",
                password = "secret123",
                confirmPassword = "secret123"
            )
        )
    }

    @Test
    fun `Given invalid phone When validating form Then returns false`() {
        assertFalse(
            SignUpFormValidator.isFormValid(
                name = "Smith Mate",
                email = "smith@example.com",
                phone = "123",
                password = "secret123",
                confirmPassword = "secret123"
            )
        )
    }

    @Test
    fun `Given mismatched passwords When validating form Then returns false`() {
        assertFalse(
            SignUpFormValidator.isFormValid(
                name = "Smith Mate",
                email = "smith@example.com",
                phone = "62999991111",
                password = "secret123",
                confirmPassword = "different"
            )
        )
    }

    @Test
    fun `Given 10 digit landline phone When validating form Then returns true`() {
        assertTrue(
            SignUpFormValidator.isFormValid(
                name = "Smith Mate",
                email = "smith@example.com",
                phone = "6299991111",
                password = "secret123",
                confirmPassword = "secret123"
            )
        )
    }

    // endregion

    // region Brazilian phone visual transformation

    @Test
    fun `Given 11 digit phone When formatting Then returns mobile format`() {
        val transformation = BrazilianPhoneVisualTransformation()
        val result = transformation.filter(
            androidx.compose.ui.text.AnnotatedString("62999991111")
        )
        kotlin.test.assertEquals("(62) 99999-1111", result.text.text)
    }

    @Test
    fun `Given 10 digit phone When formatting Then returns landline format`() {
        val transformation = BrazilianPhoneVisualTransformation()
        val result = transformation.filter(
            androidx.compose.ui.text.AnnotatedString("6299991111")
        )
        kotlin.test.assertEquals("(62) 9999-1111", result.text.text)
    }

    @Test
    fun `Given partial phone input When formatting Then returns partial mask`() {
        val transformation = BrazilianPhoneVisualTransformation()
        val result = transformation.filter(
            androidx.compose.ui.text.AnnotatedString("629")
        )
        kotlin.test.assertEquals("(62) 9", result.text.text)
    }

    @Test
    fun `Given empty phone input When formatting Then returns empty string`() {
        val transformation = BrazilianPhoneVisualTransformation()
        val result = transformation.filter(
            androidx.compose.ui.text.AnnotatedString("")
        )
        kotlin.test.assertEquals("", result.text.text)
    }

    // endregion
}
