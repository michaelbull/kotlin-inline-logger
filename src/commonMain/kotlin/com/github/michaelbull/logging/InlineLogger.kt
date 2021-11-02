package com.github.michaelbull.logging

import kotlin.reflect.KClass

expect inline fun InlineLogger(): InlineLogger
expect inline fun InlineLogger(name: String): InlineLogger
expect inline fun <T : Any> InlineLogger(clazz: KClass<T>): InlineLogger

@Suppress("unused", "DeprecatedCallableAddReplaceWith")
expect value class InlineLogger(val delegate: Logger) {

    fun isTraceEnabled(marker: Marker?): Boolean

    fun isDebugEnabled(marker: Marker?): Boolean

    fun isInfoEnabled(marker: Marker?): Boolean

    fun isWarnEnabled(marker: Marker?): Boolean

    fun isErrorEnabled(marker: Marker?): Boolean

    inline fun trace(msg: () -> Any?)

    inline fun trace(t: Throwable?, msg: () -> Any?)

    inline fun trace(marker: Marker?, msg: () -> Any?)

    inline fun trace(marker: Marker?, t: Throwable?, msg: () -> Any?)

    inline fun debug(msg: () -> Any?)

    inline fun debug(t: Throwable?, msg: () -> Any?)

    inline fun debug(marker: Marker?, msg: () -> Any?)

    inline fun debug(marker: Marker?, t: Throwable?, msg: () -> Any?)

    inline fun info(msg: () -> Any?)

    inline fun info(t: Throwable?, msg: () -> Any?)

    inline fun info(marker: Marker?, msg: () -> Any?)

    inline fun info(marker: Marker?, t: Throwable?, msg: () -> Any?)

    inline fun warn(msg: () -> Any?)

    inline fun warn(t: Throwable?, msg: () -> Any?)

    inline fun warn(marker: Marker?, msg: () -> Any?)

    inline fun warn(marker: Marker?, t: Throwable?, msg: () -> Any?)

    inline fun error(msg: () -> Any?)

    inline fun error(t: Throwable?, msg: () -> Any?)

    inline fun error(marker: Marker?, msg: () -> Any?)

    inline fun error(marker: Marker?, t: Throwable?, msg: () -> Any?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace { msg }"))
    fun trace(msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(t) { msg }"))
    fun trace(msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker) { msg }"))
    fun trace(marker: Marker?, msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker, t) { msg }"))
    fun trace(marker: Marker?, msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(marker: Marker?, format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(marker: Marker?, format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug { msg }"))
    fun debug(msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(t) { msg }"))
    fun debug(msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker) { msg }"))
    fun debug(marker: Marker?, msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker, t) { msg }"))
    fun debug(marker: Marker?, msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(marker: Marker?, format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(marker: Marker?, format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info { msg }"))
    fun info(msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(t) { msg }"))
    fun info(msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker) { msg }"))
    fun info(marker: Marker?, msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker, t) { msg }"))
    fun info(marker: Marker?, msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(marker: Marker?, format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(marker: Marker?, format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn { msg }"))
    fun warn(msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(t) { msg }"))
    fun warn(msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker) { msg }"))
    fun warn(marker: Marker?, msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker, t) { msg }"))
    fun warn(marker: Marker?, msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(marker: Marker?, format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(marker: Marker?, format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error { msg }"))
    fun error(msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(t) { msg }"))
    fun error(msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker) { msg }"))
    fun error(marker: Marker?, msg: String?)

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker, t) { msg }"))
    fun error(marker: Marker?, msg: String?, t: Throwable?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(format: String?, vararg arguments: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(marker: Marker?, format: String?, arg: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(marker: Marker?, format: String?, vararg arguments: Any?)
}
