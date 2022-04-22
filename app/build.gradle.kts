import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")

    // Should be at the end
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.mercandalli.android.apps.sampler"
        minSdk = 23
        targetSdk = 31
        versionCode = 1
        versionName = "1"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = true
            isShrinkResources = true
        }
    }

    sourceSets {
        getByName("main") {
            res.srcDirs(
                "src/main/res/icon",
                "src/main/res/main"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    ndkVersion = "21.0.6113669"
    androidResources {
        noCompress("opus", "json", "png")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))

    // JetPack
    implementation("androidx.appcompat:appcompat:1.4.1")

    // Firebase
    implementation("com.google.firebase:firebase-core:20.1.2")
    implementation("com.google.firebase:firebase-analytics:20.1.2")
    implementation("com.google.firebase:firebase-database:20.0.4")
    implementation("com.google.firebase:firebase-database-ktx:20.0.4")
    implementation("com.google.firebase:firebase-crashlytics:18.2.9")

    implementation("org.json:json:20220320") // Here is the reason, mapping told me "org.json.JSONStringer"
}