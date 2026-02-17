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
}
