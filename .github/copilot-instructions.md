# Instruções do GitHub Copilot para s-code-ai

## Visão Geral do Projeto
Este é um projeto de desenvolvimento orientado por IA que aproveita o GitHub Copilot para assistência inteligente de código e revisões automatizadas de PR.

## Estilo de Código e Padrões

### Princípios Gerais
- Escreva código limpo, sustentável e bem documentado
- Siga os princípios SOLID e padrões de design
- Prefira composição em vez de herança
- Mantenha as funções pequenas e focadas (responsabilidade única)
- Use nomes descritivos para variáveis e funções

### Documentação
- Adicione KDoc para todas as funções e classes públicas
- Inclua comentários inline para lógica complexa
- Mantenha arquivos README atualizados em cada diretório principal
- Documente endpoints de API com exemplos de requisição/resposta

### Testes
- Escreva testes unitários para todos os novos recursos
- Almeje pelo menos 80% de cobertura de código
- Inclua testes de integração para fluxos críticos
- Teste casos extremos e condições de erro
- Use nomes de teste descritivos que expliquem o cenário

### Segurança
- Nunca faça commit de secrets, chaves de API ou credenciais
- Valide e sanitize todas as entradas de usuário
- Use variáveis de ambiente para configuração
- Siga o princípio do menor privilégio
- Mantenha as dependências atualizadas

### Performance
- Otimize para legibilidade primeiro, depois performance
- Faça profile antes de otimizar
- Evite otimização prematura
- Use estruturas de dados e algoritmos apropriados

## Diretrizes de Desenvolvimento Assistido por IA

### Ao Revisar Código
- Verifique possíveis bugs e casos extremos
- Verifique o tratamento adequado de erros
- Garanta que o código segue as convenções do projeto
- Procure vulnerabilidades de segurança
- Sugira melhorias de performance quando aplicável
- Valide a cobertura de testes

### Ao Gerar Código
- Siga os padrões existentes no código
- Gere testes abrangentes junto com a implementação
- Inclua tratamento adequado de erros
- Adicione comentários e documentação significativos
- Considere casos extremos e cenários de erro

### Ao Refatorar
- Mantenha compatibilidade retroativa quando possível
- Atualize testes e documentação relacionados
- Garanta que nenhuma funcionalidade seja quebrada
- Melhore a legibilidade e manutenibilidade do código

## Diretrizes Específicas do Projeto

### Requisitos de Pull Request
- Todos os PRs devem incluir testes
- Todos os testes devem passar
- A cobertura de código não deve diminuir
- A documentação deve ser atualizada
- Siga mensagens de commit convencionais

### Formato de Mensagem de Commit
```
tipo(escopo): assunto

corpo

rodapé
```

Tipos: feat, fix, docs, style, refactor, test, chore

### Convenção de Nomenclatura de Branch
- `feature/descricao` - para novos recursos
- `fix/descricao` - para correções de bugs
- `docs/descricao` - para documentação
- `refactor/descricao` - para refatoração
- `test/descricao` - para adições/modificações de testes

## Checklist de Revisão

Ao revisar PRs, garanta:
- [ ] O código segue as diretrizes de estilo do projeto
- [ ] Todos os testes passam
- [ ] Novos recursos têm testes
- [ ] A documentação está atualizada
- [ ] Nenhuma vulnerabilidade de segurança foi introduzida
- [ ] O impacto na performance é aceitável
- [ ] O tratamento de erros é apropriado
- [ ] O código é manutenível e legível
- [ ] Não há valores hardcoded ou secrets
- [ ] As dependências são justificadas e seguras

## Padrões Comuns a Seguir

### Tratamento de Erros
```kotlin
try {
    // Operação
} catch (e: Exception) {
    logger.error("Mensagem de erro específica do contexto", e)
    throw CustomException("Mensagem amigável ao usuário", e)
}
```

### Operações Assíncronas
- Use coroutines do Kotlin para operações assíncronas
- Sempre trate erros em funções assíncronas
- Evite callback hell

### Configuração
- Use variáveis de ambiente
- Forneça valores padrão sensatos
- Valide a configuração na inicialização

## Recursos
- Wiki do Projeto: [Link para wiki]
- Guia de Estilo: [Link para guia de estilo]
- Documentação de Arquitetura: [Link para docs de arquitetura]
