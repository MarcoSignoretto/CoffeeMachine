plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    ios()

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
                implementation("com.careem.mockingbird:mockingbird:2.0.0-beta05")
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
    }
}

apply(plugin = "com.careem.mockingbird")

configure<com.careem.mockingbird.MockingbirdPluginExtension> {
    generateMocksFor = listOf(
        "com.msignoretto.coffeemachine.Grinder",
        "com.msignoretto.coffeemachine.WaterHeater",
        "com.msignoretto.coffeemachine.WaterPump"
    )
}


