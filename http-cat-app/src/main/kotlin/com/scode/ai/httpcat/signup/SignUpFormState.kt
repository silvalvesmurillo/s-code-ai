package com.scode.ai.httpcat.signup

/**
 * Holds the state of the sign-up form and provides validation logic for each field.
 *
 * All validation is computed as derived properties so the form never holds invalid data.
 * The [phone] field is expected to contain digits only (non-digit characters are stripped
 * before being stored here).
 *
 * @property name Full name entered by the user.
 * @property phone Brazilian phone digits only (max [MAX_PHONE_DIGITS] chars).
 * @property email Email address entered by the user.
 * @property password Password entered by the user.
 * @property confirmPassword Password confirmation entered by the user.
 */
data class SignUpFormState(
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
) {

    /** Returns `true` when [name] is not blank. */
    val isNameValid: Boolean
        get() = name.isNotBlank()

    /**
     * Returns `true` when [phone] contains exactly [PHONE_DIGIT_COUNT] digits,
     * matching the Brazilian format `(XX) XXXX-XXXX`.
     */
    val isPhoneValid: Boolean
        get() = phone.filter { it.isDigit() }.length == PHONE_DIGIT_COUNT

    /**
     * Returns `true` when [email] contains the `@` character.
     * This is a minimal validation that covers the basic format requirement.
     */
    val isEmailValid: Boolean
        get() = email.contains("@")

    /** Returns `true` when [password] is not blank. */
    val isPasswordValid: Boolean
        get() = password.isNotBlank()

    /**
     * Returns `true` when [confirmPassword] is not blank and equals [password].
     */
    val isConfirmPasswordValid: Boolean
        get() = confirmPassword.isNotBlank() && confirmPassword == password

    /**
     * Returns `true` when every individual field validation passes.
     * Only when this is `true` should the Sign Up button be enabled.
     */
    val isFormValid: Boolean
        get() = isNameValid &&
            isPhoneValid &&
            isEmailValid &&
            isPasswordValid &&
            isConfirmPasswordValid

    companion object {
        /** Number of digits required for a valid Brazilian phone number `(XX) XXXX-XXXX`. */
        const val PHONE_DIGIT_COUNT = 10

        /** Maximum number of digit characters accepted in [phone]. */
        const val MAX_PHONE_DIGITS = 10
    }
}
