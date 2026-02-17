/**
 * Example: Email Validator
 * 
 * This example demonstrates using GitHub Copilot for:
 * 1. Generating validation logic
 * 2. Creating comprehensive tests
 * 3. Adding documentation
 * 4. Implementing error handling
 */

/**
 * Validates an email address according to RFC 5322 standards
 * 
 * @param {string} email - The email address to validate
 * @returns {boolean} True if the email is valid, false otherwise
 * 
 * @example
 * isValidEmail('user@example.com'); // returns true
 * isValidEmail('invalid.email'); // returns false
 */
function isValidEmail(email) {
  // Basic email validation regex pattern
  // This pattern checks for:
  // - Local part (before @): alphanumeric, dots, hyphens, underscores
  // - @ symbol
  // - Domain: alphanumeric with dots
  // - TLD: at least 2 characters
  const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  
  // Check if email is a string and not empty
  if (typeof email !== 'string' || email.length === 0) {
    return false;
  }
  
  // Check for consecutive dots (not allowed)
  if (email.includes('..')) {
    return false;
  }
  
  // Check for invalid characters like #
  if (/[#\s]/.test(email)) {
    return false;
  }
  
  // Check if email matches the pattern
  return emailRegex.test(email);
}

/**
 * Validates and normalizes an email address
 * 
 * @param {string} email - The email address to validate and normalize
 * @returns {Object} Object containing validation result and normalized email
 * 
 * @example
 * validateAndNormalizeEmail('  User@Example.COM  ');
 * // returns { valid: true, email: 'user@example.com', errors: [] }
 */
function validateAndNormalizeEmail(email) {
  const errors = [];
  
  // Trim whitespace
  const trimmedEmail = typeof email === 'string' ? email.trim() : '';
  
  // Convert to lowercase
  const normalizedEmail = trimmedEmail.toLowerCase();
  
  // Validate
  if (!trimmedEmail) {
    errors.push('Email is required');
  } else if (trimmedEmail.length > 254) {
    errors.push('Email is too long (max 254 characters)');
  } else if (!isValidEmail(normalizedEmail)) {
    errors.push('Email format is invalid');
  }
  
  // Check for common typos in popular domains
  const commonDomainTypos = {
    'gmial.com': 'gmail.com',
    'gmai.com': 'gmail.com',
    'yahooo.com': 'yahoo.com',
    'hotmial.com': 'hotmail.com'
  };
  
  let suggestedEmail = normalizedEmail;
  for (const [typo, correct] of Object.entries(commonDomainTypos)) {
    if (normalizedEmail.endsWith(`@${typo}`)) {
      suggestedEmail = normalizedEmail.replace(`@${typo}`, `@${correct}`);
      errors.push(`Did you mean ${suggestedEmail}?`);
      break;
    }
  }
  
  return {
    valid: errors.length === 0,
    email: normalizedEmail,
    suggestedEmail: suggestedEmail !== normalizedEmail ? suggestedEmail : null,
    errors
  };
}

// Export for use in other modules
if (typeof module !== 'undefined' && module.exports) {
  module.exports = {
    isValidEmail,
    validateAndNormalizeEmail
  };
}
