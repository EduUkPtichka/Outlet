rootProject.name = "Outlet"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

// Common Core\Application
include(":common-app")
include(":common-decompose-core")

// Android
include(":android-app")

// Registration
include(":common-feature-reg:ui-compose-reg")
include(":common-feature-reg:block-decompose-reg")

// Home
include(":common-feature-home:block-decompose-home")
include(":common-feature-home:ui-compose-home")
include(":common-feature-home:remote-data-ktor-home")

include(":common-resource")