package io.github.kitectlab

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

class BuildLogicPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Add your plugin logic here
        project.setupRuntimeProperties()
        project.afterEvaluate {
            project.mavenPublishSetup()
        }
    }
}

private fun Project.setupRuntimeProperties() {
    val extension = project.extensions.create("runtimeProperties", RuntimeProperties::class)
    extension.libraryVersion.set(gitLibraryVersionProvider(project))
}

abstract class RuntimeProperties @Inject constructor(objects: ObjectFactory) {
    val libraryVersion: Property<String> = objects.property()
}