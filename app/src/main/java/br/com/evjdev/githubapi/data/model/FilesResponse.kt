package br.com.evjdev.githubapi.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilesResponse(
    @SerialName("irisdataset.csv")
    var irisdatasetCsvResponse: IrisdatasetCsvResponse
)