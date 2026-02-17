package com.scode.ai.httpcat

/**
 * Service responsible for displaying HTTP cat statuses
 */
class HttpCatDisplayService(private val httpCatService: HttpCatService) {
    
    /**
     * Fetches and formats the listing of HTTP cat statuses
     * @return A formatted string with all statuses
     */
    suspend fun getFormattedListing(): String {
        val statuses = httpCatService.fetchAllStatuses()
        
        if (statuses.isEmpty()) {
            return "No HTTP cat images available."
        }
        
        val builder = StringBuilder()
        builder.appendLine("HTTP Cat Status Codes")
        builder.appendLine("=".repeat(50))
        builder.appendLine()
        
        statuses.forEach { status ->
            builder.appendLine("┌${"─".repeat(48)}┐")
            builder.appendLine("│ Image: ${status.imageUrl.padEnd(42)}│")
            builder.appendLine("│ Code:  ${status.getDisplayText().padEnd(42)}│")
            builder.appendLine("└${"─".repeat(48)}┘")
            builder.appendLine()
        }
        
        builder.appendLine("Total: ${statuses.size} status codes found")
        
        return builder.toString()
    }
}
