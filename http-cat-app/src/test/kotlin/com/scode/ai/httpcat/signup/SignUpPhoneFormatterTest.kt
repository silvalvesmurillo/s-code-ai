package com.scode.ai.httpcat.signup

import kotlin.test.Test
import kotlin.test.assertEquals

class SignUpPhoneFormatterTest {

    @Test
    fun `given empty digits when formatting then result is empty`() {
        assertEquals("", formatBrazilianPhone(""))
    }

    @Test
    fun `given single digit when formatting then result opens parenthesis`() {
        assertEquals("(6", formatBrazilianPhone("6"))
    }

    @Test
    fun `given 2 digits when formatting then result shows area code prefix`() {
        assertEquals("(62", formatBrazilianPhone("62"))
    }

    @Test
    fun `given 3 digits when formatting then result includes closing parenthesis and space`() {
        assertEquals("(62) 9", formatBrazilianPhone("629"))
    }

    @Test
    fun `given 6 digits when formatting then result shows partial local number`() {
        assertEquals("(62) 9999", formatBrazilianPhone("629999"))
    }

    @Test
    fun `given 7 digits when formatting then result includes dash`() {
        assertEquals("(62) 9999-1", formatBrazilianPhone("6299991"))
    }

    @Test
    fun `given 10 digits when formatting then result is full Brazilian phone format`() {
        assertEquals("(62) 9999-1111", formatBrazilianPhone("6299991111"))
    }

    @Test
    fun `given different area code with 10 digits when formatting then result is correct`() {
        assertEquals("(11) 1234-5678", formatBrazilianPhone("1112345678"))
    }
}
