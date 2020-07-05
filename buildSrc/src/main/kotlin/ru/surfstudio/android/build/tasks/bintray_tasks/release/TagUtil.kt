package ru.surfstudio.android.build.tasks.bintray_tasks.release

/**
 * get artifact name from the artifact's release tag
 */
fun getArtifactName(tag: String): String? {
    return if (tag.contains('/')) {
        tag.split('/').first()
    } else {
        null
    }
}

/**
 * get stable version from the artifact's release tag
 */
fun getArtifactVersion(tag: String) = tag.split('/').last()

/**
 * get stable version from the artifact's release tag as list number
 */
fun getArtifactVersionNumbers(tag: String) = getArtifactVersion(tag)
        .split('.')
        .map(String::toInt)

/**
 * get max artifact version from the artifact's release tags
 */
fun getMaxArtifactVersion(tags: List<String>) =
        getMaxArtifactVersion(tags.map { getArtifactVersionNumbers(it) })
                .joinToString(separator = ".")

/**
 * get max artifact version from the artifact's release tags
 */
fun getMaxArtifactVersion(versions: List<List<Int>>): List<Int> {
    val versionSize = versions.first().size
    var maxVersions = versions
    for (i in 0 until versionSize) {
        val maxAtCurrentPosition = maxVersions.map { it[i] }.max()
        maxVersions = maxVersions.filter { it[i] == maxAtCurrentPosition }
    }
    return maxVersions.first()
}
