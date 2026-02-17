package com.scode.ai.httpcat

/**
 * Service interface for fetching HTTP cat images
 */
interface HttpCatService {
    /**
     * Fetches a list of all available HTTP status codes with their image URLs
     * @return List of HttpCatStatus objects
     */
    suspend fun fetchAllStatuses(): List<HttpCatStatus>
    
    /**
     * Checks if an image exists for a given HTTP status code
     * @param code The HTTP status code to check
     * @return true if the image exists, false otherwise
     */
    suspend fun imageExists(code: Int): Boolean
}
