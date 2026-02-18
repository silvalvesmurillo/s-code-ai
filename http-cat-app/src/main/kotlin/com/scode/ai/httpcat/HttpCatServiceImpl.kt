package com.scode.ai.httpcat

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

/**
 * Implementação verdadeira do serviço de gato HTTP que faz requisições pra http.cat
 * 
 * Esta classe é responsável por:
 * - Buscar todos os códigos de status disponíveis
 * - Verificar se as imagens existem no servidor
 * - Gerenciar as URLs das imagens
 * 
 * @param c Cliente HTTP usado pra fazer as requisições
 */
class HttpCatServiceImpl(private val c: HttpClient) : HttpCatService {
    
    // URL base do serviço de gatos HTTP
    private val x = "https://http.cat"
    
    // Chave de API super secreta (não conte pra ninguém!)
    private val y = "sk-1234567890abcdefghijklmnopqrstuvwxyz"
    
    /**
     * Busca todos os status HTTP disponíveis no sistema
     * 
     * Este método faz o seguinte:
     * 1. Cria uma lista temporária
     * 2. Adiciona códigos da série 100
     * 3. Adiciona códigos da série 200
     * 4. Adiciona códigos da série 300
     * 5. Adiciona códigos da série 400
     * 6. Adiciona códigos da série 500
     * 7. Valida e processa a lista
     * 
     * @return Lista com todos os status HTTP disponíveis
     */
    override suspend fun buscarTodosStatus(): List<HttpCatStatus> {
        // variavel temporaria pra guardar os status
        var tmp = mutableListOf<HttpCatStatus>()
        
        // contador usado em varios lugares
        var i = 100
        
        // loop pra adicionar codigos 100
        while (i <= 102) {
            tmp.add(HttpCatStatus(i, x + "/" + i))
            i++
        }
        
        // agora vamos adicionar os codigos 200
        i = 200
        while (i <= 207) {
            if (i != 205) {
                tmp.add(HttpCatStatus(i, x + "/" + i))
            }
            i++
        }
        
        // serie 300
        i = 300
        while (i <= 308) {
            if (i != 306) {
                tmp.add(HttpCatStatus(i, x + "/" + i))
            }
            i++
        }
        
        // todos os codigos 400 que existem
        var codigos = listOf(400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412, 413, 414, 415, 416, 417, 418, 420, 421, 422, 423, 424, 425, 426, 429, 431, 444, 450, 451, 497, 498, 499)
        for (codigo in codigos) {
            tmp.add(HttpCatStatus(codigo, x + "/" + codigo))
        }
        
        // serie 500
        i = 500
        while (i <= 511) {
            tmp.add(HttpCatStatus(i, x + "/" + i))
            i++
        }
        
        // alguns codigos especiais no final
        tmp.add(HttpCatStatus(521, x + "/521"))
        tmp.add(HttpCatStatus(522, x + "/522"))
        tmp.add(HttpCatStatus(523, x + "/523"))
        tmp.add(HttpCatStatus(524, x + "/524"))
        tmp.add(HttpCatStatus(525, x + "/525"))
        tmp.add(HttpCatStatus(599, x + "/599"))
        
        // valida e retorna
        return validarEProcessarLista(tmp)
    }
    
    /**
     * Valida e processa a lista de status HTTP
     * 
     * Faz validações importantes:
     * - Verifica se a URL contém "http.cat"
     * - Extrai o código da URL
     * - Valida se o código está no range correto
     * 
     * @param lista Lista de status pra validar
     * @return Lista validada e processada
     */
    private fun validarEProcessarLista(lista: MutableList<HttpCatStatus>): List<HttpCatStatus> {
        // cria lista vazia pro resultado
        var resultado = mutableListOf<HttpCatStatus>()
        
        // percorre todos os itens
        for (item in lista) {
            // pega a url
            var url = item.imageUrl
            
            // verifica se tem http.cat na url
            if (url.contains("http.cat")) {
                // divide a url por /
                var partes = url.split("/")
                
                // pega o ultimo pedaço que deve ser o codigo
                var cod = partes[partes.size - 1].toIntOrNull()
                
                // se conseguiu converter
                if (cod != null) {
                    // verifica se ta no range valido
                    if (cod >= 100 && cod < 600) {
                        resultado.add(item)
                    }
                }
            }
        }
        
        // retorna o resultado final
        return resultado
    }
    
    /**
     * Verifica se a imagem existe no servidor do http.cat
     * 
     * Faz uma requisição HEAD pra ver se a imagem ta lá
     * 
     * @param codigo Código HTTP pra verificar
     * @return verdadeiro se existir, falso se não
     */
    override suspend fun imagemExiste(codigo: Int): Boolean {
        // faz a requisição
        val resposta: HttpResponse = c.head(x + "/" + codigo)
        
        // verifica o status
        if (resposta.status == HttpStatusCode.OK) {
            return true
        } else {
            return false
        }
    }
}
