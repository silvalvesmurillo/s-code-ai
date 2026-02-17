# Perguntas Frequentes (FAQ)

## Perguntas Gerais

### O que é o s-code-ai?

s-code-ai é um projeto de desenvolvimento orientado por IA que demonstra como usar o GitHub Copilot para assistência inteligente de código e revisões automatizadas de PR. Fornece templates, diretrizes e exemplos para desenvolvimento assistido por IA.

### Preciso de uma assinatura do GitHub Copilot?

Sim, você precisa de uma assinatura ativa do GitHub Copilot (individual ou empresarial) para usar os recursos de assistência de IA. No entanto, você ainda pode usar as diretrizes e workflows do projeto sem ela.

### Quais IDEs são suportadas?

O GitHub Copilot funciona com:
- Visual Studio Code
- Visual Studio
- IDEs JetBrains (IntelliJ, PyCharm, etc.)
- Neovim
- Outros editores com extensões do Copilot

## Perguntas de Configuração

### Como instalo o GitHub Copilot?

Veja nosso [Guia de Início](./getting-started.md#2-instale-o-github-copilot) para instruções detalhadas de instalação para sua IDE.

### Por que o Copilot não está sugerindo código?

Razões comuns:
1. Assinatura do Copilot não ativa
2. Extensão da IDE não ativada
3. Tipo de arquivo não suportado
4. Sem conexão com a internet
5. Precisa escrever mais contexto em comentários

**Solução:** Verifique o status da sua assinatura, ative a extensão e tente escrever comentários mais descritivos.

### Posso usar isso com meu projeto existente?

Sim! Você pode copiar os arquivos do diretório `.github/` para seu projeto:
- `.github/copilot-instructions.md`
- `.github/copilot-review-guidelines.md`
- `.github/workflows/copilot-review.yml`

Personalize-os para as necessidades do seu projeto.

## Perguntas de Uso

### Como escrevo melhores prompts para o Copilot?

1. Seja específico e descritivo
2. Inclua contexto e requisitos
3. Mencione casos extremos
4. Use linguagem natural
5. Divida tarefas complexas

Exemplo:
```kotlin
// Criar uma função que valida endereços de email de acordo com RFC 5322,
// trata erros de digitação comuns e retorna mensagens de erro detalhadas
```

Veja [Melhores Práticas](./best-practices.md) para mais detalhes.

### Devo confiar em todas as sugestões do Copilot?

Não! Sempre:
- ✅ Revise o código sugerido
- ✅ Entenda o que ele faz
- ✅ Teste minuciosamente
- ✅ Verifique problemas de segurança
- ✅ Verifique se segue os padrões do projeto

O Copilot é uma ferramenta para ajudá-lo, não substituir seu julgamento.

### Como uso o Copilot para revisões de código?

1. Abra o Copilot Chat na sua IDE
2. Selecione o código para revisar
3. Use comandos como `/review` ou `/explain`
4. Faça perguntas específicas sobre segurança, performance, etc.
5. Aplique melhorias sugeridas

### O Copilot pode escrever testes para mim?

Sim! O Copilot pode ajudar a gerar testes:

```kotlin
// Escrever testes unitários abrangentes para a função acima
// Incluir casos extremos, condições de erro e casos de uso típicos
```

Mas sempre revise e melhore os testes gerados.

## Perguntas sobre Workflow

### O que acontece quando eu crio um PR?

O workflow automatizado:
1. Analisa suas mudanças
2. Posta estatísticas e checklist de revisão
3. Adiciona labels apropriadas
4. Executa verificações de qualidade de código
5. Executa análises de segurança

### Por que minhas verificações de PR falharam?

Confira os logs do workflow:
1. Vá para a aba "Checks" do PR
2. Veja os jobs que falharam
3. Revise as mensagens de erro
4. Corrija problemas e faça push de atualizações

Problemas comuns:
- Secrets hardcoded detectados
- Falhas de teste
- Violações de estilo
- Vulnerabilidades de segurança

### Como personalizo as revisões automatizadas?

Edite `.github/workflows/copilot-review.yml` para:
- Adicionar verificações personalizadas
- Modificar lógica de labeling
- Mudar análises de segurança
- Adicionar etapas de deployment

## Perguntas sobre Qualidade de Código

### Quanta cobertura de teste devo almejar?

Recomendamos:
- Mínimo: 70% de cobertura
- Alvo: 80% de cobertura
- Caminhos críticos: 100% de cobertura

Foque em testes significativos em vez de atingir uma porcentagem.

### Quais padrões de codificação devo seguir?

Veja nossas [Instruções do Copilot](../.github/copilot-instructions.md) para:
- Diretrizes de estilo de código
- Convenções de nomenclatura
- Requisitos de documentação
- Padrões de segurança

### Como trato vulnerabilidades de segurança?

1. Nunca faça commit de secrets ou credenciais
2. Valide e sanitize todas as entradas
3. Use variáveis de ambiente para configuração
4. Mantenha dependências atualizadas
5. Execute análises de segurança regularmente

O workflow automatizado verifica problemas comuns.

## Solução de Problemas

### Sugestões do Copilot estão lentas

Possíveis causas:
- Conexão ruim com a internet
- Problemas de performance da IDE
- Contexto complexo
- Carga do servidor

**Soluções:**
- Verifique sua conexão
- Reinicie a IDE
- Simplifique seu prompt
- Tente novamente mais tarde

### Copilot sugere código desatualizado

Os dados de treinamento do Copilot têm uma data de corte. Para tecnologias mais novas:
- Consulte documentação oficial
- Forneça mais contexto em comentários
- Guie o Copilot com exemplos
- Revise e atualize sugestões

### Minha linguagem/framework não é bem suportada

O Copilot funciona melhor com linguagens populares. Para as menos comuns:
- Forneça mais exemplos em comentários
- Inclua imports de bibliotecas
- Referencie documentação
- Seja mais explícito em prompts

### Copilot não está seguindo convenções do projeto

Certifique-se:
1. `.github/copilot-instructions.md` está configurado
2. Comentários referenciam as convenções
3. Contexto inclui exemplos de código existentes
4. IDE tem atualizações mais recentes

## Perguntas sobre Melhores Práticas

### Devo comentar cada linha?

Não! Comente:
- ✅ Lógica complexa
- ✅ Decisões não óbvias
- ✅ APIs públicas
- ✅ Prompts para o Copilot

Não comente:
- ❌ Código óbvio
- ❌ Funções auto-explicativas
- ❌ Cada linha individual

### Como trato grandes refatorações?

1. Divida em mudanças pequenas
2. Use o Copilot para tarefas repetitivas
3. Teste após cada etapa
4. Faça commit frequentemente
5. Crie múltiplos PRs pequenos

### Posso usar o Copilot para documentação?

Absolutamente! Use o Copilot para:
- Gerar KDoc/docstrings
- Escrever seções de README
- Criar documentação de API
- Explicar algoritmos complexos
- Rascunhar tutoriais

### Como aprendo com o Copilot?

- Revise sugestões para aprender padrões
- Peça ao Copilot para explicar código
- Experimente com diferentes prompts
- Compare múltiplas sugestões
- Estude o código gerado

## Perguntas de Integração

### Posso integrar com outras ferramentas de CI/CD?

Sim! O workflow do GitHub Actions pode ser estendido para:
- Fazer deploy de aplicações
- Executar testes adicionais
- Integrar com monitoramento
- Disparar outros workflows

### Isso funciona com monorepos?

Sim, mas você pode precisar:
- Ajustar caminhos de workflow
- Configurar definições por pacote
- Personalizar lógica de labeling
- Configurar workflows separados

### Posso usar isso com repositórios privados?

Sim! Todos os recursos funcionam com repositórios privados. Os workflows automatizados usam o `GITHUB_TOKEN` embutido do GitHub.

## Perguntas sobre Contribuição

### Como posso contribuir?

Veja nosso [Guia de Contribuição](../.github/CONTRIBUTING.md) para:
- Fluxo de trabalho de desenvolvimento
- Padrões de código
- Processo de PR
- Diretrizes de revisão

### Encontrei um bug, o que devo fazer?

1. Verifique se já foi relatado
2. Crie uma issue detalhada com:
   - Passos para reproduzir
   - Comportamento esperado
   - Comportamento atual
   - Detalhes do ambiente
3. Envie um PR se puder corrigir

### Posso adicionar novos exemplos?

Sim! Aceitamos novos exemplos:
1. Crie um diretório em `examples/`
2. Adicione código bem comentado
3. Inclua testes
4. Escreva um README
5. Envie um PR

## Perguntas Avançadas

### Como personalizo as instruções do Copilot?

Edite `.github/copilot-instructions.md`:
- Adicione padrões específicos do projeto
- Defina convenções personalizadas
- Inclua detalhes de arquitetura
- Adicione critérios de revisão

### Posso usar múltiplos assistentes de IA?

Sim, mas:
- Seja consistente na abordagem
- Siga diretrizes do projeto
- Revise todas as sugestões
- Teste minuciosamente

### Como meço o ROI da assistência de IA?

Acompanhe:
- Velocidade de desenvolvimento
- Taxa de redução de bugs
- Métricas de qualidade de código
- Satisfação do desenvolvedor
- Tempo para onboarding de novos desenvolvedores

## Suporte

### Onde posso obter ajuda?

1. 📖 Leia a [documentação](./README.md)
2. 💬 Use o Copilot Chat
3. 🐛 [Abra uma issue](https://github.com/silvalvesmurillo/s-code-ai/issues)
4. 📧 Entre em contato com os mantenedores
5. 👥 Pergunte à comunidade

### Como reporto um problema de segurança?

Para preocupações de segurança:
- NÃO abra uma issue pública
- Entre em contato diretamente com os mantenedores
- Forneça informações detalhadas
- Permita tempo para uma correção

### A documentação não está clara, posso ajudar?

Sim! Melhorias de documentação são sempre bem-vindas:
1. Identifique a seção pouco clara
2. Sugira melhorias
3. Envie um PR
4. Ajude outros a entender

---

**Não vê sua pergunta?**

[Abra uma issue](https://github.com/silvalvesmurillo/s-code-ai/issues) e nós a adicionaremos ao FAQ!
