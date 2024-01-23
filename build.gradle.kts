import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import org.jetbrains.dokka.gradle.DokkaTask

val ossrhUsername: String? by project
val ossrhPassword: String? by project

val signingKeyId: String? by project // must be the last 8 digits of the key
val signingKey: String? by project
val signingPassword: String? by project

description = "A logger facilitating lazily-evaluated log calls via Kotlin's inline classes & functions."

plugins {
    `maven-publish`
    signing

    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.dokka)
    alias(libs.plugins.versions)
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        listOf("alpha", "beta", "rc", "cr", "m", "eap", "pr").any {
            candidate.version.contains(it, ignoreCase = true)
        }
    }
}

val dokkaHtml by tasks.existing(DokkaTask::class)

val javadocJar by tasks.registering(Jar::class) {
    group = LifecycleBasePlugin.BUILD_GROUP
    description = "Assembles a jar archive containing the Javadoc API documentation."
    archiveClassifier.set("javadoc")
    from(dokkaHtml)
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(8)

    sourceSets {
        commonMain {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }

    jvm {
        compilations.named("main") {
            dependencies {
                implementation(kotlin("stdlib-jdk8"))
                implementation(libs.slf4j.api)
            }
        }

        compilations.named("test") {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-junit"))
                implementation(libs.slf4j.jdk14)
            }
        }

        mavenPublication {
            artifact(javadocJar.get())
        }
    }
}

publishing {
    repositories {
        maven {
            if (project.version.toString().endsWith("SNAPSHOT")) {
                setUrl("https://oss.sonatype.org/content/repositories/snapshots")
            } else {
                setUrl("https://oss.sonatype.org/service/local/staging/deploy/maven2")
            }

            credentials {
                username = ossrhUsername
                password = ossrhPassword
            }
        }
    }

    publications.withType<MavenPublication> {
        pom {
            name.set(project.name)
            description.set(project.description)
            url.set("https://github.com/michaelbull/kotlin-inline-logger")
            inceptionYear.set("2019")

            licenses {
                license {
                    name.set("ISC License")
                    url.set("https://opensource.org/licenses/isc-license.txt")
                }
            }

            developers {
                developer {
                    name.set("Michael Bull")
                    url.set("https://www.michael-bull.com")
                }
            }

            scm {
                connection.set("scm:git:https://github.com/michaelbull/kotlin-inline-logger")
                developerConnection.set("scm:git:git@github.com:michaelbull/kotlin-inline-logger.git")
                url.set("https://github.com/michaelbull/kotlin-inline-logger")
            }

            issueManagement {
                system.set("GitHub")
                url.set("https://github.com/michaelbull/kotlin-inline-logger/issues")
            }

            ciManagement {
                system.set("GitHub")
                url.set("https://github.com/michaelbull/kotlin-inline-logger/actions?query=workflow%3Aci")
            }

            contributors {
                contributor {
                    name.set("Toby-S")
                    url.set("https://github.com/Toby-S")
                }

                contributor {
                    name.set("Richard Gomez")
                    url.set("https://github.com/rgmz")
                }

                contributor {
                    name.set("Sebastian Schuberth")
                    url.set("https://github.com/sschuberth")
                }
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
    sign(publishing.publications)
}
