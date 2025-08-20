package io.github.kitectlab.ui.foundation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp

val PaddingValues.top: Dp
    @Stable
    get() = calculateTopPadding()

val PaddingValues.bottom: Dp
    @Stable
    get() = calculateBottomPadding()

val PaddingValues.start: Dp
    @Stable
    @Composable
    @ReadOnlyComposable
    get() = calculateLeftPadding(LocalLayoutDirection.current)

val PaddingValues.end: Dp
    @Stable
    @Composable
    @ReadOnlyComposable
    get() = calculateRightPadding(LocalLayoutDirection.current)
