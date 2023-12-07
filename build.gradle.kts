plugins {
    id("java")
}

group = "ru.tinkoff.qa"
version = "1.0-SNAPSHOT"
tasks.compileJava{
    options.encoding = "UTF-8"
}
repositories {
    mavenCentral()
}

dependencies {

    // tests
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // db
    implementation("org.hibernate:hibernate-core:6.0.0.Final")
    testImplementation("com.h2database:h2:2.2.224")

    // api
    testImplementation("io.rest-assured:rest-assured:5.3.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.0")
}

tasks.test {
    useJUnitPlatform()
}