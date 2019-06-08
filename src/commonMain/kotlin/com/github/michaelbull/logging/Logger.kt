package com.github.michaelbull.logging

expect interface Logger {

    fun getName(): String

    fun isTraceEnabled(): Boolean
    fun isTraceEnabled(marker: Marker?): Boolean

    fun isDebugEnabled(): Boolean
    fun isDebugEnabled(marker: Marker?): Boolean

    fun isInfoEnabled(): Boolean
    fun isInfoEnabled(marker: Marker?): Boolean

    fun isWarnEnabled(): Boolean
    fun isWarnEnabled(marker: Marker?): Boolean

    fun isErrorEnabled(): Boolean
    fun isErrorEnabled(marker: Marker?): Boolean

    fun trace(msg: String?)
    fun trace(msg: String?, t: Throwable?)
    fun trace(marker: Marker?, msg: String?)
    fun trace(marker: Marker?, msg: String?, t: Throwable?)
    fun trace(format: String?, arg: Any?)
    fun trace(format: String?, arg1: Any?, arg2: Any?)
    fun trace(format: String?, vararg arguments: Any?)
    fun trace(marker: Marker?, format: String?, arg: Any?)
    fun trace(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)
    fun trace(marker: Marker?, format: String?, vararg arguments: Any?)

    fun debug(msg: String?)
    fun debug(msg: String?, t: Throwable?)
    fun debug(marker: Marker?, msg: String?)
    fun debug(marker: Marker?, msg: String?, t: Throwable?)
    fun debug(format: String?, arg: Any?)
    fun debug(format: String?, arg1: Any?, arg2: Any?)
    fun debug(format: String?, vararg arguments: Any?)
    fun debug(marker: Marker?, format: String?, arg: Any?)
    fun debug(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)
    fun debug(marker: Marker?, format: String?, vararg arguments: Any?)

    fun info(msg: String?)
    fun info(msg: String?, t: Throwable?)
    fun info(marker: Marker?, msg: String?)
    fun info(marker: Marker?, msg: String?, t: Throwable?)
    fun info(format: String?, arg: Any?)
    fun info(format: String?, arg1: Any?, arg2: Any?)
    fun info(format: String?, vararg arguments: Any?)
    fun info(marker: Marker?, format: String?, arg: Any?)
    fun info(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)
    fun info(marker: Marker?, format: String?, vararg arguments: Any?)

    fun warn(msg: String?)
    fun warn(msg: String?, t: Throwable?)
    fun warn(marker: Marker?, msg: String?)
    fun warn(marker: Marker?, msg: String?, t: Throwable?)
    fun warn(format: String?, arg: Any?)
    fun warn(format: String?, arg1: Any?, arg2: Any?)
    fun warn(format: String?, vararg arguments: Any?)
    fun warn(marker: Marker?, format: String?, arg: Any?)
    fun warn(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)
    fun warn(marker: Marker?, format: String?, vararg arguments: Any?)

    fun error(msg: String?)
    fun error(msg: String?, t: Throwable?)
    fun error(marker: Marker?, msg: String?)
    fun error(marker: Marker?, msg: String?, t: Throwable?)
    fun error(format: String?, arg: Any?)
    fun error(format: String?, arg1: Any?, arg2: Any?)
    fun error(format: String?, vararg arguments: Any?)
    fun error(marker: Marker?, format: String?, arg: Any?)
    fun error(marker: Marker?, format: String?, arg1: Any?, arg2: Any?)
    fun error(marker: Marker?, format: String?, vararg arguments: Any?)
}
