package com.sample.rtntexthelper

import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class RTNTextHelperPackage : TurboReactPackage() {
    override fun getModule(name: String, reactContext: ReactApplicationContext): NativeModule? =
        if (name == RTNTextHelperModule.NAME) {
            RTNTextHelperModule(reactContext)
        } else {
            null
        }

    override fun getReactModuleInfoProvider() = ReactModuleInfoProvider {
        mapOf(
            RTNTextHelperModule.NAME to ReactModuleInfo(
                RTNTextHelperModule.NAME,
                RTNTextHelperModule.Companion::class.java.simpleName,
                false,
                false,
                false,
                true
            )
        )
    }
}
