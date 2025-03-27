plugins {
	java
	id("org.springframework.boot") version "3.4.4"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.asciidoctor.jvm.convert") version "3.3.2"
	id("de.undercouch.download") version "5.4.0"

}

group = "com.credable"
version = "0.0.1-SNAPSHOT"


tasks.register<JavaExec>("wsimport") {
	group = "wsdl"
	description = "Generate Java classes from all Wsdl in a folder"
	mainClass.set("com.sun.tools.ws.WsImport")
	classpath = sourceSets.main.get().compileClasspath

	val wsdlDir = file("src/main/resources/wsdl")
	val wsdlFiles = wsdlDir.listFiles()?.filter { it.extension == "wsdl" }?.map { it.absolutePath } ?: emptyList()

	args = listOf("-keep", "-s", "src/main/java/com/credable/external/soap/wsdl") +
			wsdlFiles.flatMap { listOf("-p", "com.credable.external.soap.wsdl.${it.substringAfterLast('/').removeSuffix
				(".wsdl")}", it) }
}

sourceSets.main {
	java.srcDir("src/main/java/com/credable/external/soap/wsdl")
}
tasks.withType<JavaCompile> {
	source("src/main/java/com/credable/external/soap/wsdl")
}


java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["snippetsDir"] = file("build/generated-snippets")

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("org.springframework.boot:spring-boot-starter-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-web-services")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.ws:spring-ws-core")
	implementation("javax.xml.bind:jaxb-api:2.3.1")
	implementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")
	implementation ("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
	implementation ("org.glassfish.jaxb:jaxb-runtime:4.0.0")
	implementation("jakarta.xml.ws:jakarta.xml.ws-api:3.0.0")
	implementation("com.sun.xml.ws:jaxws-rt:3.0.0")
	implementation("com.sun.xml.ws:jaxws-tools:3.0.0")
	implementation ("org.apache.httpcomponents:httpclient:4.5.14")



}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.test {
	outputs.dir(project.extra["snippetsDir"]!!)
}

tasks.asciidoctor {
	inputs.dir(project.extra["snippetsDir"]!!)
	dependsOn(tasks.test)
}
