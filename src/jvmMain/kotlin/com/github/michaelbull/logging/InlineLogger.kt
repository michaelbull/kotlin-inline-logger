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


@Suppress("unused", "DeprecatedCallableAddReplaceWith")
@JvmInline
actual value class InlineLogger(val delegate: Logger) {
    val name: String get() = delegate.name

    val isTraceEnabled: Boolean get() = delegate.isTraceEnabled
    actual fun isTraceEnabled(marker: Marker?): Boolean = delegate.isTraceEnabled(marker)

    val isDebugEnabled: Boolean get() = delegate.isDebugEnabled
    actual fun isDebugEnabled(marker: Marker?): Boolean = delegate.isDebugEnabled(marker)

    val isInfoEnabled: Boolean get() = delegate.isInfoEnabled
    actual fun isInfoEnabled(marker: Marker?): Boolean = delegate.isInfoEnabled(marker)

    val isWarnEnabled: Boolean get() = delegate.isWarnEnabled
    actual fun isWarnEnabled(marker: Marker?): Boolean = delegate.isWarnEnabled(marker)

    val isErrorEnabled: Boolean get() = delegate.isErrorEnabled
    actual fun isErrorEnabled(marker: Marker?): Boolean = delegate.isErrorEnabled(marker)

    actual inline fun trace(msg: () -> Any?) {
        if (isTraceEnabled) {
            delegate.trace(msg().toString())
        }
    }

    actual inline fun trace(t: Throwable?, msg: () -> Any?) {
        if (isTraceEnabled) {
            delegate.trace(msg().toString(), t)
        }
    }

    actual inline fun trace(marker: Marker?, msg: () -> Any?) {
        if (isTraceEnabled(marker)) {
            delegate.trace(marker, msg().toString())
        }
    }

    actual inline fun trace(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isTraceEnabled(marker)) {
            delegate.trace(marker, msg().toString(), t)
        }
    }

    actual inline fun debug(msg: () -> Any?) {
        if (isDebugEnabled) {
            delegate.debug(msg().toString())
        }
    }

    actual inline fun debug(t: Throwable?, msg: () -> Any?) {
        if (isDebugEnabled) {
            delegate.debug(msg().toString(), t)
        }
    }

    actual inline fun debug(marker: Marker?, msg: () -> Any?) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, msg().toString())
        }
    }

    actual inline fun debug(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isDebugEnabled(marker)) {
            delegate.debug(marker, msg().toString(), t)
        }
    }

    actual inline fun info(msg: () -> Any?) {
        if (isInfoEnabled) {
            delegate.info(msg().toString())
        }
    }

    actual inline fun info(t: Throwable?, msg: () -> Any?) {
        if (isInfoEnabled) {
            delegate.info(msg().toString(), t)
        }
    }

    actual inline fun info(marker: Marker?, msg: () -> Any?) {
        if (isInfoEnabled(marker)) {
            delegate.info(marker, msg().toString())
        }
    }

    actual inline fun info(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isInfoEnabled(marker)) {
            delegate.info(marker, msg().toString(), t)
        }
    }

    actual inline fun warn(msg: () -> Any?) {
        if (isWarnEnabled) {
            delegate.warn(msg().toString())
        }
    }

    actual inline fun warn(t: Throwable?, msg: () -> Any?) {
        if (isWarnEnabled) {
            delegate.warn(msg().toString(), t)
        }
    }

    actual inline fun warn(marker: Marker?, msg: () -> Any?) {
        if (isWarnEnabled(marker)) {
            delegate.warn(marker, msg().toString())
        }
    }

    actual inline fun warn(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isWarnEnabled(marker)) {
            delegate.warn(marker, msg().toString(), t)
        }
    }

    actual inline fun error(msg: () -> Any?) {
        if (isErrorEnabled) {
            delegate.error(msg().toString())
        }
    }

    actual inline fun error(t: Throwable?, msg: () -> Any?) {
        if (isErrorEnabled) {
            delegate.error(msg().toString(), t)
        }
    }

    actual inline fun error(marker: Marker?, msg: () -> Any?) {
        if (isErrorEnabled(marker)) {
            delegate.error(marker, msg().toString())
        }
    }

    actual inline fun error(marker: Marker?, t: Throwable?, msg: () -> Any?) {
        if (isErrorEnabled(marker)) {
            delegate.error(marker, msg().toString(), t)
        }
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace { msg }"))
    actual fun trace(msg: String?) {
        delegate.trace(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(t) { msg }"))
    actual fun trace(msg: String?, t: Throwable?) {
        delegate.trace(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker) { msg }"))
    actual fun trace(marker: Marker?, msg: String?) {
        delegate.trace(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("trace(marker, t) { msg }"))
    actual fun trace(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.trace(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun trace(format: String?, arg: Any?) {
        delegate.trace(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun trace(format: String?, arg1: Any?, arg2: Any?) {
        delegate.trace(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun trace(format: String?, vararg arguments: Any?) {
        delegate.trace(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun trace(marker: Marker?, format: String?, arg: Any?) {
        delegate.trace(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.trace(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun trace(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.trace(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug { msg }"))
    actual fun debug(msg: String?) {
        delegate.debug(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(t) { msg }"))
    actual fun debug(msg: String?, t: Throwable?) {
        delegate.debug(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker) { msg }"))
    actual fun debug(marker: Marker?, msg: String?) {
        delegate.debug(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("debug(marker, t) { msg }"))
    actual fun debug(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.debug(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun debug(format: String?, arg: Any?) {
        delegate.debug(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun debug(format: String?, arg1: Any?, arg2: Any?) {
        delegate.debug(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun debug(format: String?, vararg arguments: Any?) {
        delegate.debug(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun debug(marker: Marker?, format: String?, arg: Any?) {
        delegate.debug(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.debug(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun debug(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.debug(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info { msg }"))
    actual fun info(msg: String?) {
        delegate.info(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(t) { msg }"))
    actual fun info(msg: String?, t: Throwable?) {
        delegate.info(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker) { msg }"))
    actual fun info(marker: Marker?, msg: String?) {
        delegate.info(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("info(marker, t) { msg }"))
    actual fun info(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.info(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun info(format: String?, arg: Any?) {
        delegate.info(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun info(format: String?, arg1: Any?, arg2: Any?) {
        delegate.info(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun info(format: String?, vararg arguments: Any?) {
        delegate.info(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun info(marker: Marker?, format: String?, arg: Any?) {
        delegate.info(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.info(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun info(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.info(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn { msg }"))
    actual fun warn(msg: String?) {
        delegate.warn(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(t) { msg }"))
    actual fun warn(msg: String?, t: Throwable?) {
        delegate.warn(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker) { msg }"))
    actual fun warn(marker: Marker?, msg: String?) {
        delegate.warn(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("warn(marker, t) { msg }"))
    actual fun warn(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.warn(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun warn(format: String?, arg: Any?) {
        delegate.warn(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun warn(format: String?, arg1: Any?, arg2: Any?) {
        delegate.warn(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun warn(format: String?, vararg arguments: Any?) {
        delegate.warn(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun warn(marker: Marker?, format: String?, arg: Any?) {
        delegate.warn(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.warn(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun warn(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.warn(marker, format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error { msg }"))
    actual fun error(msg: String?) {
        delegate.error(msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(t) { msg }"))
    actual fun error(msg: String?, t: Throwable?) {
        delegate.error(msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker) { msg }"))
    actual fun error(marker: Marker?, msg: String?) {
        delegate.error(marker, msg)
    }

    @Deprecated(message = "Replace with lazy equivalent", replaceWith = ReplaceWith("error(marker, t) { msg }"))
    actual fun error(marker: Marker?, msg: String?, t: Throwable?) {
        delegate.error(marker, msg, t)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun error(format: String?, arg: Any?) {
        delegate.error(format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun error(format: String?, arg1: Any?, arg2: Any?) {
        delegate.error(format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun error(format: String?, vararg arguments: Any?) {
        delegate.error(format, *arguments)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun error(marker: Marker?, format: String?, arg: Any?) {
        delegate.error(marker, format, arg)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?) {
        delegate.error(marker, format, arg1, arg2)
    }

    @Deprecated(message = "Replace with lazy equivalent")
    actual fun error(marker: Marker?, format: String?, vararg arguments: Any?) {
        delegate.error(marker, format, *arguments)
    }
}
