import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.tasks.BintrayUploadTask

description = "A logger facilitating lazily-evaluated log calls via Kotlin's inline classes & functions."

plugins {
    `maven-publish`
    kotlin("multiplatform") version ("1.3.50")
    id("com.github.ben-manes.versions") version ("0.25.0")
    id("com.jfrog.bintray") version ("1.8.4")
    id("net.researchgate.release") version ("2.8.1")
}

repositories {
    mavenCentral()
    jcenter()
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        listOf("alpha", "beta", "rc", "cr", "m", "eap", "pr").any {
            candidate.version.contains(it, ignoreCase = true)
        }
    }
}

kotlin {
    sourceSets {
        named("commonMain") {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }

        named("commonTest") {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    jvm {
        compilations.named("main") {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-Xno-call-assertions", "-Xno-receiver-assertions", "-Xno-param-assertions")
            }

            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation("org.slf4j:slf4j-api:1.7.28")
            }
        }

        compilations.named("test") {
            kotlinOptions {
                jvmTarget = "1.8"
                freeCompilerArgs = listOf("-Xno-call-assertions", "-Xno-receiver-assertions", "-Xno-param-assertions")
            }

            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation("org.slf4j:slf4j-jdk14:1.7.28")
            }
        }
    }
}

fun BintrayExtension.pkg(configure: BintrayExtension.PackageConfig.() -> Unit) {
    pkg(delegateClosureOf(configure))
}

val bintrayUser: String? by project
val bintrayKey: String? by project

bintray {
    user = bintrayUser
    key = bintrayKey
    setPublications("jvm", "metadata")

    pkg {
        repo = "maven"
        name = project.name
        desc = project.description
        websiteUrl = "https://github.com/michaelbull/kotlin-inline-logger"
        issueTrackerUrl = "https://github.com/michaelbull/kotlin-inline-logger/issues"
        vcsUrl = "git@github.com:michaelbull/kotlin-inline-logger.git"
        githubRepo = "michaelbull/kotlin-inline-logger"
        setLicenses("ISC")
    }
}

val bintrayUpload by tasks.existing(BintrayUploadTask::class) {
    dependsOn("build")
    dependsOn("generatePomFileForJvmPublication")
    dependsOn("generatePomFileForMetadataPublication")
    dependsOn("jvmJar")
    dependsOn("jvmSourcesJar")
    dependsOn("metadataJar")
    dependsOn("metadataSourcesJar")
}

tasks.named("afterReleaseBuild") {
    dependsOn(bintrayUpload)
}
