package br.com.evjdev.githubapi.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(
    @SerialName("avatar_url")
    var avatarUrl: String?,
    @SerialName("events_url")
    var eventsUrl: String?,
    @SerialName("followers_url")
    var followersUrl: String?,
    @SerialName("following_url")
    var followingUrl: String?,
    @SerialName("gists_url")
    var gistsUrl: String?,
    @SerialName("gravatar_id")
    var gravatarId: String?,
    @SerialName("html_url")
    var htmlUrl: String?,
    @SerialName("id")
    var id: Int?,
    @SerialName("login")
    var login: String?,
    @SerialName("node_id")
    var nodeId: String?,
    @SerialName("organizations_url")
    var organizationsUrl: String?,
    @SerialName("received_events_url")
    var receivedEventsUrl: String?,
    @SerialName("repos_url")
    var reposUrl: String?,
    @SerialName("site_admin")
    var siteAdmin: Boolean?,
    @SerialName("starred_url")
    var starredUrl: String?,
    @SerialName("subscriptions_url")
    var subscriptionsUrl: String?,
    @SerialName("type")
    var type: String?,
    @SerialName("url")
    var url: String?
)