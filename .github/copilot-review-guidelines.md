# PR Review Guidelines for GitHub Copilot

## Overview
This document provides specific guidelines for automated PR reviews using GitHub Copilot and AI assistants.

## Automated Review Focus Areas

### 1. Code Quality
- **Readability**: Is the code easy to understand?
- **Maintainability**: Will this code be easy to modify later?
- **Complexity**: Are functions and classes appropriately sized?
- **Naming**: Are variables, functions, and classes well-named?

### 2. Security Checks
- **Secrets**: No hardcoded passwords, API keys, or tokens
- **Input Validation**: All user inputs are validated and sanitized
- **Authentication**: Proper authentication and authorization checks
- **Dependencies**: No known vulnerabilities in dependencies
- **Data Exposure**: Sensitive data is properly protected

### 3. Testing
- **Coverage**: New code has appropriate test coverage
- **Test Quality**: Tests are meaningful and test actual behavior
- **Edge Cases**: Edge cases and error conditions are tested
- **Integration**: Integration tests exist for critical paths

### 4. Documentation
- **Code Comments**: Complex logic is explained
- **Function Documentation**: Public APIs are documented
- **README Updates**: User-facing changes are documented
- **Changelog**: Significant changes are logged

### 5. Performance
- **Algorithms**: Appropriate algorithms for the use case
- **Database Queries**: Optimized and indexed properly
- **Caching**: Appropriate use of caching
- **Memory**: No obvious memory leaks

### 6. Error Handling
- **Try-Catch**: Appropriate error handling exists
- **Error Messages**: Clear and actionable error messages
- **Logging**: Errors are logged with sufficient context
- **Recovery**: Graceful degradation and recovery

## Review Process

### When a PR is Opened
1. Check that all required checks pass
2. Review code changes for the focus areas above
3. Leave inline comments for specific issues
4. Provide a summary comment with:
   - Overall assessment
   - Key concerns
   - Suggestions for improvement
   - Approval or request for changes

### Comment Guidelines
- Be specific and actionable
- Reference line numbers
- Explain *why* something is an issue
- Suggest concrete improvements
- Be constructive and respectful

### Example Comments

**Good Comment:**
```
Lines 45-50: This function could be vulnerable to SQL injection. 
Consider using parameterized queries instead of string concatenation.

Example:
```sql
SELECT * FROM users WHERE id = ?
```
Instead of:
```sql
SELECT * FROM users WHERE id = '${userId}'
```
```

**Poor Comment:**
```
This is bad
```

## Severity Levels

### 🔴 Critical (Must Fix)
- Security vulnerabilities
- Data loss risks
- Breaking changes without migration
- Test failures

### 🟡 Warning (Should Fix)
- Performance issues
- Missing tests
- Unclear code
- Missing documentation

### 🟢 Suggestion (Nice to Have)
- Style improvements
- Refactoring opportunities
- Additional tests
- Enhanced documentation

## Automatic Approval Criteria

A PR can be automatically approved if:
- All tests pass
- No security issues detected
- Code coverage is maintained or improved
- Documentation is updated
- Follows all style guidelines
- No critical or warning issues found

## Review Templates

### Standard Review Comment
```markdown
## AI Review Summary

### ✅ Strengths
- [List positive aspects]

### ⚠️ Concerns
- [List issues found with severity]

### 💡 Suggestions
- [List optional improvements]

### 🎯 Action Items
- [ ] [Required changes]

Overall: [APPROVED | REQUEST CHANGES | COMMENT]
```

### Security Review
```markdown
## 🔒 Security Review

### Findings
- [List security concerns]

### Recommendations
- [Specific security improvements]

### References
- [Links to security best practices]
```

### Performance Review
```markdown
## ⚡ Performance Review

### Potential Issues
- [Performance concerns]

### Optimization Suggestions
- [Specific improvements]

### Benchmarks
- [Performance metrics if available]
```

## Exclusions

Do not review:
- Auto-generated code (unless security-sensitive)
- Dependency lock files (unless there are security concerns)
- Build artifacts
- Configuration for external services (unless credentials exposed)

## Integration with CI/CD

This review process integrates with:
- GitHub Actions for automated checks
- CodeQL for security scanning
- Test coverage tools
- Linters and formatters

## Continuous Improvement

Review guidelines should be updated based on:
- Team feedback
- Common issues found
- New security threats
- Technology changes
- Project evolution
