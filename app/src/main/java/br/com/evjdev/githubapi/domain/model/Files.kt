package br.com.evjdev.githubapi.domain.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Files(
    @SerialName("irisdataset.csv")
    var irisdatasetCsv: IrisdatasetCsv
)