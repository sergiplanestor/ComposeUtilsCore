package com.revolhope.core.base.component.contract


sealed interface UiComponentContract {
    interface Event

    interface UiModel

    sealed interface SideEffect {
        interface Effect : SideEffect
        interface Navigation : SideEffect
    }

    sealed class State<out T : UiModel> {
        data class Ready<out T : UiModel>(val data: T) : State<T>()

        data class Loading<out T : UiModel>(
            val startedOn: Long,
            val timeout: Long? = null
        ) : State<T>()

        data class Error<out T : UiModel>(val cause: Throwable? = null) : State<T>()
    }
}
