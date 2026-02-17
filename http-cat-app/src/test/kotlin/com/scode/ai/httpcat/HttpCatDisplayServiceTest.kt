package com.scode.ai.httpcat

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Unit tests for HttpCatDisplayService using Fake implementation
 */
class HttpCatDisplayServiceTest {
    
    @Test
    fun `getFormattedListing returns formatted output with all statuses`() = runTest {
        // Given
        val availableCodes = setOf(200, 404, 500)
        val fakeService = FakeHttpCatService(availableCodes)
        val displayService = HttpCatDisplayService(fakeService)
        
        // When
        val result = displayService.getFormattedListing()
        
        // Then
        assertTrue(result.contains("HTTP Cat Status Codes"))
        assertTrue(result.contains("https://http.cat/200"))
        assertTrue(result.contains("https://http.cat/404"))
        assertTrue(result.contains("https://http.cat/500"))
        assertTrue(result.contains("HTTP 200"))
        assertTrue(result.contains("HTTP 404"))
        assertTrue(result.contains("HTTP 500"))
        assertTrue(result.contains("Total: 3 status codes found"))
    }
    
    @Test
    fun `getFormattedListing handles empty list`() = runTest {
        // Given
        val fakeService = FakeHttpCatService(emptySet())
        val displayService = HttpCatDisplayService(fakeService)
        
        // When
        val result = displayService.getFormattedListing()
        
        // Then
        assertEquals("No HTTP cat images available.", result)
    }
    
    @Test
    fun `getFormattedListing displays statuses in sorted order`() = runTest {
        // Given
        val availableCodes = setOf(500, 200, 404)
        val fakeService = FakeHttpCatService(availableCodes)
        val displayService = HttpCatDisplayService(fakeService)
        
        // When
        val result = displayService.getFormattedListing()
        
        // Then
        val indexOf200 = result.indexOf("HTTP 200")
        val indexOf404 = result.indexOf("HTTP 404")
        val indexOf500 = result.indexOf("HTTP 500")
        
        assertTrue(indexOf200 < indexOf404, "200 should come before 404")
        assertTrue(indexOf404 < indexOf500, "404 should come before 500")
    }
    
    @Test
    fun `getFormattedListing includes box drawing characters for formatting`() = runTest {
        // Given
        val availableCodes = setOf(200)
        val fakeService = FakeHttpCatService(availableCodes)
        val displayService = HttpCatDisplayService(fakeService)
        
        // When
        val result = displayService.getFormattedListing()
        
        // Then
        assertTrue(result.contains("┌"))
        assertTrue(result.contains("│"))
        assertTrue(result.contains("└"))
        assertTrue(result.contains("─"))
    }
    
    @Test
    fun `getFormattedListing with multiple codes shows correct count`() = runTest {
        // Given
        val availableCodes = setOf(200, 201, 204, 400, 401, 403, 404, 500, 502, 503)
        val fakeService = FakeHttpCatService(availableCodes)
        val displayService = HttpCatDisplayService(fakeService)
        
        // When
        val result = displayService.getFormattedListing()
        
        // Then
        assertTrue(result.contains("Total: 10 status codes found"))
    }
}
