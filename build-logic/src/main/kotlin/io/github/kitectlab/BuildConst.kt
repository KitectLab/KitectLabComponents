package io.github.kitectlab

object BuildConst {
    private val basicPackage = this::class.java.`package`.name

    val group = basicPackage

    val snapshotVersion = "0.1.0-SNAPSHOT"

    val packageName = "${basicPackage}.components"

    val isRelease = System.getenv("KITECTLAB_PROJECT_BUILD_TYPE") == "release"

}