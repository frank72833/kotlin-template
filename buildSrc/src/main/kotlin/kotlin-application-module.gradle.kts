plugins {
    id("kotlin-infrastructure-module")
    id("distribution-conventions")
    application
}

tasks.register<JavaExec>("runLocal") {
    description = "Runs the application locally, by preparing the environment from envvars.sh file"

    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set(application.mainClass.get())

    doFirst {
        println("Starting the Application using env variables from ${project.name}/config/envvars.sh")

        readEnvVars("${project.projectDir.absolutePath}/config/envvars.sh")
            .onEach { (k, v) -> println("$k=$v") }
            .forEach { (k, v) -> environment(k, v) }
    }
}

fun readEnvVars(path: String) = file(path)
    .readLines()
    .asSequence()
    .filterNot { it.isBlank() || it.startsWith("#") }
    .map { it.trim().split("=") }
    .map { it[0] to it[1].replace("'", "") }

dependencies.constraints {
    implementation("org.springdoc:springdoc-openapi-data-rest:1.6.0")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.0")
    implementation("org.springdoc:springdoc-openapi-kotlin:1.6.0")
}