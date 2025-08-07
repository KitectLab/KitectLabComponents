plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(gradleApi())
    implementation(kotlin("gradle-plugin", libs.versions.kotlin.get()))
    implementation(plugin(libs.plugins.kotlinMultiplatform))
    implementation(plugin(libs.plugins.androidKotlinMultiplatformLibrary))
    implementation(plugin(libs.plugins.vanniktechMavenPublish))
}

fun DependencyHandler.plugin(plugin: Provider<PluginDependency>): String {
    return plugin.map { "${it.pluginId}:${it.pluginId}.gradle.plugin:${it.version}" }.get()
}

gradlePlugin {
    plugins {
        create("BuildLogic") {
            id = "io.github.kitectlab.build-logic"
            implementationClass = "io.github.kitectlab.BuildLogicPlugin"
        }
    }
}