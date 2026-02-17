# Guia de Contribuição

## Começando

Este projeto usa o GitHub Copilot para desenvolvimento assistido por IA. Certifique-se de ter:

1. GitHub Copilot ativado na sua IDE
2. Familiaridade com as [Instruções do Copilot](.github/copilot-instructions.md) do projeto
3. Compreensão de nossas [Diretrizes de Revisão](.github/copilot-review-guidelines.md)

## Fluxo de Trabalho de Desenvolvimento

### 1. Crie uma Branch
```bash
git checkout -b feature/nome-do-seu-recurso
```

Siga nossas [convenções de nomenclatura de branch](.github/copilot-instructions.md#convenção-de-nomenclatura-de-branch).

### 2. Faça Mudanças
- Use o GitHub Copilot para auxiliar na geração de código
- Siga os padrões de codificação do projeto
- Escreva testes para suas mudanças
- Atualize a documentação conforme necessário

### 3. Teste Suas Mudanças
```bash
# Execute os testes (uma vez que o framework de teste esteja configurado)
./gradlew test  # para Kotlin/Gradle
```

### 4. Commit Suas Mudanças
Siga o [formato de commit convencional](.github/copilot-instructions.md#formato-de-mensagem-de-commit):

```bash
git add .
git commit -m "feat(escopo): adicionar novo recurso"
```

### 5. Push e Crie PR
```bash
git push origin feature/nome-do-seu-recurso
```

Então crie um Pull Request no GitHub.

## Usando o GitHub Copilot

### Para Geração de Código
1. Escreva um comentário descrevendo o que você quer
2. Deixe o Copilot sugerir a implementação
3. Revise e refine a sugestão
4. Teste o código gerado

### Para Revisão de Código
1. Abra o PR na sua IDE
2. Use o Copilot para revisar mudanças
3. Faça perguntas sobre o código
4. Solicite melhorias

### Exemplos de Prompts
- "Gerar uma função que valida endereços de email"
- "Escrever testes unitários para esta função"
- "Refatorar este código para melhorar legibilidade"
- "Adicionar tratamento de erro a esta função assíncrona"
- "Revisar este PR para problemas de segurança"

## Processo de Revisão de PR

### Verificações Automatizadas
Quando você cria um PR, verificações automatizadas irão:
- Analisar qualidade do código
- Verificar problemas de segurança
- Verificar cobertura de testes
- Postar um comentário de revisão

### Revisão Manual
- Resolva feedback das verificações automatizadas
- Responda aos comentários dos revisores
- Atualize seu PR conforme necessário

### Aprovação
Uma vez que todas as verificações passem e revisões sejam resolvidas:
- Seu PR será aprovado
- Pode ser merged

## Melhores Práticas

### Qualidade de Código
- Mantenha funções pequenas e focadas
- Use nomes significativos
- Adicione comentários para lógica complexa
- Siga DRY (Don't Repeat Yourself)

### Testes
- Escreva testes antes ou junto com o código
- Teste casos extremos
- Almeje alta cobertura
- Use nomes de teste descritivos

### Segurança
- Nunca faça commit de secrets
- Valide todas as entradas
- Use variáveis de ambiente
- Mantenha dependências atualizadas

### Documentação
- Atualize README para mudanças voltadas ao usuário
- Adicione comentários de código para mantenedores
- Documente APIs e interfaces
- Mantenha changelog atualizado

## Obtendo Ajuda

- Revise [Instruções do Copilot](.github/copilot-instructions.md)
- Confira [Diretrizes de Revisão](.github/copilot-review-guidelines.md)
- Pergunte ao GitHub Copilot na sua IDE
- Entre em contato com os mantenedores

## Ferramentas e Recursos

### Configuração da IDE
- Instale a extensão do GitHub Copilot
- Configure as definições da sua IDE
- Aprenda atalhos de teclado

### Comandos Úteis
```bash
# Verificar estilo de código
./gradlew ktlintCheck  # ou seu linter

# Executar testes
./gradlew test

# Construir projeto
./gradlew build

# Iniciar servidor de desenvolvimento
./gradlew run
```

## Perguntas?

Se você tiver perguntas:
1. Confira a documentação existente
2. Pergunte ao GitHub Copilot
3. Abra uma issue
4. Entre em contato com os mantenedores
