package com.revolhope.core.base.component.contract

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

typealias UiModel = UiComponentContract.UiModel
typealias UiEvent = UiComponentContract.Event
typealias UiState<T> = UiComponentContract.State<T>
typealias UiSideEffect = UiComponentContract.SideEffect

object EmptyUiEvent: UiEvent
object EmptyUiSideEffect: UiSideEffect

val defaultSideEffectsHandlerKey by lazy { "default-side-effects-handler" }

@Composable
fun <Effect : UiSideEffect> HandleSideEffects(
    uiSideEffectFlow: Flow<Effect>?,
    onSideEffect: (UiComponentContract.SideEffect.Effect) -> Unit = {},
    onNavRequest: (UiComponentContract.SideEffect.Navigation) -> Unit = {}
) {
    LaunchedEffect(defaultSideEffectsHandlerKey) {
        uiSideEffectFlow?.onEach { effect ->
            when (effect) {
                is UiComponentContract.SideEffect.Effect -> onSideEffect(effect)
                is UiComponentContract.SideEffect.Navigation -> onNavRequest(effect)
            }
        }?.collect()
    }
}