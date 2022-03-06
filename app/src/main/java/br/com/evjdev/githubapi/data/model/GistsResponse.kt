package br.com.evjdev.githubapi.data.model


import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.domain.model.Owner
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.math.log

@Serializable
data class GistsResponse(
    @SerialName("comments")
    val comments: Int?,
    @SerialName("comments_url")
    val commentsUrl: String?,
    @SerialName("commits_url")
    val commitsUrl: String?,
    @SerialName("created_at")
    val createdAt: String?,
    @SerialName("description")
    val description: String?,
    @SerialName("forks_url")
    val forksUrl: String?,
    @SerialName("git_pull_url")
    val gitPullUrl: String?,
    @SerialName("git_push_url")
    val gitPushUrl: String?,
    @SerialName("html_url")
    val htmlUrl: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("node_id")
    val nodeId: String?,
    @SerialName("owner")
    val ownerResponse: OwnerResponse?,
    @SerialName("public")
    val public: Boolean?,
    @SerialName("truncated")
    val truncated: Boolean?,
    @SerialName("updated_at")
    val updatedAt: String?,
    @SerialName("url")
    val url: String?
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
        avatarUrl = ownerResponse?.avatarUrl,
        eventsUrl = ownerResponse?.eventsUrl,
        followersUrl = ownerResponse?.followersUrl,
        followingUrl = ownerResponse?.followingUrl,
        gistsUrl = ownerResponse?.gistsUrl,
        gravatarId = ownerResponse?.gravatarId,
        htmlUrl = ownerResponse?.htmlUrl,
        id = ownerResponse?.id,
        login = ownerResponse?.login,
        nodeId = ownerResponse?.nodeId,
        organizationsUrl = ownerResponse?.organizationsUrl,
        receivedEventsUrl = ownerResponse?.receivedEventsUrl,
        reposUrl = ownerResponse?.reposUrl,
        siteAdmin = ownerResponse?.siteAdmin,
        starredUrl = ownerResponse?.starredUrl,
        subscriptionsUrl = ownerResponse?.subscriptionsUrl,
        type = ownerResponse?.type,
        url = ownerResponse?.url
    ),
    public = public,
    truncated = truncated,
    updatedAt = updatedAt,
    url = url
)

