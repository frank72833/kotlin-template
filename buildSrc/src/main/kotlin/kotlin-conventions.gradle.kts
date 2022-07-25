import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
}

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

val kotlinVersion: String by project
val springBootVersion: String by project

dependencies.constraints {
    // Functional programming
    implementation("io.arrow-kt:arrow-core:1.0.1")

    // Testing
    testImplementation("io.mockk:mockk:1.10.4")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.2")
}