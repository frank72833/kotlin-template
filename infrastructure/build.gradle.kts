plugins {
    id("kotlin-infrastructure-module")
}

dependencies {
    // Project dependencies
    implementation(project(":domain"))

    // Kotlin compatibility
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Functional programming
    implementation("io.arrow-kt:arrow-core")

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Testing
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.mockk:mockk")

    // IT Testing
    intTestImplementation("org.testcontainers:testcontainers")
    intTestImplementation("org.testcontainers:mysql")
    intTestImplementation("org.testcontainers:junit-jupiter")
    intTestImplementation("org.testcontainers:localstack")
    intTestImplementation("io.mockk:mockk:1.12.4")
    intTestImplementation("com.ninja-squad:springmockk:3.1.1")
    intTestImplementation("org.springframework.boot:spring-boot-starter-test")

    intTestImplementation("org.flywaydb:flyway-core") {
        version {
            strictly("7.15.0")
        }
        because("""
            Flyway does not support mysql 5.7 after version 7.15.0 and
            io.spring.dependency-management overrides dependency constraints
        """)
    }
}