plugins {
    kotlin("jvm") version "2.2.20"
    id("com.gradleup.shadow") version "8.3.0"
    id("maven-publish")
}

group = "com.github.thatsrozum"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.18.1-R0.1-SNAPSHOT")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name = "LightParties"
                description = "Lightweight boilerplate library for parties/teams"
                url = "https://github.com/thatsrozum/LightParties"
                licenses {
                    license {
                        name = "MIT License"
                        url = "https://mit-license.org/"
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
