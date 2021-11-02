package com.github.michaelbull.logging

import kotlin.jvm.JvmInline
import kotlin.reflect.KClass

expect inline fun InlineLogger(): InlineLogger
expect inline fun InlineLogger(name: String): InlineLogger
expect inline fun <T : Any> InlineLogger(clazz: KClass<T>): InlineLogger

@JvmInline
@Suppress("unused", "DeprecatedCallableAddReplaceWith")
value class InlineLogger(val delegate: Logger) {

    val name: String get() = delegate.getName()

    val isTraceEnabled: Boolean get() = delegate.isTraceEnabled()
    fun isTraceEnabled(marker: Marker?): Boolean = delegate.isTraceEnabled(marker)

    val isDebugEnabled: Boolean get() = delegate.isDebugEnabled()
    fun isDebugEnabled(marker: Marker?): Boolean = delegate.isDebugEnabled(marker)

    val isInfoEnabled: Boolean get() = delegate.isInfoEnabled()
    fun isInfoEnabled(marker: Marker?): Boolean = delegate.isInfoEnabled(marker)

    val isWarnEnabled: Boolean get() = delegate.isWarnEnabled()
    fun isWarnEnabled(marker: Marker?): Boolean = delegate.isWarnEnabled(marker)

    val isErrorEnabled: Boolean get() = delegate.isErrorEnabled()
    fun isErrorEnabled(marker: Marker?): Boolean = delegate.isErrorEnabled(marker)

    inline fun trace(msg: () -> Any?) {
        if (isTraceEnabled) {
            delegate.trace(msg().toString())
        }
    }

    inline fun trace(t: Throwable?, msg: () -> Any?) {
        if (isTraceEnabled) {
            delegate.trace(msg().toString(), t)
        }
    }

    inline fun trace(marker: Marker?, msg: () -> Any?) {
        if (isTraceEnabled(marker)) {
            delegate.trace(marker, msg().toString())
        }
    }

    inline fun trace(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isTraceEnabled(marker)) {
            delegate.trace(marker, msg().toString(), t)
        }
    }

    inline fun debug(msg: () -> Any?) {
        if (isDebugEnabled) {
            delegate.debug(msg().toString())
        }
    }

    inline fun debug(t: Throwable?, msg: () -> Any?) {
        if (isDebugEnabled) {
            delegate.debug(msg().toString(), t)
        }
    }

    inline fun debug(marker: Marker?, msg: () -> Any?) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, msg().toString())
        }
    }

    inline fun debug(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, msg().toString(), t)
        }
    }

    inline fun info(msg: () -> Any?) {
        if (isInfoEnabled) {
            delegate.info(msg().toString())
        }
    }

    inline fun info(t: Throwable?, msg: () -> Any?) {
        if (isInfoEnabled) {
            delegate.info(msg().toString(), t)
        }
    }

    inline fun info(marker: Marker?, msg: () -> Any?) {
        if (isInfoEnabled(marker)) {
            delegate.info(marker, msg().toString())
        }
    }

    inline fun info(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isInfoEnabled(marker)) {
            delegate.info(marker, msg().toString(), t)
        }
    }

    inline fun warn(msg: () -> Any?) {
        if (isWarnEnabled) {
            delegate.warn(msg().toString())
        }
    }

    inline fun warn(t: Throwable?, msg: () -> Any?) {
        if (isWarnEnabled) {
            delegate.warn(msg().toString(), t)
        }
    }

    inline fun warn(marker: Marker?, msg: () -> Any?) {
        if (isWarnEnabled(marker)) {
            delegate.warn(marker, msg().toString())
        }
    }

    inline fun warn(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isWarnEnabled(marker)) {
            delegate.warn(marker, msg().toString(), t)
        }
    }

    inline fun error(msg: () -> Any?) {
        if (isErrorEnabled) {
            delegate.error(msg().toString())
        }
    }

    inline fun error(t: Throwable?, msg: () -> Any?) {
        if (isErrorEnabled) {
            delegate.error(msg().toString(), t)
        }
    }

    inline fun error(marker: Marker?, msg: () -> Any?) {
        if (isErrorEnabled(marker)) {
            delegate.error(marker, msg().toString())
        }
    }

    inline fun error(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isErrorEnabled(marker)) {
            delegate.error(marker, msg().toString(), t)
        }
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace { msg }"))
    fun trace(msg: String?) {
        delegate.trace(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(t) { msg }"))
    fun trace(msg: String?, t: Throwable?) {
        delegate.trace(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker) { msg }"))
    fun trace(marker: Marker?, msg: String?) {
        delegate.trace(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker, t) { msg }"))
    fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.trace(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(format: String?, arg: Any?) {
        delegate.trace(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(format: String?, arg1: Any?, arg2: Any?) {
        delegate.trace(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(format: String?, vararg arguments: Any?) {
        delegate.trace(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(marker: Marker?, format: String?, arg: Any?) {
        delegate.trace(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.trace(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun trace(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.trace(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug { msg }"))
    fun debug(msg: String?) {
        delegate.debug(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(t) { msg }"))
    fun debug(msg: String?, t: Throwable?) {
        delegate.debug(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker) { msg }"))
    fun debug(marker: Marker?, msg: String?) {
        delegate.debug(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker, t) { msg }"))
    fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.debug(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(format: String?, arg: Any?) {
        delegate.debug(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(format: String?, arg1: Any?, arg2: Any?) {
        delegate.debug(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(format: String?, vararg arguments: Any?) {
        delegate.debug(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(marker: Marker?, format: String?, arg: Any?) {
        delegate.debug(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.debug(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.debug(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info { msg }"))
    fun info(msg: String?) {
        delegate.info(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(t) { msg }"))
    fun info(msg: String?, t: Throwable?) {
        delegate.info(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker) { msg }"))
    fun info(marker: Marker?, msg: String?) {
        delegate.info(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker, t) { msg }"))
    fun info(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.info(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(format: String?, arg: Any?) {
        delegate.info(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(format: String?, arg1: Any?, arg2: Any?) {
        delegate.info(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(format: String?, vararg arguments: Any?) {
        delegate.info(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(marker: Marker?, format: String?, arg: Any?) {
        delegate.info(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.info(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.info(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn { msg }"))
    fun warn(msg: String?) {
        delegate.warn(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(t) { msg }"))
    fun warn(msg: String?, t: Throwable?) {
        delegate.warn(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker) { msg }"))
    fun warn(marker: Marker?, msg: String?) {
        delegate.warn(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker, t) { msg }"))
    fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.warn(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(format: String?, arg: Any?) {
        delegate.warn(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(format: String?, arg1: Any?, arg2: Any?) {
        delegate.warn(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(format: String?, vararg arguments: Any?) {
        delegate.warn(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(marker: Marker?, format: String?, arg: Any?) {
        delegate.warn(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.warn(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.warn(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error { msg }"))
    fun error(msg: String?) {
        delegate.error(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(t) { msg }"))
    fun error(msg: String?, t: Throwable?) {
        delegate.error(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker) { msg }"))
    fun error(marker: Marker?, msg: String?) {
        delegate.error(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker, t) { msg }"))
    fun error(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.error(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(format: String?, arg: Any?) {
        delegate.error(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(format: String?, arg1: Any?, arg2: Any?) {
        delegate.error(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(format: String?, vararg arguments: Any?) {
        delegate.error(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(marker: Marker?, format: String?, arg: Any?) {
        delegate.error(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.error(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.error(marker, format, *arguments)
    }
}
