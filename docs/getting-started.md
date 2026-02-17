# Começando com s-code-ai

## Pré-requisitos

### Obrigatório
- **Git**: Sistema de controle de versão
- **Conta GitHub**: Com acesso ao GitHub Copilot
- **IDE**: VS Code, Visual Studio, JetBrains ou outra IDE com suporte ao Copilot

### Opcional mas Recomendado
- **Ferramentas de Linguagem de Programação**: Instale ferramentas para sua linguagem preferida (Kotlin, Python, Go, etc.)
- **Docker**: Para desenvolvimento containerizado

## Instalação

### 1. Clone o Repositório

```bash
git clone https://github.com/silvalvesmurillo/s-code-ai.git
cd s-code-ai
```

### 2. Instale o GitHub Copilot

#### VS Code
1. Abra o VS Code
2. Vá para Extensões (Ctrl+Shift+X / Cmd+Shift+X)
3. Procure por "GitHub Copilot"
4. Clique em Instalar
5. Faça login com sua conta GitHub

#### IDEs JetBrains
1. Abra Configurações/Preferências
2. Vá para Plugins
3. Procure por "GitHub Copilot"
4. Instale e reinicie
5. Faça login com sua conta GitHub

#### Outras IDEs
Confira a [documentação do GitHub Copilot](https://docs.github.com/pt/copilot) para sua IDE.

### 3. Configure Sua IDE

#### Configurações do VS Code
Adicione ao seu `settings.json`:

```json
{
  "github.copilot.enable": {
    "*": true,
    "yaml": true,
    "plaintext": false,
    "markdown": true
  },
  "github.copilot.editor.enableAutoCompletions": true
}
```

#### Copilot Chat
Ative o Copilot Chat para assistência interativa:
- VS Code: Instale a extensão "GitHub Copilot Chat"
- JetBrains: Incluído com o plugin do Copilot

## Verificar Instalação

### 1. Testar o Copilot

Crie um novo arquivo na sua linguagem preferida (ex: `test.kt`, `test.py`, `test.go`):

```kotlin
// Função para calcular o fatorial de um número
fun factorial(n: Int): Int {
    // Copilot deve sugerir a implementação
```

O Copilot deve sugerir conclusão de código. Pressione Tab para aceitar sugestões.

## Estrutura do Projeto

```
s-code-ai/
├── .github/
│   ├── copilot-instructions.md      # Configuração principal do Copilot
│   ├── copilot-review-guidelines.md # Padrões de revisão de PR
│   ├── CONTRIBUTING.md              # Diretrizes de contribuição
│   └── workflows/
│       └── copilot-review.yml       # Revisões automatizadas de PR
├── docs/
│   ├── README.md                     # Índice de documentação
│   ├── getting-started.md           # Este arquivo
│   └── best-practices.md            # Melhores práticas de desenvolvimento IA
├── examples/
│   └── README.md                     # Visão geral de exemplos
└── src/
    └── (código do seu projeto)
```

## Primeiros Passos

### 1. Leia a Documentação
- [Instruções do Copilot](../.github/copilot-instructions.md)
- [Diretrizes de Revisão](../.github/copilot-review-guidelines.md)
- [Melhores Práticas](./best-practices.md)

### 2. Explore as Diretrizes
- Revise [Instruções do Copilot](../.github/copilot-instructions.md) para padrões do projeto
- Confira o diretório [Examples](../examples/) para orientação sobre criação de exemplos

### 3. Crie Seu Primeiro Recurso

```bash
# Crie uma branch de feature
git checkout -b feature/meu-primeiro-recurso

# Crie um novo arquivo
# Use o Copilot para ajudá-lo a escrever código

# Teste suas mudanças
# Use o Copilot para gerar testes

# Commit e push
git add .
git commit -m "feat: adicionar meu primeiro recurso"
git push origin feature/meu-primeiro-recurso
```

### 4. Abra um Pull Request
- Vá para o GitHub
- Crie um PR a partir da sua branch
- Observe as verificações automatizadas executarem
- Resolva qualquer feedback

## Usando o Copilot

### Geração de Código
1. Escreva um comentário descrevendo o que você quer
2. Pressione Enter e aguarde a sugestão do Copilot
3. Pressione Tab para aceitar ou continue digitando para refinar

### Copilot Chat
- Abra o painel de chat
- Faça perguntas sobre código
- Solicite geração de código
- Obtenha explicações

### Comandos Comuns
- `/explain` - Explicar código selecionado
- `/fix` - Sugerir correções para problemas
- `/tests` - Gerar testes
- `/doc` - Gerar documentação

## Próximos Passos

Agora que você está configurado:

1. Explore [Exemplos](../examples/)
2. Leia [Melhores Práticas](./best-practices.md)
3. Confira o [FAQ](./faq.md)
4. Comece a construir com assistência de IA!

## Solução de Problemas

### Copilot Não Funciona
- Verifique sua conexão com a internet
- Verifique se a assinatura do Copilot está ativa
- Reinicie sua IDE
- Verifique se as extensões da IDE estão atualizadas

### Nenhuma Sugestão Aparece
- Certifique-se de que o Copilot está ativado
- Verifique se o tipo de arquivo é suportado
- Escreva comentários mais descritivos
- Aguarde um momento para sugestões

### Obtendo Sugestões Ruins
- Adicione mais contexto em comentários
- Revise [Melhores Práticas](./best-practices.md)
- Confira [Instruções do Copilot](../.github/copilot-instructions.md)
- Seja mais específico em seus prompts

## Suporte

Precisa de ajuda?
- 📖 Leia o [FAQ](./faq.md)
- 💬 Use o Copilot Chat
- 🐛 [Abra uma issue](https://github.com/silvalvesmurillo/s-code-ai/issues)
- 📧 Entre em contato com os mantenedores
