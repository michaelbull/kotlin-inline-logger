import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

val ossrhUsername: String? by ext
val ossrhPassword: String? by ext

description = "A logger facilitating lazily-evaluated log calls via Kotlin's inline classes & functions."

plugins {
    `maven-publish`
    signing
    kotlin("multiplatform") version "1.3.61"
    id("com.github.ben-manes.versions") version "0.27.0"
    id("net.researchgate.release") version "2.8.1"
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        listOf("alpha", "beta", "rc", "cr", "m", "eap", "pr").any {
            candidate.version.contains(it, ignoreCase = true)
        }
    }
}

repositories {
    mavenCentral()
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
                implementation("org.slf4j:slf4j-api:1.7.30")
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
                implementation("org.slf4j:slf4j-jdk14:1.7.30")
            }
        }
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications)
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
            }
        }
    }
}

tasks.afterReleaseBuild {
    dependsOn(tasks.publish)
}
