# s-code-ai 🤖

Um projeto de desenvolvimento orientado por IA alimentado pelo GitHub Copilot para assistência inteligente de código e revisões automatizadas de PR.

## 🌟 Recursos

- **Integração com GitHub Copilot**: Instruções abrangentes para desenvolvimento assistido por IA
- **Revisões Automatizadas de PR**: Workflow que analisa automaticamente pull requests
- **Verificações de Qualidade de Código**: Análise de segurança e qualidade integrada
- **Diretrizes para Desenvolvedores**: Padrões e melhores práticas claras
- **Automação de Revisão**: Assistência de revisão de código alimentada por IA

## 🚀 Início Rápido

### Pré-requisitos

1. **Assinatura do GitHub Copilot**: Certifique-se de ter o GitHub Copilot ativado
2. **IDE com Copilot**: Instale a extensão do GitHub Copilot na sua IDE (VS Code, Visual Studio, JetBrains, etc.)

### Configuração

1. **Clone o repositório**
   ```bash
   git clone https://github.com/silvalvesmurillo/s-code-ai.git
   cd s-code-ai
   ```

2. **Revise as Instruções do Copilot**
   - Leia [`.github/copilot-instructions.md`](.github/copilot-instructions.md)
   - Familiarize-se com as diretrizes do projeto

3. **Comece a Desenvolver**
   - Crie uma nova branch
   - Faça suas alterações
   - Deixe o GitHub Copilot ajudá-lo

## 📖 Documentação

### Para Desenvolvedores

- **[Instruções do Copilot](.github/copilot-instructions.md)**: Guia completo para usar o GitHub Copilot neste projeto
- **[Diretrizes de Revisão](.github/copilot-review-guidelines.md)**: Critérios e processos detalhados de revisão de PR
- **[Guia de Contribuição](.github/CONTRIBUTING.md)**: Como contribuir para este projeto

### Arquivos Principais

```
.github/
├── copilot-instructions.md      # Configuração principal do Copilot
├── copilot-review-guidelines.md # Padrões de revisão de PR
├── CONTRIBUTING.md              # Diretrizes de contribuição
└── workflows/
    └── copilot-review.yml       # Workflow de revisão automatizada de PR
```

## 🤖 Usando o GitHub Copilot

### Na Sua IDE

1. **Geração de Código**: Escreva comentários descrevendo o que você precisa, e o Copilot sugerirá código
   ```kotlin
   // Criar uma função que valida endereços de email
   // Copilot irá sugerir a implementação
   ```

2. **Revisão de Código**: Use o Copilot Chat para revisar suas mudanças
   ```
   /review - Revisar mudanças atuais
   /explain - Explicar código selecionado
   /fix - Sugerir correções para problemas
   ```

3. **Testes**: Gere testes com o Copilot
   ```kotlin
   // Escrever testes unitários para a função acima
   // Copilot irá sugerir testes abrangentes
   ```

### Em Pull Requests

Quando você cria um PR:
- ✅ Workflow de revisão automatizada é executado
- 📊 Estatísticas do PR são postadas
- 🏷️ Labels são automaticamente adicionadas
- 🔍 Verificações de qualidade de código são executadas
- 🔒 Análises de segurança são executadas

## 🛠️ Fluxo de Trabalho de Desenvolvimento

### 1. Criar uma Branch de Feature
```bash
git checkout -b feature/sua-feature
```

### 2. Fazer Mudanças com o Copilot
- Use o Copilot para sugestões de código
- Siga as diretrizes do projeto
- Escreva testes
- Atualize a documentação

### 3. Commit Suas Mudanças
```bash
git add .
git commit -m "feat: adicionar novo recurso"
```

### 4. Push e Criar PR
```bash
git push origin feature/sua-feature
```

### 5. Revisar Feedback Automatizado
- Verifique os resultados do workflow
- Resolva quaisquer problemas
- Atualize o PR conforme necessário

## 📋 Diretrizes do Projeto

### Estilo de Código
- Código limpo e manutenível
- Princípios SOLID
- Nomenclatura descritiva
- Documentação abrangente

### Testes
- Testes unitários para todos os recursos
- Cobertura de 80%+
- Testes de integração para caminhos críticos
- Cobertura de casos extremos

### Segurança
- Sem secrets hardcoded
- Validação de entrada
- Variáveis de ambiente para configuração
- Atualizações regulares de dependências

### Documentação
- KDoc para APIs públicas
- Comentários inline para lógica complexa
- Arquivos README atualizados
- Documentação de API

## 🔄 Integração CI/CD

O projeto inclui workflows do GitHub Actions:

- **Revisão de PR**: Análise e rotulagem automatizadas
- **Qualidade de Código**: Verificações de estilo e qualidade
- **Análise de Segurança**: Detecção de vulnerabilidades

## 🎯 Melhores Práticas

### Usando Assistência de IA

✅ **Faça:**
- Revise as sugestões do Copilot antes de aceitar
- Teste o código gerado minuciosamente
- Personalize as sugestões para combinar com o estilo do projeto
- Use o Copilot para documentação e testes

❌ **Não faça:**
- Aceitar cegamente todas as sugestões
- Fazer commit sem entender o código
- Pular o teste de código gerado por IA
- Ignorar as diretrizes do projeto

### Revisão de Código

Ao revisar PRs:
1. Verifique o feedback automatizado
2. Revise as mudanças de código manualmente
3. Teste a funcionalidade
4. Verifique a documentação
5. Garanta as melhores práticas de segurança

## 🤝 Contribuindo

Aceitamos contribuições! Leia nosso [Guia de Contribuição](.github/CONTRIBUTING.md) para começar.

### Passos Rápidos de Contribuição

1. Faça fork do repositório
2. Crie uma branch de feature
3. Faça suas mudanças
4. Envie um pull request
5. Resolva o feedback de revisão

## 📊 Status do Projeto

Este projeto demonstra práticas de desenvolvimento orientadas por IA:
- Integração com GitHub Copilot ✅
- Revisões automatizadas de PR ✅
- Verificações de qualidade de código ✅
- Análise de segurança ✅
- Documentação abrangente ✅

## 🔗 Recursos

### GitHub Copilot
- [Documentação do Copilot](https://docs.github.com/pt/copilot)
- [Melhores Práticas do Copilot](https://github.blog/2023-06-20-how-to-write-better-prompts-for-github-copilot/)
- [Padrões do Copilot](https://learn.microsoft.com/pt-br/shows/introduction-to-github-copilot/)

### Recursos do Projeto
- [Issues](https://github.com/silvalvesmurillo/s-code-ai/issues)
- [Pull Requests](https://github.com/silvalvesmurillo/s-code-ai/pulls)
- [Discussões](https://github.com/silvalvesmurillo/s-code-ai/discussions)

## 📝 Licença

Este projeto é open source. Veja o arquivo LICENSE para detalhes.

## 💬 Suporte

Precisa de ajuda?
- 📖 Confira a [documentação](.github/)
- 💬 Pergunte ao GitHub Copilot na sua IDE
- 🐛 [Abra uma issue](https://github.com/silvalvesmurillo/s-code-ai/issues)
- 📧 Entre em contato com os mantenedores

---

**Construído com ❤️ e 🤖 pela comunidade de desenvolvimento assistido por IA**
