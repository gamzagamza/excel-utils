plugins {
    id("java")
}

allprojects {
    apply(plugin = "java")

    group = "io.dori"
    version = "1.0-SNAPSHOT"

    java {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation(rootProject.libs.junit)
        testImplementation(rootProject.libs.assertJ)
    }

    tasks.test {
        useJUnitPlatform()
    }
}