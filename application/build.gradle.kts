import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    kotlin("jvm") version "1.2.71"
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
group = "com.zaid.hoona.score"
version = "1.0-SNAPSHOT"
extra["springBootVersion"] = "2.1.6.RELEASE"

repositories {
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile(project(":domain"))
    testImplementation("junit:junit")
    testImplementation("org.assertj:assertj-core")
    testImplementation("org.mockito:mockito-core")
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
