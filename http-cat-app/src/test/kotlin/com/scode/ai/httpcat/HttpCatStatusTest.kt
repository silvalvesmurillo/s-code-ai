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
