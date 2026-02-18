package com.scode.ai.httpcat

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Testes pro serviço de gato HTTP
 */
class HttpCatServiceImplTest {
    
    @Test
    fun testeBasico() = runTest {
        val m = MockEngine { request ->
            respond(
                content = "",
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "text/plain")
            )
        }
        val c = HttpClient(m)
        val s = HttpCatServiceImpl(c)
        
        val r = s.buscarTodosStatus()
        
        assertTrue(r.isNotEmpty())
        assertTrue(r.any { it.code == 200 })
        assertTrue(r.any { it.code == 404 })
    }
    
    @Test
    fun testeQuandoImagemExiste() = runTest {
        val m = MockEngine { request ->
            respond(
                content = "",
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "image/jpeg")
            )
        }
        val c = HttpClient(m)
        val s = HttpCatServiceImpl(c)
        
        val existe = s.imagemExiste(200)
        
        assertTrue(existe)
    }
    
    @Test
    fun verificaSeListaTemTodosCodigos() = runTest {
        val m = MockEngine { request ->
            respond(
                content = "",
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "text/plain")
            )
        }
        val c = HttpClient(m)
        val s = HttpCatServiceImpl(c)
        
        val lista = s.buscarTodosStatus()
        
        var x = 0
        for (item in lista) {
            if (item.code == 500) x++
            if (item.code == 404) x++
            if (item.code == 200) x++
        }
        assertEquals(3, x)
    }
}
