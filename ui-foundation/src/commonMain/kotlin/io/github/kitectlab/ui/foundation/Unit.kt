package io.github.kitectlab.ui.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpRect
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.TextUnit

@Stable
fun Dp.toPx(density: Density) = with(density) { toPx() }

@Stable
fun Dp.roundToPx(density: Density) = with(density) { roundToPx() }

@Stable
fun Dp.toSp(density: Density) = with(density) { toSp() }

@Stable
fun TextUnit.toPx(density: Density) = with(density) { toPx() }

@Stable
fun TextUnit.roundToPx(density: Density) = with(density) { roundToPx() }

@Stable
fun TextUnit.toDp(density: Density) = with(density) { toDp() }

@Stable
fun Int.toDp(density: Density) = with(density) { toDp() }

@Stable
fun Int.toSp(density: Density) = with(density) { toSp() }

@Stable
fun Float.toDp(density: Density) = with(density) { toDp() }

@Stable
fun Float.toSp(density: Density) = with(density) { toSp() }

@Stable
fun DpRect.toRect(density: Density) = with(density) { toRect() }

@Stable
fun DpSize.toSize(density: Density) = with(density) { toSize() }

@Stable
fun Size.toDpSize(density: Density) = with(density) { toDpSize() }

@Stable
@Composable
fun Dp.toPx() = with(LocalDensity.current) { toPx() }

@Stable
@Composable
fun Dp.roundToPx() = with(LocalDensity.current) { roundToPx() }

@Stable
@Composable
fun Dp.toSp() = with(LocalDensity.current) { toSp() }

@Stable
@Composable
fun TextUnit.toPx() = with(LocalDensity.current) { toPx() }

@Stable
@Composable
fun TextUnit.roundToPx() = with(LocalDensity.current) { roundToPx() }

@Stable
@Composable
fun TextUnit.toDp() = with(LocalDensity.current) { toDp() }

@Stable
@Composable
fun Int.toDp() = with(LocalDensity.current) { toDp() }

@Stable
@Composable
fun Int.toSp() = with(LocalDensity.current) { toSp() }

@Stable
@Composable
fun Float.toDp() = with(LocalDensity.current) { toDp() }

@Stable
@Composable
fun Float.toSp() = with(LocalDensity.current) { toSp() }

@Stable
@Composable
fun DpRect.toRect() = with(LocalDensity.current) { toRect() }

@Stable
@Composable
fun DpSize.toSize() = with(LocalDensity.current) { toSize() }

@Stable
@Composable
fun Size.toDpSize() = with(LocalDensity.current) { toDpSize() }
