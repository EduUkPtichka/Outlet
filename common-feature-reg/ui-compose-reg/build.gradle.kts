import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBuildType
import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.android.library.plugin)
    alias(libs.plugins.jetbrains.compose.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.native.cocoapods.plugin)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.moko.mobile.multiplatform.resources)
}

kotlin {

    cocoapods {
        version = "1.0"
        name = "cocoa_pod_ui_compose_reg"
        ios.deploymentTarget = "15.0"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "ui_compose_reg"

            export(libs.arkivanov.decompose)
            export(libs.arkivanov.essenty.lifecycle)
            export(libs.arkivanov.essenty.stateKeeper)

            export(libs.moko.resources)
            export(libs.moko.graphics)
        }
    }

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

    iosX64()
    iosArm64()
    iosSimulatorArm64()


    sourceSets {

        commonMain.dependencies {
            // Compose Multiplatform
            implementation(libs.jetbrains.composeRuntime)
            implementation(libs.jetbrains.composeFoundation)
            implementation(libs.jetbrains.composeMaterial3)
            implementation(libs.jetbrains.composeMaterial)
            implementation(libs.jetbrains.composeUi)

            // Jetbrains
            implementation(libs.jetbrains.kotlinxCollectionsImmutable)

            // Decompose
            implementation(libs.arkivanov.decompose)
            implementation(libs.arkivanov.decompose.extensionsCompose)


            api(project(":common-feature-reg:block-decompose-reg"))
        }

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)

        }

    }

}

android {
    namespace = "determent.outlet.reg_compose_ui"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13"
    }

    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}
