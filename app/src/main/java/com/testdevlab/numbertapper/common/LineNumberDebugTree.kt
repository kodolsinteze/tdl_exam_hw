package com.testdevlab.numbertapper.common

import timber.log.Timber

private const val TIMBER_TAG = "Lingo"

class LineNumberDebugTree : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement) =
        "$TIMBER_TAG: (${element.fileName}:${element.lineNumber}) #${element.methodName} "
}
