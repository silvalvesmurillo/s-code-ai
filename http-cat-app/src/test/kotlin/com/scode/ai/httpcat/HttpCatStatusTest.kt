package com.scode.ai.httpcat

import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit tests for HttpCatStatus data class
 */
class HttpCatStatusTest {
    
    @Test
    fun `getDisplayText returns formatted HTTP code`() {
        // Given
        val status = HttpCatStatus(200, "https://http.cat/200")
        
        // When
        val result = status.getDisplayText()
        
        // Then
        assertEquals("HTTP 200", result)
    }
    
    @Test
    fun `getDisplayText works with different status codes`() {
        // Given & When & Then
        assertEquals("HTTP 404", HttpCatStatus(404, "url").getDisplayText())
        assertEquals("HTTP 500", HttpCatStatus(500, "url").getDisplayText())
        assertEquals("HTTP 201", HttpCatStatus(201, "url").getDisplayText())
    }
    
    @Test
    fun `HttpCatStatus data class equality`() {
        // Given
        val status1 = HttpCatStatus(200, "https://http.cat/200")
        val status2 = HttpCatStatus(200, "https://http.cat/200")
        val status3 = HttpCatStatus(404, "https://http.cat/404")
        
        // When & Then
        assertEquals(status1, status2)
        assert(status1 != status3)
    }
    
    @Test
    fun `Given informational code When getStatusCategory Then returns Informational`() {
        // Given
        val status = HttpCatStatus(100, "https://http.cat/100")

        // When
        val result = status.getStatusCategory()

        // Then
        assertEquals("Informational", result)
    }

    @Test
    fun `Given success code When getStatusCategory Then returns Success`() {
        // Given & When & Then
        assertEquals("Success", HttpCatStatus(200, "url").getStatusCategory())
        assertEquals("Success", HttpCatStatus(201, "url").getStatusCategory())
    }

    @Test
    fun `Given redirection code When getStatusCategory Then returns Redirection`() {
        assertEquals("Redirection", HttpCatStatus(301, "url").getStatusCategory())
    }

    @Test
    fun `Given client error code When getStatusCategory Then returns Client Error`() {
        assertEquals("Client Error", HttpCatStatus(404, "url").getStatusCategory())
    }

    @Test
    fun `Given server error code When getStatusCategory Then returns Server Error`() {
        assertEquals("Server Error", HttpCatStatus(500, "url").getStatusCategory())
    }

    @Test
    fun `Given unknown code When getStatusCategory Then returns Unknown`() {
        assertEquals("Unknown", HttpCatStatus(600, "url").getStatusCategory())
        assertEquals("Unknown", HttpCatStatus(0, "url").getStatusCategory())
    }

    @Test
    fun `HttpCatStatus copy works correctly`() {
        // Given
        val original = HttpCatStatus(200, "https://http.cat/200")
        
        // When
        val copy = original.copy(code = 404)
        
        // Then
        assertEquals(404, copy.code)
        assertEquals("https://http.cat/200", copy.imageUrl)
        assertEquals(200, original.code)
    }
}
