import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    alias(libs.plugins.android.library.plugin)
    alias(libs.plugins.jetbrains.compose.multiplatform.plugin)
    alias(libs.plugins.jetbrains.kotlin.multiplatform.plugin)
    alias(libs.plugins.moko.mobile.multiplatform.resources)
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