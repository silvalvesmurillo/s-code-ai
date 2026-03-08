package com.scode.ai.httpcat

/**
 * Represents an HTTP status code with its image URL
 */
data class HttpCatStatus(
    val code: Int,
    val imageUrl: String
) {
    /**
     * Returns the display text for this status
     */
    fun getDisplayText(): String = "HTTP $code"

    /**
     * Returns the category description for this HTTP status code.
     *
     * Categories follow the HTTP specification:
     * - 1xx: Informational
     * - 2xx: Success
     * - 3xx: Redirection
     * - 4xx: Client Error
     * - 5xx: Server Error
     *
     * @return the category name, or "Unknown" for codes outside the standard ranges
     */
    fun getStatusCategory(): String = when (code / 100) {
        1 -> "Informational"
        2 -> "Success"
        3 -> "Redirection"
        4 -> "Client Error"
        5 -> "Server Error"
        else -> "Unknown"
    }
}
