package br.com.evjdev.githubapi.domain.model

data class Gists(
    val comments: Int,
    val commentsUrl: String,
    val commitsUrl: String,
    val createdAt: String,
    val description: String,
    /*
    @SerialName("files")
    var files: Files,
     */
    val forksUrl: String,
    val gitPullUrl: String,
    val gitPushUrl: String,
    val htmlUrl: String,
    val id: String,
    val nodeId: String,
    val owner: Owner,
    val public: Boolean,
    val truncated: Boolean,
    val updatedAt: String,
    val url: String
    /*
    @SerialName("user")
    var user: Any
     */
)
