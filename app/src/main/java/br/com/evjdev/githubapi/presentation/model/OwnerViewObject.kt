package br.com.evjdev.githubapi.presentation.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class OwnerViewObject(
    var avatarUrl: String?,
    var eventsUrl: String?,
    var followersUrl: String?,
    var followingUrl: String?,
    var gistsUrl: String?,
    var gravatarId: String?,
    var htmlUrl: String?,
    var id: Int?,
    var login: String?,
    var nodeId: String?,
    var organizationsUrl: String?,
    var receivedEventsUrl: String?,
    var reposUrl: String?,
    var siteAdmin: Boolean?,
    var starredUrl: String?,
    var subscriptionsUrl: String?,
    var type: String?,
    var url: String?
)