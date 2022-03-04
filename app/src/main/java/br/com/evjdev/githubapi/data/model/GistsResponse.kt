package br.com.evjdev.githubapi.data.model


import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.domain.model.Owner
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.log

@Serializable
data class GistsResponse(
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
    var ownerResponse: OwnerResponse,
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

fun GistsResponse.toDomain(): Gists = Gists(
    comments = comments,
    commentsUrl = commentsUrl,
    commitsUrl = commitsUrl,
    createdAt = createdAt,
    description = description,
    forksUrl = forksUrl,
    gitPullUrl = gitPullUrl,
    gitPushUrl = gitPushUrl,
    htmlUrl = htmlUrl,
    id = id,
    nodeId = nodeId,
    owner = Owner(
        avatarUrl = ownerResponse.avatarUrl,
        eventsUrl = ownerResponse.eventsUrl,
        followersUrl = ownerResponse.followersUrl,
        followingUrl = ownerResponse.followingUrl,
        gistsUrl = ownerResponse.gistsUrl,
        gravatarId = ownerResponse.gravatarId,
        htmlUrl = ownerResponse.htmlUrl,
        id = ownerResponse.id,
        login = ownerResponse.login,
        nodeId = ownerResponse.nodeId,
        organizationsUrl = ownerResponse.organizationsUrl,
        receivedEventsUrl = ownerResponse.receivedEventsUrl,
        reposUrl = ownerResponse.reposUrl,
        siteAdmin = ownerResponse.siteAdmin,
        starredUrl = ownerResponse.starredUrl,
        subscriptionsUrl = ownerResponse.subscriptionsUrl,
        type = ownerResponse.type,
        url = ownerResponse.url
    ),
    public = public,
    truncated = truncated,
    updatedAt = updatedAt,
    url = url
)

