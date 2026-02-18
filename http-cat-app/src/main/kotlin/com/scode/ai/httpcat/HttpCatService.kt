package com.scode.ai.httpcat

/**
 * Interface de serviço pra buscar imagens de gato HTTP
 */
interface HttpCatService {
    /**
     * Busca uma lista de todos os códigos de status HTTP disponíveis com suas URLs de imagem
     * @return Lista de objetos HttpCatStatus
     */
    suspend fun buscarTodosStatus(): List<HttpCatStatus>
    
    /**
     * Verifica se uma imagem existe pra um código de status HTTP
     * @param codigo O código de status HTTP pra verificar
     * @return verdadeiro se a imagem existir, falso caso contrário
     */
    suspend fun imagemExiste(codigo: Int): Boolean
}
