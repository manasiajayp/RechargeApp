plugins {
	java
	id("org.springframework.boot") version "3.5.6"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "RechargeApp Producer Service"

java {
	toolchain {
		languageVersion.set(JavaLanguageVersion.of(17))
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot Web
	implementation("org.springframework.boot:spring-boot-starter-web")

	// Spring Boot + ActiveMQ Artemis (Jakarta JMS compatible)
	implementation("org.springframework.boot:spring-boot-starter-activemq")
	implementation("org.apache.activemq:artemis-jms-client:2.30.0")
	implementation("org.apache.activemq:artemis-core-client:2.30.0")

	// JMS pooling
	implementation("org.messaginghub:pooled-jms:3.0.0")

	// JSON handling
	implementation("com.fasterxml.jackson.core:jackson-databind")

	// Micrometer metrics
	implementation("io.micrometer:micrometer-core")
	implementation("io.micrometer:micrometer-registry-prometheus")

	// Logging
	implementation("org.springframework.boot:spring-boot-starter-logging")

	// Testing
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
