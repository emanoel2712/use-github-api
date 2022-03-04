package br.com.evjdev.githubapi.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IrisdatasetCsv(
    @SerialName("filename")
    var filename: String,
    @SerialName("language")
    var language: String,
    @SerialName("raw_url")
    var rawUrl: String,
    @SerialName("size")
    var size: Int,
    @SerialName("type")
    var type: String
)