import org.flywaydb.gradle.task.FlywayMigrateTask

plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.openapi.generator") version "7.5.0"
    id("org.flywaydb.flyway") version "9.22.3"
}

// generated sources of openapi generate task
val generatedSourcesDir = "$buildDir/generated/openapi"
sourceSets.getByName("main").java {
    srcDir("$generatedSourcesDir/src/main/java")
}

group = "com.learning"
version = "0.0.1"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springdoc:springdoc-openapi-ui:1.6.14")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("javax.validation:validation-api:2.0.1.Final")
    implementation("javax.annotation:javax.annotation-api:1.3.2")
    implementation("org.openapitools:jackson-databind-nullable:0.2.6")
    implementation("javax.servlet:javax.servlet-api:3.0.1")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("spring.profiles.active", "test")
}

tasks.compileJava {
    dependsOn("migrateDb")
    dependsOn("openApiGenerate")
}

tasks.register("migrateDb", FlywayMigrateTask::class.java) {
    url = System.getenv("JDBC_DATABASE_URL") ?: "jdbc:postgresql://localhost:5432/learning_db?user=main&password=1234"
    user = ""
    password = ""
    locations = arrayOf("classpath:db/common")
    baselineOnMigrate = true

    doFirst {
        println ("Flyway Locations: ${locations[0]}")
    }
}

openApiGenerate {
    generatorName.set("spring") // Choose the generator (e.g., "spring", "java", etc.)
    inputSpec.set("$rootDir/src/main/resources/api.yaml") // Path to OpenAPI spec
    outputDir.set(generatedSourcesDir)
    configOptions.set(
        mapOf(
            "interfaceOnly" to "true" // Generate only interfaces
        )
    )
}
