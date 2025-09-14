plugins {
    kotlin("jvm") version "2.2.20"
    id("org.jetbrains.dokka") version "2.0.0"
    id("com.gradleup.shadow") version "8.3.0"
    id("maven-publish")
}

group = "com.github.thatsrozum"
version = "1.3.1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/central")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
    dokkaPlugin("org.jetbrains.dokka:kotlin-as-java-plugin:2.0.0")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

kotlin {
    jvmToolchain(11)
}

val dokkaJavadocJar by tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])

            artifact(tasks.shadowJar.get()) {
                classifier = "shadow"
            }

            artifact(dokkaJavadocJar)

            pom {
                name.set("LightParties")
                description.set("Lightweight library for parties/teams")
                url.set("https://github.com/thatsrozum/LightParties")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://mit-license.org/")
                    }
                }
            }
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }

    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }
}
