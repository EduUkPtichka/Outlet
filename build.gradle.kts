plugins {
    alias(libs.plugins.android.library.plugin) apply false
    alias(libs.plugins.jetbrains.compose.multiplatform.plugin) apply false
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin) apply false
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods.plugin) apply false
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization) apply false
    alias(libs.plugins.google.ksp.plugin) apply false
    alias(libs.plugins.touchlab.skie.plugin) apply false
    alias(libs.plugins.moko.mobile.multiplatform.resources) apply false
}

buildscript {
    dependencies {
        classpath(libs.mokoResourcesGenerator)
    }
}