package io.github.kitectlab

import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.NamedDomainObjectProvider
import org.gradle.kotlin.dsl.getByName
import org.gradle.kotlin.dsl.named
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

val NamedDomainObjectContainer<KotlinSourceSet>.desktopMain by NamedSourceSetDelegate()

val NamedDomainObjectContainer<KotlinSourceSet>.androidDeviceTest by NamedSourceSetDelegate()

private class NamedSourceSetDelegate(): ReadOnlyProperty<NamedDomainObjectContainer<KotlinSourceSet>, NamedDomainObjectProvider<KotlinSourceSet>> {
    override fun getValue(
        thisRef: NamedDomainObjectContainer<KotlinSourceSet>,
        property: KProperty<*>
    ): NamedDomainObjectProvider<KotlinSourceSet> {
        return thisRef.named(property.name)
    }
}