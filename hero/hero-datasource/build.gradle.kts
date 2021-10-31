apply {
    from("$rootDir/library-build.gradle")
}

plugins {
    kotlin(KotlinPlugins.serialization) version Kotlin.version
}

dependencies{
    "implementation"(project(Modules.heroDomain))
    "implementation"(project(Modules.datasource))

    "implementation"(Ktor.core)
    "implementation"(Ktor.android)
    "implementation"(Ktor.clientSerialization)
    "implementation"("com.google.code.gson:gson:2.8.9")
}