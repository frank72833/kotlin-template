plugins {
    id("kotlin-application-module")
}

group = "com.fransan.kotlintemplate"

application {
    mainClass.set("com.fransan.kotlintemplate.ApplicationKt")
}

dependencies {
    // Project dependencies
    implementation(project(":domain"))
    implementation(project(":infrastructure"))

    // Kotlin compatibility
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Functional programming
    implementation("io.arrow-kt:arrow-core")

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.retry:spring-retry")

    // Spring docs
    implementation("org.springdoc:springdoc-openapi-data-rest")
    implementation("org.springdoc:springdoc-openapi-ui")
    implementation("org.springdoc:springdoc-openapi-kotlin")

    // Testing
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.mockk:mockk")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // IT Testing
    intTestImplementation("org.jetbrains.kotlin:kotlin-test")
    intTestImplementation("io.mockk:mockk")
    intTestImplementation("com.ninja-squad:springmockk:3.1.1")
    intTestImplementation("org.testcontainers:testcontainers")
    intTestImplementation("org.testcontainers:junit-jupiter")
    intTestImplementation("org.testcontainers:mysql")
    intTestImplementation("org.springframework.boot:spring-boot-starter-test")
    intTestImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
}