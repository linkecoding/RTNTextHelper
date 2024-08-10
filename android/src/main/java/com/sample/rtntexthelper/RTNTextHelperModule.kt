package com.sample.rtntexthelper

import android.graphics.Paint
import android.graphics.Typeface
import android.text.TextUtils
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.WritableMap
import com.facebook.react.bridge.WritableNativeMap

class RTNTextHelperModule(reactContext: ReactApplicationContext) :
    NativeRTNTextHelperSpec(reactContext) {
    companion object {
        const val NAME = "RTNTextHelper"
    }

    override fun getName() = NAME

    override fun measureTextAsync(textInfo: ReadableMap?, promise: Promise?) {
        val width = getTextWidth(textInfo)
        val result = WritableNativeMap()
        result.putDouble("width", width)
        promise?.resolve(result)
    }

    override fun measureTextSync(textInfo: ReadableMap?): WritableMap {
        val width = getTextWidth(textInfo)
        val result = WritableNativeMap()
        result.putDouble("width", width)
        return result
    }

    private fun getTextWidth(textInfo: ReadableMap?): Double {
        return textInfo?.let {
            val text = it.getString("text")
            val fontSize = it.getInt("fontSize")
            val fontFamily = it.getString("fontFamily")
            val paint = Paint()
            paint.textSize = fontSize.toFloat()
            if (!TextUtils.isEmpty(fontFamily)) {
                paint.typeface = Typeface.create(fontFamily, Typeface.NORMAL)
            }
            val width = paint.measureText(text)
            return@let width.toDouble()
        } ?: 0.0
    }
}