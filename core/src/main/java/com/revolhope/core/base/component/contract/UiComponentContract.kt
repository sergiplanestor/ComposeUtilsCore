package com.revolhope.core.base.component.contract


interface UiComponentContract {
    interface Event

    sealed interface State<out T> {
        interface Ready<out T> : State<T> {
            val data: T
        }
        interface Loading<out T> : State<T> {
            val startedOn: Long
            val timeout: Long?
                get() = null
        }
        interface Error<out T> : State<T> {
            val cause: Throwable?
                get() = null
        }
    }

    sealed interface SideEffect {
        interface Effect : SideEffect
        interface Navigation : SideEffect
    }
}
