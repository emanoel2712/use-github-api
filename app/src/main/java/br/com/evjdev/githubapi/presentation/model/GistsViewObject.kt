package br.com.evjdev.githubapi.presentation.model

import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.domain.model.Owner

data class GistsViewObject(
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
) {
    constructor(gists: Gists) : this(
        comments = gists.comments,
        commentsUrl = gists.commentsUrl,
        commitsUrl = gists.commitsUrl,
        createdAt = gists.createdAt,
        description = gists.description,
        forksUrl = gists.forksUrl,
        gitPullUrl = gists.gitPullUrl,
        gitPushUrl = gists.gitPushUrl,
        htmlUrl = gists.htmlUrl,
        id = gists.id,
        nodeId = gists.nodeId,
        owner = gists.owner,
        public = gists.public,
        truncated = gists.truncated,
        updatedAt = gists.updatedAt,
        url = gists.url
    )
}
