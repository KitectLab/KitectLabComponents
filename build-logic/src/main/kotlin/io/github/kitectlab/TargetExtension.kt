package io.github.kitectlab

import com.android.build.api.dsl.androidLibrary
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

@OptIn(ExperimentalWasmDsl::class, ExperimentalKotlinGradlePluginApi::class)
fun KotlinMultiplatformExtension.applyComposeTargets(
    namespace: String,
    xcfName: String = "",
) {
    try {
        androidLibrary {
            this.namespace = namespace
            compileSdk = 36
            minSdk = 24

            withHostTestBuilder {
            }

            withDeviceTestBuilder {
                sourceSetTreeName = "test"
            }.configure {
                instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        }
    } catch (_: Exception) {
        androidTarget()
    }
    jvm("desktop")

    wasmJs { browser() }
    js { browser() }


    listOf(
        iosX64(),
        iosSimulatorArm64(),
        iosArm64()
    ).forEach {
        it.binaries.framework {
            if (xcfName.isNotEmpty()) {
                baseName = xcfName
            }
        }
    }

    applyHierarchyTemplate {
        sourceSetTrees(KotlinSourceSetTree.main, KotlinSourceSetTree.test)

        common {
            group("jvm") {
                withCompilations { it.target.platformType.let { type -> type == KotlinPlatformType.jvm || type == KotlinPlatformType.androidJvm } }
            }

            group("web") {
                withJs()
                withWasmJs()
            }

            group("nonAndroid") {
                excludeCompilations { it.platformType == KotlinPlatformType.androidJvm }
            }

            group("native") {
                withAndroidNative()
                withApple()
                withLinux()
                withMingw()
            }
        }
    }
}

fun KotlinMultiplatformExtension.applyTargets(
    namespace: String,
    xcfName: String = "",
) {
    applyComposeTargets(namespace, xcfName)

    mingwX64()

    linuxArm64()
    linuxX64()

    listOf(
        macosX64(),
        macosArm64(),

        tvosX64(),
        tvosArm64(),
        tvosSimulatorArm64(),

        watchosX64(),
        watchosArm64(),
        watchosDeviceArm64(),
        watchosSimulatorArm64(),
    ).forEach {
        it.binaries.framework {
            if (xcfName.isNotEmpty()) {
                baseName = xcfName
            }
        }
    }

}

