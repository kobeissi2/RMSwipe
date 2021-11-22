plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

val composeVersion = "1.0.5"

android.run  {
    compileSdk = 31

    defaultConfig.run {
        applicationId("com.kobeissidev.rmswipe")
        minSdk = 24
        targetSdk = compileSdk
        versionCode(1)
        versionName("1.0")

        testInstrumentationRunner("androidx.test.runner.AndroidJUnitRunner")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes.run {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    composeOptions.kotlinCompilerExtensionVersion = composeVersion
    kotlinOptions.jvmTarget = "1.8"
    buildFeatures.compose = true

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-extended:$composeVersion")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("com.google.dagger:hilt-android:2.40.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-beta01")
    implementation("io.coil-kt:coil-compose:1.4.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.2")
    implementation("com.squareup.moshi:moshi:1.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("androidx.room:room-runtime:2.4.0-alpha04")
    implementation("androidx.room:room-ktx:2.4.0-alpha04")
    implementation("io.github.kaustubhpatange:autobindings-room:1.1-beta05")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")

    kapt("com.google.dagger:hilt-android-compiler:2.40.1")
    kapt("androidx.room:room-compiler:2.4.0-alpha04")
    kapt("io.github.kaustubhpatange:autobindings-compiler:1.1-beta05")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")
}