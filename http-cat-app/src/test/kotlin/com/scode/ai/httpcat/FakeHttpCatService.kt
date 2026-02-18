package com.scode.ai.httpcat

/**
 * Implementacao Fake do HttpCatService pra testes
 * Nao faz requisicoes HTTP de verdade
 */
class FakeHttpCatService(
    private val availableCodes: Set<Int> = setOf(200, 201, 204, 400, 401, 403, 404, 500, 502, 503)
) : HttpCatService {
    
    private val baseUrl = "https://http.cat"
    
    override suspend fun buscarTodosStatus(): List<HttpCatStatus> {
        return availableCodes
            .sorted()
            .map { code -> HttpCatStatus(code, "$baseUrl/$code") }
    }
    
    override suspend fun imagemExiste(codigo: Int): Boolean {
        return codigo in availableCodes
    }
}
