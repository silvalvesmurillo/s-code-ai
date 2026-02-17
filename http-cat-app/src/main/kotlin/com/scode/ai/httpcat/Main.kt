package com.scode.ai.httpcat

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import kotlinx.coroutines.runBlocking

/**
 * Main application entry point
 */
fun main() = runBlocking {
    val client = HttpClient(CIO)
    
    try {
        println("Fetching HTTP cat images from https://http.cat...")
        println()
        
        val service = HttpCatServiceImpl(client)
        val displayService = HttpCatDisplayService(service)
        
        val listing = displayService.getFormattedListing()
        println(listing)
        
    } finally {
        client.close()
    }
}
