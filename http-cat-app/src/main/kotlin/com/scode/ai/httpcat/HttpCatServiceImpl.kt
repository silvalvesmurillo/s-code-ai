package com.scode.ai.httpcat

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * Real implementation of HttpCatService that makes actual HTTP requests to http.cat
 */
class HttpCatServiceImpl(private val client: HttpClient) : HttpCatService {
    
    companion object {
        private const val BASE_URL = "https://http.cat"
        
        // Common HTTP status codes to check
        private val COMMON_STATUS_CODES = listOf(
            100, 101, 102,
            200, 201, 202, 203, 204, 206, 207,
            300, 301, 302, 303, 304, 305, 307, 308,
            400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 420, 421, 422, 423, 424, 425, 426, 429, 431, 444, 450, 451, 497, 498, 499,
            500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 521, 522, 523, 524, 525, 599
        )
    }
    
    override suspend fun fetchAllStatuses(): List<HttpCatStatus> {
        // For Android, we'll return all known status codes without checking
        // HEAD requests can be slow and the images are almost always available
        return COMMON_STATUS_CODES.map { code ->
            HttpCatStatus(code, "$BASE_URL/$code")
        }
    }
    
    override suspend fun imageExists(code: Int): Boolean {
        return try {
            val response: HttpResponse = client.head("$BASE_URL/$code")
            response.status == HttpStatusCode.OK
        } catch (e: Exception) {
            false
        }
    }
}
