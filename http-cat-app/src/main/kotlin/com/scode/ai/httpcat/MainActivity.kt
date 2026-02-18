package com.scode.ai.httpcat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import kotlinx.coroutines.launch

/**
 * Main Activity that displays the HTTP Cat status codes in a LazyColumn
 */
class MainActivity : ComponentActivity() {
    
    private lateinit var httpCatService: HttpCatService
    private lateinit var httpClient: HttpClient
    
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // Initialize HTTP client with OkHttp engine for Android
        httpClient = HttpClient(OkHttp)
        httpCatService = HttpCatServiceImpl(httpClient)
        
        setContent {
            HttpCatTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(stringResource(R.string.app_name)) },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                ) { paddingValues ->
                    HttpCatScreen(
                        service = httpCatService,
                        modifier = Modifier.padding(paddingValues)
                    )
                }
            }
        }
    }
    
    override fun onDestroy() {
        super.onDestroy()
        httpClient.close()
    }
}

@Composable
fun HttpCatTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(),
        content = content
    )
}

@Composable
fun HttpCatScreen(
    service: HttpCatService,
    modifier: Modifier = Modifier
) {
    var statuses by remember { mutableStateOf<List<HttpCatStatus>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }
    
    val scope = rememberCoroutineScope()
    
    LaunchedEffect(Unit) {
        try {
            statuses = service.buscarTodosStatus()
            isLoading = false
        } catch (e: Exception) {
            error = e.message
            isLoading = false
        }
    }
    
    Box(modifier = modifier.fillMaxSize()) {
        when {
            isLoading -> {
                LoadingScreen()
            }
            error != null -> {
                ErrorScreen(
                    error = error ?: stringResource(R.string.error_loading),
                    onRetry = {
                        isLoading = true
                        error = null
                        scope.launch {
                            try {
                                statuses = service.buscarTodosStatus()
                                isLoading = false
                            } catch (e: Exception) {
                                error = e.message
                                isLoading = false
                            }
                        }
                    }
                )
            }
            statuses.isEmpty() -> {
                EmptyScreen()
            }
            else -> {
                HttpCatList(statuses = statuses)
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CircularProgressIndicator()
            Text(
                text = stringResource(R.string.loading),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun ErrorScreen(
    error: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = error,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
            Button(onClick = onRetry) {
                Text(stringResource(R.string.retry))
            }
        }
    }
}

@Composable
fun EmptyScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(R.string.no_images),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun HttpCatList(
    statuses: List<HttpCatStatus>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(statuses) { status ->
            HttpCatItem(status = status)
        }
    }
}

@Composable
fun HttpCatItem(
    status: HttpCatStatus,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Display the HTTP status code
            Text(
                text = status.getDisplayText(),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            
            // Display the cat image
            AsyncImage(
                model = status.imageUrl,
                contentDescription = "HTTP ${status.code} cat image",
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp, max = 400.dp),
                contentScale = ContentScale.Fit
            )
            
            // Display the image URL
            Text(
                text = status.imageUrl,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}
