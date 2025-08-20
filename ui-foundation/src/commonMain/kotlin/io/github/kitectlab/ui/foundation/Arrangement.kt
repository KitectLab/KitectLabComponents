package io.github.kitectlab.ui.foundation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp

@Stable
fun Arrangement.Vertical.withSpace(spacing: Dp) =
    object : Arrangement.Vertical by this {
        override val spacing: Dp
            get() = spacing

        override fun toString(): String = super.toString() + "#$spacing"
    }

@Stable
fun Arrangement.Horizontal.withSpace(spacing: Dp) =
    object : Arrangement.Horizontal by this {
        override val spacing: Dp
            get() = spacing

        override fun toString(): String = super.toString() + "#$spacing"
    }

@Stable
fun Arrangement.HorizontalOrVertical.withSpace(spacing: Dp) =
    object : Arrangement.HorizontalOrVertical by this {
        override val spacing: Dp
            get() = spacing

        override fun toString(): String = super.toString() + "#$spacing"
    }

@Stable
fun Arrangement.spaceEvenly(spacing: Dp) = SpaceEvenly.withSpace(spacing)

@Stable
fun Arrangement.spaceBetween(spacing: Dp) = SpaceBetween.withSpace(spacing)

@Stable
fun Arrangement.spaceAround(spacing: Dp) = SpaceAround.withSpace(spacing)

object TopWithFooterArrangement : Arrangement.Vertical {
    override fun Density.arrange(
        totalSize: Int,
        sizes: IntArray,
        outPositions: IntArray,
    ) {
        var y = 0
        sizes.forEachIndexed { index, size ->
            outPositions[index] = y
            y += size
        }
        if (y < totalSize) {
            val lastIndex = outPositions.lastIndex
            if (lastIndex >= 0) {
                outPositions[lastIndex] = totalSize - sizes.last()
            }
        }
    }
}