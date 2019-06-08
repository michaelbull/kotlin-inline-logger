@file:Suppress("unused")

package com.github.michaelbull.logging

import org.slf4j.LoggerFactory
import java.lang.invoke.MethodHandles
import kotlin.reflect.KClass

@Suppress("NOTHING_TO_INLINE")
actual inline fun InlineLogger(): InlineLogger {
    val delegate = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass())
    return InlineLogger(delegate)
}

@Suppress("NOTHING_TO_INLINE")
actual inline fun InlineLogger(name: String): InlineLogger {
    val delegate = LoggerFactory.getLogger(name)
    return InlineLogger(delegate)
}

@Suppress("NOTHING_TO_INLINE")
actual inline fun <T : Any> InlineLogger(clazz: KClass<T>): InlineLogger {
    val delegate = LoggerFactory.getLogger(clazz.java)
    return InlineLogger(delegate)
}
