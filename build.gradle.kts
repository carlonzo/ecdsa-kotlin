import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    kotlin("multiplatform") version "1.8.21"
    id("com.vanniktech.maven.publish") version "0.25.2"
}

group = "com.carlonzo.ecdsa"
version = "0.1.0"


@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    jvm {
        jvmToolchain(11)
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    iosArm64()
    iosSimulatorArm64()
    macosArm64()
    js(IR)

    sourceSets {
        val commonMain by getting{
            dependencies{
                implementation("com.ionspin.kotlin:bignum:0.3.8")
                implementation("org.kotlincrypto:secure-random:0.1.0")
                implementation("org.kotlincrypto.hash:sha2:0.2.4")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)

    signAllPublications()

    pom {
        name.set("ecdsa")
        inceptionYear.set("2023")
        url.set("https://github.com/carlonzo/ecdsa-kotlin")
        developers {
            developer {
                id.set("carlonzo")
                name.set("Carlo Marinangeli")
                url.set("https://github.com/carlonzo")
            }
        }
        scm {
            url.set("https://github.com/carlonzo/ecdsa-kotlin")
            connection.set("scm:git:git://github.com/carlonzo/ecdsa-kotlin.git")
            developerConnection.set("scm:git:ssh://git@github.com/carlonzo/ecdsa-kotlin.git")
        }
    }
}