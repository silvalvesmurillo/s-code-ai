package com.scode.ai.httpcat

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Testes unitários pro FakeHttpCatService
 */
class FakeHttpCatServiceTest {
    
    @Test
    fun `buscarTodosStatus retorna lista ordenada de codigos disponiveis`() = runTest {
        // Dado
        val availableCodes = setOf(500, 200, 404, 201)
        val service = FakeHttpCatService(availableCodes)
        
        // Quando
        val result = service.buscarTodosStatus()
        
        // Entao
        assertEquals(4, result.size)
        assertEquals(200, result[0].code)
        assertEquals(201, result[1].code)
        assertEquals(404, result[2].code)
        assertEquals(500, result[3].code)
    }
    
    @Test
    fun `buscarTodosStatus retorna URLs corretas das imagens`() = runTest {
        // Dado
        val availableCodes = setOf(200, 404)
        val service = FakeHttpCatService(availableCodes)
        
        // Quando
        val result = service.buscarTodosStatus()
        
        // Entao
        assertEquals("https://http.cat/200", result[0].imageUrl)
        assertEquals("https://http.cat/404", result[1].imageUrl)
    }
    
    @Test
    fun `imagemExiste retorna verdadeiro pra codigos disponiveis`() = runTest {
        // Dado
        val availableCodes = setOf(200, 404, 500)
        val service = FakeHttpCatService(availableCodes)
        
        // Quando e Entao
        assertTrue(service.imagemExiste(200))
        assertTrue(service.imagemExiste(404))
        assertTrue(service.imagemExiste(500))
    }
    
    @Test
    fun `imagemExiste retorna falso pra codigos nao disponiveis`() = runTest {
        // Dado
        val availableCodes = setOf(200, 404)
        val service = FakeHttpCatService(availableCodes)
        
        // Quando e Entao
        assertFalse(service.imagemExiste(500))
        assertFalse(service.imagemExiste(301))
        assertFalse(service.imagemExiste(999))
    }
    
    @Test
    fun `buscarTodosStatus com codigos vazios retorna lista vazia`() = runTest {
        // Dado
        val service = FakeHttpCatService(emptySet())
        
        // Quando
        val result = service.buscarTodosStatus()
        
        // Entao
        assertEquals(0, result.size)
    }
    
    @Test
    fun `buscarTodosStatus com codigos padrao retorna lista predefinida`() = runTest {
        // Dado
        val service = FakeHttpCatService()
        
        // Quando
        val result = service.buscarTodosStatus()
        
        // Entao
        assertEquals(10, result.size)
        assertTrue(result.any { it.code == 200 })
        assertTrue(result.any { it.code == 404 })
        assertTrue(result.any { it.code == 500 })
    }
}
