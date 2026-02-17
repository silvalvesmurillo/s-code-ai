/**
 * Tests for Email Validator
 * 
 * These tests were generated with assistance from GitHub Copilot
 * to demonstrate comprehensive test coverage.
 */

// Import the functions to test (adjust path as needed)
const { isValidEmail, validateAndNormalizeEmail } = require('./email-validator.js');

/**
 * Simple test runner
 */
function runTests() {
  let passed = 0;
  let failed = 0;
  
  function test(description, callback) {
    try {
      callback();
      console.log(`✅ ${description}`);
      passed++;
    } catch (error) {
      console.error(`❌ ${description}`);
      console.error(`   ${error.message}`);
      failed++;
    }
  }
  
  function assertEquals(actual, expected, message) {
    if (JSON.stringify(actual) !== JSON.stringify(expected)) {
      throw new Error(
        message || `Expected ${JSON.stringify(expected)}, but got ${JSON.stringify(actual)}`
      );
    }
  }
  
  console.log('Running Email Validator Tests...\n');
  
  // Tests for isValidEmail
  console.log('--- isValidEmail() Tests ---');
  
  test('accepts valid email addresses', () => {
    assertEquals(isValidEmail('user@example.com'), true);
    assertEquals(isValidEmail('john.doe@company.co.uk'), true);
    assertEquals(isValidEmail('test_email@test-domain.com'), true);
  });
  
  test('rejects invalid email addresses', () => {
    assertEquals(isValidEmail('invalid'), false);
    assertEquals(isValidEmail('missing@domain'), false);
    assertEquals(isValidEmail('@nodomain.com'), false);
    assertEquals(isValidEmail('no-at-sign.com'), false);
  });
  
  test('handles edge cases', () => {
    assertEquals(isValidEmail(''), false);
    assertEquals(isValidEmail(null), false);
    assertEquals(isValidEmail(undefined), false);
    assertEquals(isValidEmail(123), false);
  });
  
  test('rejects emails with spaces', () => {
    assertEquals(isValidEmail('user name@example.com'), false);
    assertEquals(isValidEmail('user@exam ple.com'), false);
  });
  
  test('rejects emails with invalid characters', () => {
    assertEquals(isValidEmail('user#name@example.com'), false);
    assertEquals(isValidEmail('user@example..com'), false);
  });
  
  // Tests for validateAndNormalizeEmail
  console.log('\n--- validateAndNormalizeEmail() Tests ---');
  
  test('normalizes valid email to lowercase', () => {
    const result = validateAndNormalizeEmail('User@Example.COM');
    assertEquals(result.valid, true);
    assertEquals(result.email, 'user@example.com');
    assertEquals(result.errors.length, 0);
  });
  
  test('trims whitespace from email', () => {
    const result = validateAndNormalizeEmail('  user@example.com  ');
    assertEquals(result.valid, true);
    assertEquals(result.email, 'user@example.com');
  });
  
  test('returns errors for invalid email', () => {
    const result = validateAndNormalizeEmail('invalid-email');
    assertEquals(result.valid, false);
    assertEquals(result.errors.length > 0, true);
  });
  
  test('returns error for empty email', () => {
    const result = validateAndNormalizeEmail('');
    assertEquals(result.valid, false);
    assertEquals(result.errors.includes('Email is required'), true);
  });
  
  test('returns error for too long email', () => {
    const longEmail = 'a'.repeat(250) + '@example.com';
    const result = validateAndNormalizeEmail(longEmail);
    assertEquals(result.valid, false);
    assertEquals(result.errors.some(e => e.includes('too long')), true);
  });
  
  test('suggests corrections for common typos', () => {
    const result = validateAndNormalizeEmail('user@gmial.com');
    assertEquals(result.suggestedEmail, 'user@gmail.com');
    assertEquals(result.errors.some(e => e.includes('Did you mean')), true);
  });
  
  test('handles multiple validation errors', () => {
    const result = validateAndNormalizeEmail('');
    assertEquals(result.valid, false);
    assertEquals(result.errors.length >= 1, true);
  });
  
  // Summary
  console.log('\n--- Test Summary ---');
  console.log(`Total: ${passed + failed}`);
  console.log(`✅ Passed: ${passed}`);
  console.log(`❌ Failed: ${failed}`);
  
  if (failed === 0) {
    console.log('\n🎉 All tests passed!');
  } else {
    console.log('\n⚠️  Some tests failed');
    process.exit(1);
  }
}

// Run tests if this file is executed directly
if (require.main === module) {
  runTests();
}

module.exports = { runTests };
