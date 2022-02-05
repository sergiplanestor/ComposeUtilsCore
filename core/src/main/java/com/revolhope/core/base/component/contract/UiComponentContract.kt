package com.revolhope.core.base.component.contract


interface UiComponentContract {
    interface Event

    sealed class State<out T> {
        data class Ready<out T>(val data: T) : State<T>()
        data class Loading<out T>(val startedOn: Long, val timeout: Long? = null) : State<T>()
        data class Error<out T>(val cause: Throwable? = null) : State<T>()
    }

    sealed interface SideEffect {
        interface Effect : SideEffect
        interface Navigation : SideEffect
    }
}
