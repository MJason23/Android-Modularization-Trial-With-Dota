interface BuildType {
    companion object {
        const val DEBUG = "debug"
        const val RELEASE = "release"
    }

    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val applicationIdSuffix: String
    val versionNameSuffix: String
}

object BuildTypeDebug: BuildType {
    override val isMinifyEnabled: Boolean = false
    override val isTestCoverageEnabled: Boolean = false

    override val applicationIdSuffix = ".debug"
    override val versionNameSuffix: String = "-DEBUG"
}


object BuildTypeRelease: BuildType {
    override val isMinifyEnabled: Boolean = true
    override val isTestCoverageEnabled: Boolean = false

    override val applicationIdSuffix = ""
    override val versionNameSuffix: String = ""
}