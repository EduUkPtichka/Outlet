import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.android.library.plugin)
    alias(libs.plugins.jetbrains.compose.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.plugin.serialization)
    alias(libs.plugins.google.ksp.plugin)
    alias(libs.plugins.touchlab.skie.plugin)
    alias(libs.plugins.moko.mobile.multiplatform.resources)
}

dependencies {
    add("kspCommonMainMetadata", libs.arrow.optics.ksp.plugin)
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

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {

        commonMain.dependencies {

            // Decompose
            implementation(libs.arkivanov.decompose)
            //implementation(libs.arkivanov.decompose.extensionsCompose)

            // Jetbrains
            implementation(libs.jetbrains.kotlinxCollectionsImmutable)
            implementation(libs.jetbrains.kotlinx.coroutines.core)

            // Touchlab
            implementation(libs.touchlab.skie.configurationAnnotations)

            // Arrow
            implementation(libs.arrow.core)
            implementation(libs.arrow.fx.coroutines)
            implementation(libs.arrow.optics)

            api(project(":common-resource"))
        }

        androidMain.dependencies {

        }

        iosMain.dependencies {
        }

    }

}

android {
    namespace = "determent.outlet.reg_block_decompose"

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
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    dependencies {
    }
}


