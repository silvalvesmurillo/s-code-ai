package com.scode.ai.httpcat

/**
 * Fake implementation of HttpCatService for testing purposes
 * This is a test double that doesn't make actual HTTP requests
 */
class FakeHttpCatService(
    private val availableCodes: Set<Int> = setOf(200, 201, 204, 400, 401, 403, 404, 500, 502, 503)
) : HttpCatService {
    
    private val baseUrl = "https://http.cat"
    
    override suspend fun fetchAllStatuses(): List<HttpCatStatus> {
        return availableCodes
            .sorted()
            .map { code -> HttpCatStatus(code, "$baseUrl/$code") }
    }
    
    override suspend fun imageExists(code: Int): Boolean {
        return code in availableCodes
    }
}
