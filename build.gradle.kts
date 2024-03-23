group = "io.github.supercheese200.blacklistbypass"
version = "1.0-SNAPSHOT"

buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.github.johnrengelman:shadow:8.1.1")
    }
}

plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    // https://mvnrepository.com/artifact/org.javassist/javassist
    implementation("org.javassist:javassist:3.30.2-GA")
}

tasks {
    named<Jar>("jar") {
        manifest {
            attributes(mapOf("Premain-Class" to "io.github.supercheese200.blacklistbypass.BypassAgent"))
        }
    }

    named<Jar>("shadowJar") {
        manifest {
            attributes(mapOf("Premain-Class" to "io.github.supercheese200.blacklistbypass.BypassAgent"))
        }
    }
}


tasks.test {
    useJUnitPlatform()
}