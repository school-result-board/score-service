import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("plugin.jpa") version "1.2.71"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    kotlin("jvm") version "1.2.71"
    kotlin("plugin.spring") version "1.2.71"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
group = "com.zaid.hoona.score"
version = "1.0-SNAPSHOT"
extra["springBootVersion"] = "2.1.6.RELEASE"
extra["springCloudVersion"] = "Greenwich.SR1"

dependencies {
    compile(project(":application"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.mockito:mockito-inline:2.23.4")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.flywaydb:flyway-core")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-starter-parent:${property("springBootVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
