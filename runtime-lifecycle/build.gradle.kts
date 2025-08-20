import io.github.kitectlab.BuildConst
import io.github.kitectlab.androidDeviceTest
import io.github.kitectlab.applyComposeTargets
import io.github.kitectlab.desktopMain

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.androidLint)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.buildLogic)
    alias(libs.plugins.vanniktechMavenPublish)
}

group = BuildConst.group // Project-level group

version = runtimeProperties.libraryVersion.get() // Project-level version

kotlin {

    applyComposeTargets(
        namespace = "${BuildConst.packageName}.runtime.lifecycle",
        xcfName = "RuntimeLifecycleKit"
    )

    sourceSets {
        commonMain {
            dependencies {
                api(compose.runtime)
                api(libs.androidx.lifecycle.runtimeCompose)
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidDeviceTest {
            dependencies {
                implementation(libs.androidx.runner)
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
            }
        }
    }

}
