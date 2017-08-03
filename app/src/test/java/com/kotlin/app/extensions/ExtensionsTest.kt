package com.kotlin.app.extensions

import org.junit.Test
import org.junit.Assert.assertEquals
import java.text.DateFormat

class ExtensionsTest {

    @Test fun testLongToDateString() {
        assertEquals("19-Oct-2015", 1445275635000L.toDateString())
    }

    @Test fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015", 1445275635000L.toDateString(DateFormat.FULL))
    }
}