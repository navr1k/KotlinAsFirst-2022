package lesson12.task1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag

internal class PhoneBookTest {

    @Test
    @Tag("6")
    fun addHuman() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertFalse(book.addHuman("Иванов Петр"))
    }

    @Test
    @Tag("6")
    fun removeHuman() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertTrue(book.removeHuman("Иванов Петр"))
        assertFalse(book.removeHuman("Сидорова Мария"))
    }

    @Test
    @Tag("6")
    fun addPhone() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertTrue(book.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book.addPhone("Иванов Петр", "+78121234567"))
        assertFalse(book.addPhone("Иванов Петр", "+79211234567"))
        assertFalse(book.addPhone("Васильев Дмитрий", "+79211234567"))
        assertTrue(book.addPhone("Васильев Дмитрий", "+79217654321"))
    }

    @Test
    @Tag("6")
    fun removePhone() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertTrue(book.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book.addPhone("Иванов Петр", "+78121234567"))
        assertTrue(book.addPhone("Васильев Дмитрий", "+79217654321"))
        assertTrue(book.removePhone("Иванов Петр", "+78121234567"))
        assertFalse(book.removePhone("Иванов Петр", "+78121234567"))
        assertTrue(book.removePhone("Васильев Дмитрий", "+79217654321"))
    }

    @Test
    @Tag("6")
    fun phones() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertTrue(book.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book.addPhone("Иванов Петр", "+78121234567"))
        assertEquals(setOf("+79211234567", "+78121234567"), book.phones("Иванов Петр"))
    }

    @Test
    @Tag("8")
    fun humanByPhone() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertTrue(book.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book.addPhone("Иванов Петр", "+78121234567"))
        assertTrue(book.addPhone("Васильев Дмитрий", "+79217654321"))
        assertEquals("Васильев Дмитрий", book.humanByPhone("+79217654321"))
        assertEquals("Иванов Петр", book.humanByPhone("+78121234567"))
        assertNull(book.humanByPhone("+78127654321"))
    }

    @Test
    @Tag("6")
    fun pbEquals() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertTrue(book.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book.addPhone("Иванов Петр", "+78121234567"))
        assertTrue(book.addPhone("Васильев Дмитрий", "+79217654321"))
        val book2 = PhoneBook()
        assertTrue(book2.addHuman("Васильев Дмитрий"))
        assertTrue(book2.addHuman("Иванов Петр"))
        assertTrue(book2.addPhone("Иванов Петр", "+78121234567"))
        assertTrue(book2.addPhone("Васильев Дмитрий", "+79217654321"))
        assertTrue(book2.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book == book2)
    }

    @Test
    @Tag("6")
    fun pbHashCode() {
        val book = PhoneBook()
        assertTrue(book.addHuman("Иванов Петр"))
        assertTrue(book.addHuman("Васильев Дмитрий"))
        assertTrue(book.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book.addPhone("Иванов Петр", "+78121234567"))
        assertTrue(book.addPhone("Васильев Дмитрий", "+79217654321"))
        val book2 = PhoneBook()
        assertTrue(book2.addHuman("Васильев Дмитрий"))
        assertTrue(book2.addHuman("Иванов Петр"))
        assertTrue(book2.addPhone("Иванов Петр", "+78121234567"))
        assertTrue(book2.addPhone("Васильев Дмитрий", "+79217654321"))
        assertTrue(book2.addPhone("Иванов Петр", "+79211234567"))
        assertTrue(book.hashCode() == book2.hashCode())
    }
}