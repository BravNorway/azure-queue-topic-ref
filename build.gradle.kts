plugins {
    val kotlinVersion = "1.8.21"
    val springBootVersion = "3.1.0"
    val springDependencyMngtVersion = "1.1.0"

    kotlin("jvm") version kotlinVersion
    kotlin("plugin.spring") version "1.8.0"
    kotlin("plugin.jpa") version "1.8.0"
    application
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version springDependencyMngtVersion
}

group = "com.brav.skisporet.gpsprocessor"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.azure:azure-messaging-servicebus:7.13.3")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}
