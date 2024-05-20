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

            //Jetbrains
            implementation(libs.jetbrains.kotlinxCollectionsImmutable)

            api(project(":common-resource"))
        }

        androidMain.dependencies {
            implementation(libs.compose.ui.tooling.preview)
        }

    }

}

android {
    namespace = "determent.outlet.reg_composeUi"

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
