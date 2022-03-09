package br.com.evjdev.githubapi.domain.usecase

import br.com.evjdev.githubapi.data.repository.FakeGistsRepository
import br.com.evjdev.githubapi.domain.model.Gists
import kotlinx.coroutines.runBlocking
import org.junit.Before
import com.google.common.truth.Truth.*
import org.junit.Test

class GetGistsUseCaseImplTest {
    private lateinit var fakeGistsRepository: FakeGistsRepository
    private lateinit var getGistsUseCaseImpl: GetGistsUseCaseImpl
    private var result: List<Gists>? = emptyList()

    @Before
    fun setUp() {
        fakeGistsRepository = FakeGistsRepository()
        getGistsUseCaseImpl = GetGistsUseCaseImpl(fakeGistsRepository)
        runBlocking {
            getGistsUseCaseImpl().onSuccess {
                result = it
            }.onFailure {
                result = emptyList()
            }
        }
    }

    @Test
    fun `contains data in list`() {
        assertThat(!result.isNullOrEmpty()).isTrue()
    }
}