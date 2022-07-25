plugins {
    kotlin("jvm")
    idea
}

sourceSets {
    create("intTest") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output

        this.resources.srcDirs(project.rootProject.file("sql"))
    }
}

idea {
    module {
        testSourceDirs = testSourceDirs + sourceSets["intTest"].allSource.srcDirs
        testResourceDirs = testResourceDirs + sourceSets["intTest"].resources.srcDirs
    }
}

val intTestImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get())
}

configurations["intTestRuntimeOnly"].extendsFrom(configurations.runtimeOnly.get())

tasks.register<Test>("intTest") {
    description = "Runs integration tests."
    group = "verification"
    testClassesDirs = sourceSets["intTest"].output.classesDirs
    classpath = sourceSets["intTest"].runtimeClasspath
    jvmArgs = listOf("-Dspring.profiles.active=test")

    shouldRunAfter("test")
    useJUnitPlatform()
}

dependencies.constraints {
    implementation("org.testcontainers:testcontainers:1.17.1")
    implementation("org.testcontainers:junit-jupiter:1.17.1")
    implementation("org.testcontainers:mysql:1.17.1")
    implementation("org.testcontainers:localstack:1.17.1")
    implementation("io.mockk:mockk:1.10.4")
}