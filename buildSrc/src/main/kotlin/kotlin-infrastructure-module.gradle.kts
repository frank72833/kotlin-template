plugins {
    id("kotlin-conventions")
    id("kotlin-it-conventions")
}

dependencies.constraints {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}