package ru.otus.compose.features.comics

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.otus.compose.common.resolve
import ru.otus.compose.data.model.Comic
import ru.otus.compose.data.repository.ComicsRepository
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val comicsRepository: ComicsRepository
) : ViewModel(), LifecycleObserver {

    suspend fun fetchComicsForCharacter(characterId: String): ComicsState {
        val result = comicsRepository.loadComicsForCharacter(characterId)

        return result.resolve(
            onSuccess = { comics ->
                ComicsState.Data(
                    comics = comics.map { comic -> comic.toState() }
                )
            },
            onError = { throwable -> ComicsState.Error(throwable) }
        )
    }

    private fun Comic.toState(): ComicsState.Data.ComicState {
        return ComicsState.Data.ComicState(
            id = id,
            title = title,
            description = description,
            imageUrl = imageUrl,
        )
    }
}
