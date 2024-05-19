import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.kotlinMultiplatformPlugin)
    alias(libs.plugins.jetbrainsComposeMultiplatformPlugin)
    alias(libs.plugins.androidLibraryPlugin)
    alias(libs.plugins.mobileMultiplatformResources)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_17)
                    languageVersion.set(KotlinVersion.KOTLIN_1_9)
                }

            }
        }
    }

    sourceSets {

        commonMain.dependencies {
            api(libs.moko.resources)
            api(libs.moko.resourcesCompose)
        }

        androidMain.dependencies {

        }


    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()
}

android {
    namespace = "determent.outlet.common_resource"

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

multiplatformResources {
    resourcesPackage.set("determent.outlet.common_resource")
}