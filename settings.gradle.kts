rootProject.name = "excel-utils"

module("writer")
module("example")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("libs.versions.toml"))
        }
    }
}

fun module(name: String) {
    include(name)
}