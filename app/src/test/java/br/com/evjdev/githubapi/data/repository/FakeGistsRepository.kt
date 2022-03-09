package br.com.evjdev.githubapi.data.repository

import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.domain.model.Owner

class FakeGistsRepository : GistsRepository {
    override suspend fun getGists(): List<Gists> {
        return listOf(
            Gists(
                1,
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                Owner(
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    1,
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    false,
                    "ed",
                    "ed",
                    "ed",
                    "ed"
                ), false, false, "ed", "ed"
            ),
            Gists(
                2,
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                Owner(
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    2,
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    false,
                    "ed",
                    "ed",
                    "ed",
                    "ed"
                ), false, false, "ed", "ed"
            ),
            Gists(
                3,
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                "ed",
                Owner(
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    3,
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    "ed",
                    false,
                    "ed",
                    "ed",
                    "ed",
                    "ed"
                ), false, false, "ed", "ed"
            ),
        )
    }
}