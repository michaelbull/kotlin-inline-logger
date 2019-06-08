@file:Suppress("unused")

package com.github.michaelbull.logging

import kotlin.test.Test
import kotlin.test.assertEquals

class InlineLoggerTest {

    @Test
    fun `underlying logger uses the name passed to InlineLogger`() {
        val logger = InlineLogger("this.is.a.logger")
        assertEquals("this.is.a.logger", logger.name)
    }

    @Test
    fun `underlying logger uses the name of the Class passed to InlineLogger`() {
        val logger = InlineLogger(InlineLoggerTest::class)
        assertEquals("com.github.michaelbull.logging.InlineLoggerTest", logger.name)
    }

    @Test
    fun `underlying logger uses the name of the invoking class`() {
        val logger = InlineLogger()
        assertEquals("com.github.michaelbull.logging.InlineLoggerTest", logger.name)
    }

}
