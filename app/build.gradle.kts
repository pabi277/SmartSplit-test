// The app's own recipe card: name, versions, and libraries.
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.pabi.splitsmart"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pabi.splitsmart"
        minSdk = 24          // Android 7.0+ — same floor as CodeC
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true       // we draw the UI with Jetpack Compose
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation(platform("androidx.compose:compose-bom:2024.09.03"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")

    // The test library — only used by files in src/test/
    testImplementation("junit:junit:4.13.2")
}
