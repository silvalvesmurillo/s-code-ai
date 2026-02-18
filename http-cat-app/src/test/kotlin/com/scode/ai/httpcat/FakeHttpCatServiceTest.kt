package com.scode.ai.httpcat

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Unit tests for FakeHttpCatService
 */
class FakeHttpCatServiceTest {
    
    @Test
    fun `fetchAllStatuses returns sorted list of available codes`() = runTest {
        // Given
        val availableCodes = setOf(500, 200, 404, 201)
        val service = FakeHttpCatService(availableCodes)
        
        // When
        val result = service.fetchAllStatuses()
        
        // Then
        assertEquals(4, result.size)
        assertEquals(200, result[0].code)
        assertEquals(201, result[1].code)
        assertEquals(404, result[2].code)
        assertEquals(500, result[3].code)
    }
    
    @Test
    fun `fetchAllStatuses returns correct image URLs`() = runTest {
        // Given
        val availableCodes = setOf(200, 404)
        val service = FakeHttpCatService(availableCodes)
        
        // When
        val result = service.fetchAllStatuses()
        
        // Then
        assertEquals("https://http.cat/200", result[0].imageUrl)
        assertEquals("https://http.cat/404", result[1].imageUrl)
    }
    
    @Test
    fun `imageExists returns true for available codes`() = runTest {
        // Given
        val availableCodes = setOf(200, 404, 500)
        val service = FakeHttpCatService(availableCodes)
        
        // When & Then
        assertTrue(service.imageExists(200))
        assertTrue(service.imageExists(404))
        assertTrue(service.imageExists(500))
    }
    
    @Test
    fun `imageExists returns false for unavailable codes`() = runTest {
        // Given
        val availableCodes = setOf(200, 404)
        val service = FakeHttpCatService(availableCodes)
        
        // When & Then
        assertFalse(service.imageExists(500))
        assertFalse(service.imageExists(301))
        assertFalse(service.imageExists(999))
    }
    
    @Test
    fun `fetchAllStatuses with empty codes returns empty list`() = runTest {
        // Given
        val service = FakeHttpCatService(emptySet())
        
        // When
        val result = service.fetchAllStatuses()
        
        // Then
        assertEquals(0, result.size)
    }
    
    @Test
    fun `fetchAllStatuses with default codes returns predefined list`() = runTest {
        // Given
        val service = FakeHttpCatService()
        
        // When
        val result = service.fetchAllStatuses()
        
        // Then
        assertEquals(10, result.size)
        assertTrue(result.any { it.code == 200 })
        assertTrue(result.any { it.code == 404 })
        assertTrue(result.any { it.code == 500 })
    }
}
