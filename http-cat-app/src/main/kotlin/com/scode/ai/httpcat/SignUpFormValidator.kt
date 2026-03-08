package com.scode.ai.httpcat

/**
 * Validator for the sign-up form fields.
 * Provides individual field validation and full form validation.
 */
object SignUpFormValidator {

    private const val MIN_PHONE_DIGITS = 10
    private const val MAX_PHONE_DIGITS = 11

    /**
     * Validates the full name field.
     * @param name The name input.
     * @return true if the name is not blank.
     */
    fun isNameValid(name: String): Boolean = name.isNotBlank()

    /**
     * Validates the email field.
     * @param email The email input.
     * @return true if the email contains "@".
     */
    fun isEmailValid(email: String): Boolean = email.contains("@")

    /**
     * Validates the phone field for Brazilian territory.
     * Accepts 10 digits (landline) or 11 digits (mobile) including DDD.
     * @param phone Raw digits of the phone number.
     * @return true if the phone has 10 or 11 digits.
     */
    fun isPhoneValid(phone: String): Boolean {
        val digits = phone.filter { it.isDigit() }
        return digits.length in MIN_PHONE_DIGITS..MAX_PHONE_DIGITS
    }

    /**
     * Validates the password field.
     * @param password The password input.
     * @return true if the password is not blank.
     */
    fun isPasswordValid(password: String): Boolean = password.isNotBlank()

    /**
     * Validates that the confirm password matches the password.
     * @param password The password input.
     * @param confirmPassword The confirm password input.
     * @return true if both are not blank and match.
     */
    fun doPasswordsMatch(password: String, confirmPassword: String): Boolean =
        password.isNotBlank() && confirmPassword == password

    /**
     * Validates the entire sign-up form.
     * @param name The full name input.
     * @param email The email input.
     * @param phone Raw digits of the phone number.
     * @param password The password input.
     * @param confirmPassword The confirm password input.
     * @return true if all fields are valid.
     */
    fun isFormValid(
        name: String,
        email: String,
        phone: String,
        password: String,
        confirmPassword: String
    ): Boolean =
        isNameValid(name) &&
            isEmailValid(email) &&
            isPhoneValid(phone) &&
            isPasswordValid(password) &&
            doPasswordsMatch(password, confirmPassword)
}
