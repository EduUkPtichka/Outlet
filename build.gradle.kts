plugins {
    alias(libs.plugins.androidApplicationPlugin) apply false
    alias(libs.plugins.androidLibraryPlugin) apply false
    alias(libs.plugins.jetbrainsComposeMultiplatformPlugin) apply false
    alias(libs.plugins.kotlinMultiplatformPlugin) apply false
    alias(libs.plugins.mobileMultiplatformResources) apply false
}

buildscript {
    dependencies {
        classpath(libs.mokoResourcesGenerator)
    }
}