# Getting Started with s-code-ai

## Prerequisites

### Required
- **Git**: Version control system
- **GitHub Account**: With access to GitHub Copilot
- **IDE**: VS Code, Visual Studio, JetBrains, or other Copilot-supported IDE

### Optional but Recommended
- **Node.js**: For JavaScript/TypeScript examples
- **Python**: For Python examples
- **Docker**: For containerized development

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/silvalvesmurillo/s-code-ai.git
cd s-code-ai
```

### 2. Install GitHub Copilot

#### VS Code
1. Open VS Code
2. Go to Extensions (Ctrl+Shift+X / Cmd+Shift+X)
3. Search for "GitHub Copilot"
4. Click Install
5. Sign in with your GitHub account

#### JetBrains IDEs
1. Open Settings/Preferences
2. Go to Plugins
3. Search for "GitHub Copilot"
4. Install and restart
5. Sign in with your GitHub account

#### Other IDEs
Check [GitHub Copilot documentation](https://docs.github.com/en/copilot) for your IDE.

### 3. Configure Your IDE

#### VS Code Settings
Add to your `settings.json`:

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
Enable Copilot Chat for interactive assistance:
- VS Code: Install "GitHub Copilot Chat" extension
- JetBrains: Included with Copilot plugin

## Verify Installation

### 1. Test Copilot

Create a new file `test.js`:

```javascript
// Function to calculate the factorial of a number
function factorial(n) {
  // Copilot should suggest the implementation
```

Copilot should suggest code completion.

### 2. Run Example Tests

```bash
cd examples
node email-validator.test.js
```

You should see:
```
✅ All tests passed!
```

## Project Structure

```
s-code-ai/
├── .github/
│   ├── copilot-instructions.md      # Main Copilot configuration
│   ├── copilot-review-guidelines.md # PR review standards
│   ├── CONTRIBUTING.md              # Contribution guidelines
│   └── workflows/
│       └── copilot-review.yml       # Automated PR reviews
├── docs/
│   ├── README.md                     # Documentation index
│   ├── getting-started.md           # This file
│   └── best-practices.md            # AI development best practices
├── examples/
│   ├── README.md                     # Examples overview
│   ├── email-validator.js           # Example code
│   └── email-validator.test.js      # Example tests
└── src/
    └── (your project code)
```

## First Steps

### 1. Read the Documentation
- [Copilot Instructions](../.github/copilot-instructions.md)
- [Review Guidelines](../.github/copilot-review-guidelines.md)
- [Best Practices](./best-practices.md)

### 2. Try the Examples
```bash
cd examples
node email-validator.test.js
```

### 3. Create Your First Feature

```bash
# Create a feature branch
git checkout -b feature/my-first-feature

# Create a new file
# Use Copilot to help you write code

# Test your changes
# Use Copilot to generate tests

# Commit and push
git add .
git commit -m "feat: add my first feature"
git push origin feature/my-first-feature
```

### 4. Open a Pull Request
- Go to GitHub
- Create a PR from your branch
- Watch the automated checks run
- Address any feedback

## Using Copilot

### Code Generation
1. Write a comment describing what you want
2. Press Enter and wait for Copilot's suggestion
3. Press Tab to accept or keep typing to refine

### Copilot Chat
- Open chat panel
- Ask questions about code
- Request code generation
- Get explanations

### Common Commands
- `/explain` - Explain selected code
- `/fix` - Suggest fixes for problems
- `/tests` - Generate tests
- `/doc` - Generate documentation

## Next Steps

Now that you're set up:

1. Explore [Examples](../examples/)
2. Read [Best Practices](./best-practices.md)
3. Check the [FAQ](./faq.md)
4. Start building with AI assistance!

## Troubleshooting

### Copilot Not Working
- Check your internet connection
- Verify Copilot subscription is active
- Restart your IDE
- Check IDE extensions are up to date

### No Suggestions Appearing
- Make sure Copilot is enabled
- Check file type is supported
- Write more descriptive comments
- Wait a moment for suggestions

### Getting Poor Suggestions
- Add more context in comments
- Review [Best Practices](./best-practices.md)
- Check [Copilot Instructions](../.github/copilot-instructions.md)
- Be more specific in your prompts

## Support

Need help?
- 📖 Read the [FAQ](./faq.md)
- 💬 Use Copilot Chat
- 🐛 [Open an issue](https://github.com/silvalvesmurillo/s-code-ai/issues)
- 📧 Contact maintainers
