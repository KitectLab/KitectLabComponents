package io.github.kitectlab.runtime.lifecycle

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LifecyclePauseOrDisposeEffectResult
import androidx.lifecycle.compose.LifecycleResumeEffect
import androidx.lifecycle.compose.LifecycleResumePauseEffectScope
import androidx.lifecycle.compose.LifecycleStartEffect
import androidx.lifecycle.compose.LifecycleStartStopEffectScope
import androidx.lifecycle.compose.LifecycleStopOrDisposeEffectResult
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LifecycleStartLaunchedEffect(key1: Any?,lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleStartEffect(key1 = key1, lifecycleOwner = lifecycleOwner, effects = launchedStartEffectResult(block))
}

@Composable
fun LifecycleStartLaunchedEffect(key1: Any?, key2: Any?, lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleStartEffect(key1 = key1, key2 = key2, lifecycleOwner = lifecycleOwner, effects = launchedStartEffectResult(block))
}

@Composable
fun LifecycleStartLaunchedEffect(key1: Any?, key2: Any?, key3: Any?, lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleStartEffect(key1 = key1, key2 = key2, key3 = key3, lifecycleOwner = lifecycleOwner, effects = launchedStartEffectResult(block))
}

@Composable
fun LifecycleStartLaunchedEffect(vararg keys: Any?, lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleStartEffect(keys = keys, lifecycleOwner = lifecycleOwner, effects = launchedStartEffectResult(block))
}

@Composable
fun LifecycleResumeLaunchedEffect(key1: Any?,lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleResumeEffect(key1 = key1, lifecycleOwner = lifecycleOwner, effects = launchedResumeEffectResult(block))
}

@Composable
fun LifecycleResumeLaunchedEffect(key1: Any?, key2: Any?, lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleResumeEffect(key1 = key1, key2 = key2, lifecycleOwner = lifecycleOwner, effects = launchedResumeEffectResult(block))
}

@Composable
fun LifecycleResumeLaunchedEffect(key1: Any?, key2: Any?, key3: Any?, lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleResumeEffect(key1 = key1, key2 = key2, key3 = key3, lifecycleOwner = lifecycleOwner, effects = launchedResumeEffectResult(block))
}

@Composable
fun LifecycleResumeLaunchedEffect(vararg keys: Any?, lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current, block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit) {
    LifecycleResumeEffect(keys = keys, lifecycleOwner = lifecycleOwner, effects = launchedResumeEffectResult(block))
}

private inline fun launchedResumeEffectResult(
    crossinline block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit
): LifecycleResumePauseEffectScope.() -> LifecyclePauseOrDisposeEffectResult = {
    val lifecycleOwner = this
    val job = lifecycleScope.launch { block(lifecycleOwner) }
    onPauseOrDispose {
        job.cancel()
    }
}

private inline fun launchedStartEffectResult(
    crossinline block: suspend CoroutineScope.(lifecycleOwner: LifecycleOwner) -> Unit
): LifecycleStartStopEffectScope.() -> LifecycleStopOrDisposeEffectResult = {
    val lifecycleOwner = this
    val job = lifecycleScope.launch { block(lifecycleOwner) }
    onStopOrDispose {
        job.cancel()
    }
}