package com.sx.core

class Logger(
    private val tag: String,
    private val isDebug: Boolean = true
) {
    companion object LoggerFactory {
        fun buildDebug(tag: String): Logger {
            return Logger(tag)
        }

        fun buildRelease(tag: String): Logger {
            return Logger(tag, isDebug = false)
        }
    }

    fun log(message: String) {
        if(!isDebug) {
            //Use Crashlytics or similar service and send them to Production log service
        } else {
            printLogD(tag, message)
        }
    }

    fun printLogD(tag: String, message: String) {
        println("$tag: $message")
    }
}