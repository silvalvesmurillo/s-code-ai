# Contributing Guide

## Getting Started

This project uses GitHub Copilot for AI-assisted development. Make sure you have:

1. GitHub Copilot enabled in your IDE
2. Familiarity with the project's [Copilot Instructions](.github/copilot-instructions.md)
3. Understanding of our [Review Guidelines](.github/copilot-review-guidelines.md)

## Development Workflow

### 1. Create a Branch
```bash
git checkout -b feature/your-feature-name
```

Follow our [branch naming conventions](.github/copilot-instructions.md#branch-naming-convention).

### 2. Make Changes
- Use GitHub Copilot to assist with code generation
- Follow the project's coding standards
- Write tests for your changes
- Update documentation as needed

### 3. Test Your Changes
```bash
# Run tests (once test framework is set up)
npm test  # or yarn test, pytest, go test, etc.
```

### 4. Commit Your Changes
Follow the [conventional commit format](.github/copilot-instructions.md#commit-message-format):

```bash
git add .
git commit -m "feat(scope): add new feature"
```

### 5. Push and Create PR
```bash
git push origin feature/your-feature-name
```

Then create a Pull Request on GitHub.

## Using GitHub Copilot

### For Code Generation
1. Write a comment describing what you want
2. Let Copilot suggest implementation
3. Review and refine the suggestion
4. Test the generated code

### For Code Review
1. Open the PR in your IDE
2. Use Copilot to review changes
3. Ask questions about the code
4. Request improvements

### Example Prompts
- "Generate a function that validates email addresses"
- "Write unit tests for this function"
- "Refactor this code to improve readability"
- "Add error handling to this async function"
- "Review this PR for security issues"

## PR Review Process

### Automated Checks
When you create a PR, automated checks will:
- Analyze code quality
- Check for security issues
- Verify test coverage
- Post a review comment

### Manual Review
- Address feedback from automated checks
- Respond to reviewer comments
- Update your PR as needed

### Approval
Once all checks pass and reviews are addressed:
- Your PR will be approved
- It can be merged

## Best Practices

### Code Quality
- Keep functions small and focused
- Use meaningful names
- Add comments for complex logic
- Follow DRY (Don't Repeat Yourself)

### Testing
- Write tests before or alongside code
- Test edge cases
- Aim for high coverage
- Use descriptive test names

### Security
- Never commit secrets
- Validate all inputs
- Use environment variables
- Keep dependencies updated

### Documentation
- Update README for user-facing changes
- Add code comments for maintainers
- Document APIs and interfaces
- Keep changelog updated

## Getting Help

- Review [Copilot Instructions](.github/copilot-instructions.md)
- Check [Review Guidelines](.github/copilot-review-guidelines.md)
- Ask GitHub Copilot in your IDE
- Reach out to maintainers

## Tools and Resources

### IDE Setup
- Install GitHub Copilot extension
- Configure your IDE settings
- Learn keyboard shortcuts

### Useful Commands
```bash
# Check code style
npm run lint  # or your linter

# Run tests
npm test

# Build project
npm run build

# Start development server
npm run dev
```

## Questions?

If you have questions:
1. Check existing documentation
2. Ask GitHub Copilot
3. Open an issue
4. Contact maintainers
