package br.com.evjdev.githubapi.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Gists(
    @SerialName("comments")
    var comments: Int,
    @SerialName("comments_url")
    var commentsUrl: String,
    @SerialName("commits_url")
    var commitsUrl: String,
    @SerialName("created_at")
    var createdAt: String,
    @SerialName("description")
    var description: String,
    /*
    @SerialName("files")
    var files: Files,
     */
    @SerialName("forks_url")
    var forksUrl: String,
    @SerialName("git_pull_url")
    var gitPullUrl: String,
    @SerialName("git_push_url")
    var gitPushUrl: String,
    @SerialName("html_url")
    var htmlUrl: String,
    @SerialName("id")
    var id: String,
    @SerialName("node_id")
    var nodeId: String,
    @SerialName("owner")
    var owner: Owner,
    @SerialName("public")
    var `public`: Boolean,
    @SerialName("truncated")
    var truncated: Boolean,
    @SerialName("updated_at")
    var updatedAt: String,
    @SerialName("url")
    var url: String
    /*
    @SerialName("user")
    var user: Any
     */
)