plugins {
    id("java")
    id("org.springframework.boot") version "4.0.0-M3"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "org.fastcampus"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //  spring
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    //  mysql
    runtimeOnly("com.mysql:mysql-connector-j:9.4.0")

    //  querydsl
    implementation("io.github.openfeign.querydsl:querydsl-jpa:6.10.1")
    annotationProcessor("io.github.openfeign.querydsl:querydsl-apt:6.10.1:jpa")
    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
    annotationProcessor("jakarta.persistence:jakarta.persistence-api")

    //  lombok
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    //  test
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}