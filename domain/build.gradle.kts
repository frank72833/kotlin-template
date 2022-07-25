plugins {
    id("kotlin-conventions")
}

dependencies {
    // Kotlin compatibility
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // Functional programming
    implementation("io.arrow-kt:arrow-core")

    // Spring
    implementation("org.springframework:spring-context")
    implementation("org.springframework:spring-tx")
    implementation("org.springframework.retry:spring-retry")

    // Testing
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("io.mockk:mockk")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}