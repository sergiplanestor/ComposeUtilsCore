package com.revolhope.core.preview

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

data class PreviewComponentBuilderWrapper(
    val builder: @Composable () -> Unit
)

class PreviewComponentProvider(private val wrapper: PreviewComponentBuilderWrapper) :
    PreviewParameterProvider<PreviewComponentBuilderWrapper> {
    override val values: Sequence<PreviewComponentBuilderWrapper>
        get() = sequenceOf(wrapper)
}

@Preview
@Composable
fun PreviewComponent(@PreviewParameter(PreviewComponentProvider::class) wrapper: PreviewComponentBuilderWrapper) {
    PreviewComponentLight(wrapper)
    PreviewComponentDark(wrapper)
}

@Preview(name = "Preview Light", device = Devices.PIXEL_3, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun PreviewComponentLight(@PreviewParameter(PreviewComponentProvider::class) wrapper: PreviewComponentBuilderWrapper) {
    wrapper.builder.invoke()
}


@Preview(name = "Preview Dark", device = Devices.PIXEL_3, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewComponentDark(@PreviewParameter(PreviewComponentProvider::class) wrapper: PreviewComponentBuilderWrapper) {
    wrapper.builder.invoke()
}