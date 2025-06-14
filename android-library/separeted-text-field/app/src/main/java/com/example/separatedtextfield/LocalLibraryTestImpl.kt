package com.example.separatedtextfield

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun LocalLibraryTestImpl(

) {
    Box(
        Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        SeparatedTextField(
            value = "3",
            onValueChange = {},
            length = 4,
            isErrorOnCodeWritten = false,
        )
    }

}

@Preview
@Composable
private fun LocalLibraryTestImplPrev() {
    LocalLibraryTestImpl()
}