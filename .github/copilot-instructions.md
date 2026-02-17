# GitHub Copilot Instructions for s-code-ai

## Project Overview
This is an AI-oriented development project that leverages GitHub Copilot for intelligent code assistance and automated PR reviews.

## Code Style and Standards

### General Principles
- Write clean, maintainable, and well-documented code
- Follow SOLID principles and design patterns
- Prefer composition over inheritance
- Keep functions small and focused (single responsibility)
- Use descriptive variable and function names

### Documentation
- Add JSDoc/docstrings for all public functions and classes
- Include inline comments for complex logic
- Maintain up-to-date README files in each major directory
- Document API endpoints with request/response examples

### Testing
- Write unit tests for all new features
- Aim for at least 80% code coverage
- Include integration tests for critical workflows
- Test edge cases and error conditions
- Use descriptive test names that explain the scenario

### Security
- Never commit secrets, API keys, or credentials
- Validate and sanitize all user inputs
- Use environment variables for configuration
- Follow the principle of least privilege
- Keep dependencies up to date

### Performance
- Optimize for readability first, then performance
- Profile before optimizing
- Avoid premature optimization
- Use appropriate data structures and algorithms

## AI-Assisted Development Guidelines

### When Reviewing Code
- Check for potential bugs and edge cases
- Verify proper error handling
- Ensure code follows project conventions
- Look for security vulnerabilities
- Suggest performance improvements where applicable
- Validate test coverage

### When Generating Code
- Follow existing patterns in the codebase
- Generate comprehensive tests alongside implementation
- Include appropriate error handling
- Add meaningful comments and documentation
- Consider edge cases and error scenarios

### When Refactoring
- Maintain backward compatibility where possible
- Update related tests and documentation
- Ensure no functionality is broken
- Improve code readability and maintainability

## Project-Specific Guidelines

### Pull Request Requirements
- All PRs must include tests
- All tests must pass
- Code coverage should not decrease
- Documentation must be updated
- Follow conventional commit messages

### Commit Message Format
```
type(scope): subject

body

footer
```

Types: feat, fix, docs, style, refactor, test, chore

### Branch Naming Convention
- `feature/description` - for new features
- `fix/description` - for bug fixes
- `docs/description` - for documentation
- `refactor/description` - for refactoring
- `test/description` - for test additions/modifications

## Review Checklist

When reviewing PRs, ensure:
- [ ] Code follows project style guidelines
- [ ] All tests pass
- [ ] New features have tests
- [ ] Documentation is updated
- [ ] No security vulnerabilities introduced
- [ ] Performance impact is acceptable
- [ ] Error handling is appropriate
- [ ] Code is maintainable and readable
- [ ] No hardcoded values or secrets
- [ ] Dependencies are justified and secure

## Common Patterns to Follow

### Error Handling
```javascript
try {
  // Operation
} catch (error) {
  logger.error('Context-specific error message', { error, context });
  throw new CustomError('User-friendly message', { cause: error });
}
```

### Async Operations
- Use async/await over raw promises
- Always handle errors in async functions
- Avoid callback hell

### Configuration
- Use environment variables
- Provide sensible defaults
- Validate configuration at startup

## Resources
- Project Wiki: [Link to wiki]
- Style Guide: [Link to style guide]
- Architecture Documentation: [Link to architecture docs]
