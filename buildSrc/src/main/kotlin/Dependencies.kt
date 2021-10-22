object DefaultConfig {
    const val COMPILE_SDK   = 31
    const val MIN_SDK       = 21
    const val TARGET_SDK    = 31
    const val VERSION_CODE  = 1
    const val VERSION_NAME  = "1.0"
}


object Versions {
    const val KOTLIN_VERSION = "1.5.31"
    const val CORE_KTX_VERSION = "1.6.0"
    const val APP_COMPAT_VERSION =  "1.3.1"
    const val MATERIAL_VERSION = "1.4.0"
    const val CONSTRAINT_LAYOUT_VERSION = "2.1.1"
    const val SUPPORT_VERSION =  "1.0.0"
    const val NAVIGATION_VERSION = "2.3.5"
    const val RECYCLERVIEW_VERSION = "1.2.1"
    const val CARD_VIEW_VERSION = "1.0.0"
    const val ROUNDED_IMAGE_VIEW_VERSION = "2.3.0"
    const val RETROFIT_VERSION = "2.9.0"
    const val OKHTTP_VERSION = "5.0.0-alpha.2"
    const val LIFECYCLE_VERSION = "2.3.1"
    const val ACTIVITY_KTX_VERSION = "1.3.1"
    const val COROUTINES_VERSION = "1.5.1"
    const val PAGING_VERSION = "3.1.0-alpha04"
    const val DAGGER_HILT_VERSION = "2.38.1"
    const val DAGGER_HILT_LIFECYCLE_VERSION = "1.0.0-alpha03"
}

object Libs {
    const val kotlinGradlePlugin          = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}"
    const val androidCoreKtx              = "androidx.core:core-ktx:${Versions.CORE_KTX_VERSION}"
    const val appCompat                   = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val material                    = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val constraintLayout            = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    const val legacySupport               = "androidx.legacy:legacy-support-v4:${Versions.SUPPORT_VERSION}"
    const val navigationFragmentKtx       = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    const val navigationUiKtx             = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    const val navigationPlugin            = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION_VERSION}"
    const val recyclerview                = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW_VERSION}"
    const val roundedImageView            = "com.makeramen:roundedimageview:${Versions.ROUNDED_IMAGE_VIEW_VERSION}"
    const val lifecycleRuntimeKtx         = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleLivedataKtx        = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleViewModelKtx       = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    const val lifecycleCommon             = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFECYCLE_VERSION}"
    const val activityKtx                 = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX_VERSION}"
    const val pagingRuntimeKtx            = "androidx.paging:paging-runtime-ktx:${Versions.PAGING_VERSION}"
    const val hiltAndroid                 = "com.google.dagger:hilt-android:${Versions.DAGGER_HILT_VERSION}"
    const val hiltCompiler                = "com.google.dagger:hilt-compiler:${Versions.DAGGER_HILT_VERSION}"
    const val hiltPlugin                  = "com.google.dagger:hilt-android-gradle-plugin:${Versions.DAGGER_HILT_VERSION}"
    const val hiltLifecycle               = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.DAGGER_HILT_LIFECYCLE_VERSION}"
    const val coroutinesCore              = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
    const val coroutinesAndroid           = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    const val retrofit                    = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val gsonConverter               = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
    const val okhttp                      = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP_VERSION}"
    const val loggingInterceptor          = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_VERSION}"

}