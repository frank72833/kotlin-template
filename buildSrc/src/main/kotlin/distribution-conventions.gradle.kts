plugins {
    id("distribution")
}

// Hardcoded as that is what the whole deployment pipeline expects from artifacts.
project.version = "0.0.1-SNAPSHOT"

tasks.named<Jar>("jar") {
    enabled = true
}

tasks.named<Zip>("distZip") {
    archiveFileName.set("${project.name}.zip")
}

distributions {
    main {
        contents {
            from("deployment") {
                into(".")
            }
        }
    }
}