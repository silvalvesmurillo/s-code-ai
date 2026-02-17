# Diretrizes de Revisão de PR para GitHub Copilot

## Visão Geral
Este documento fornece diretrizes específicas para revisões automatizadas de PR usando GitHub Copilot e assistentes de IA.

## Áreas de Foco da Revisão Automatizada

### 1. Qualidade do Código
- **Legibilidade**: O código é fácil de entender?
- **Manutenibilidade**: Este código será fácil de modificar posteriormente?
- **Complexidade**: As funções e classes têm tamanho apropriado?
- **Nomenclatura**: As variáveis, funções e classes têm bons nomes?

### 2. Verificações de Segurança
- **Secrets**: Sem senhas, chaves de API ou tokens hardcoded
- **Validação de Entrada**: Todas as entradas de usuário são validadas e sanitizadas
- **Autenticação**: Verificações adequadas de autenticação e autorização
- **Dependências**: Sem vulnerabilidades conhecidas nas dependências
- **Exposição de Dados**: Dados sensíveis são adequadamente protegidos

### 3. Testes
- **Cobertura**: Novo código tem cobertura de teste apropriada
- **Qualidade dos Testes**: Os testes são significativos e testam comportamento real
- **Casos Extremos**: Casos extremos e condições de erro são testados
- **Integração**: Testes de integração existem para caminhos críticos

### 4. Documentação
- **Comentários de Código**: Lógica complexa é explicada
- **Documentação de Funções**: APIs públicas são documentadas
- **Atualizações de README**: Mudanças voltadas ao usuário são documentadas
- **Changelog**: Mudanças significativas são registradas

### 5. Performance
- **Algoritmos**: Algoritmos apropriados para o caso de uso
- **Consultas de Banco de Dados**: Otimizadas e indexadas adequadamente
- **Cache**: Uso apropriado de cache
- **Memória**: Sem vazamentos de memória óbvios

### 6. Tratamento de Erros
- **Try-Catch**: Tratamento de erros apropriado existe
- **Mensagens de Erro**: Mensagens de erro claras e acionáveis
- **Logging**: Erros são registrados com contexto suficiente
- **Recuperação**: Degradação graciosa e recuperação

## Processo de Revisão

### Quando um PR é Aberto
1. Verifique que todas as verificações necessárias passaram
2. Revise mudanças de código para as áreas de foco acima
3. Deixe comentários inline para problemas específicos
4. Forneça um comentário resumido com:
   - Avaliação geral
   - Principais preocupações
   - Sugestões de melhoria
   - Aprovação ou solicitação de mudanças

### Diretrizes de Comentários
- Seja específico e acionável
- Referencie números de linha
- Explique *por que* algo é um problema
- Sugira melhorias concretas
- Seja construtivo e respeitoso

### Exemplos de Comentários

**Bom Comentário:**
```
Linhas 45-50: Esta função pode ser vulnerável a injeção SQL.
Considere usar consultas parametrizadas em vez de concatenação de strings.

Exemplo:
```kotlin
val query = "SELECT * FROM users WHERE id = ?"
preparedStatement.setString(1, userId)
```
Em vez de:
```kotlin
val query = "SELECT * FROM users WHERE id = '$userId'"
```
```

**Comentário Ruim:**
```
Isto está ruim
```

## Níveis de Severidade

### 🔴 Crítico (Deve Corrigir)
- Vulnerabilidades de segurança
- Riscos de perda de dados
- Mudanças que quebram sem migração
- Falhas de teste

### 🟡 Aviso (Deve Corrigir)
- Problemas de performance
- Testes faltando
- Código pouco claro
- Documentação faltando

### 🟢 Sugestão (Bom ter)
- Melhorias de estilo
- Oportunidades de refatoração
- Testes adicionais
- Documentação aprimorada

## Critérios de Aprovação Automática

Um PR pode ser aprovado automaticamente se:
- Todos os testes passam
- Nenhum problema de segurança detectado
- Cobertura de código é mantida ou melhorada
- Documentação está atualizada
- Segue todas as diretrizes de estilo
- Nenhum problema crítico ou de aviso encontrado

## Modelos de Revisão

### Comentário de Revisão Padrão
```markdown
## Resumo da Revisão IA

### ✅ Pontos Fortes
- [Liste aspectos positivos]

### ⚠️ Preocupações
- [Liste problemas encontrados com severidade]

### 💡 Sugestões
- [Liste melhorias opcionais]

### 🎯 Itens de Ação
- [ ] [Mudanças necessárias]

Geral: [APROVADO | SOLICITAR MUDANÇAS | COMENTÁRIO]
```

### Revisão de Segurança
```markdown
## 🔒 Revisão de Segurança

### Descobertas
- [Liste preocupações de segurança]

### Recomendações
- [Melhorias específicas de segurança]

### Referências
- [Links para melhores práticas de segurança]
```

### Revisão de Performance
```markdown
## ⚡ Revisão de Performance

### Problemas Potenciais
- [Preocupações de performance]

### Sugestões de Otimização
- [Melhorias específicas]

### Benchmarks
- [Métricas de performance se disponível]
```

## Exclusões

Não revise:
- Código auto-gerado (a menos que seja sensível à segurança)
- Arquivos de lock de dependências (a menos que haja preocupações de segurança)
- Artefatos de build
- Configuração para serviços externos (a menos que credenciais expostas)

## Integração com CI/CD

Este processo de revisão se integra com:
- GitHub Actions para verificações automatizadas
- CodeQL para análise de segurança
- Ferramentas de cobertura de testes
- Linters e formatadores

## Melhoria Contínua

As diretrizes de revisão devem ser atualizadas com base em:
- Feedback da equipe
- Problemas comuns encontrados
- Novas ameaças de segurança
- Mudanças de tecnologia
- Evolução do projeto