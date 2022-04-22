// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://maven.fabric.io/public")

        // Check dependencies.
        // https://github.com/ben-manes/gradle-versions-plugin
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.1.3")
        classpath(kotlin("gradle-plugin", version = "1.6.20"))
        classpath(kotlin("serialization", version = "1.6.20")) // multi_platform_youtube
        classpath("com.google.gms:google-services:4.3.10")

        // https://firebase.google.com/docs/crashlytics/get-started?platform=android
        classpath("com.google.firebase:firebase-crashlytics-gradle:2.8.1")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://jitpack.io")
        // https://github.com/JetBrains/compose-jb
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")

        // https://github.com/Kotlin/kotlinx-datetime#gradle
        maven(url = "https://kotlin.bintray.com/kotlinx/")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
