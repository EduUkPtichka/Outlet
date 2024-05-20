plugins {
    alias(libs.plugins.android.library.plugin) apply false
    alias(libs.plugins.jetbrains.compose.multiplatform.plugin) apply false
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin) apply false
    alias(libs.plugins.moko.mobile.multiplatform.resources) apply false
}

buildscript {
    dependencies {
        classpath(libs.mokoResourcesGenerator)
    }
}