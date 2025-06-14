package com.example.separatedtextfield

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun SeparatedTextField(
    value: String,
    length: Int,
    modifier: Modifier = Modifier,
    boxWidth: Dp = 38.dp,
    boxHeight: Dp = 38.dp,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    keyboardActions: KeyboardActions = KeyboardActions(),
    onValueChange: (String) -> Unit,
    isErrorOnCodeWritten: Boolean,
    keyboardController: SoftwareKeyboardController? = null,
    spaceBetweenFields: Dp = 12.dp,
    boxesCompleteColor: Color = Color(0xFF0794EC),
    defaultIncompleteColor: Color = Color(0XFFE2E2E2),
    errorOnCodeColor: Color = Color(0xFFFF8080),
    textColor: Color =  Color.Black
) {

    val showKeyboard = remember { mutableStateOf(true) }

    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(focusRequester) {
        if (showKeyboard.value) focusRequester.requestFocus()
        delay(100)
        keyboardController?.show()
    }


    BasicTextField(
        modifier = modifier
            .focusRequester(focusRequester)
            .testTag("codeInput"),
        value = value,
        singleLine = true,
        cursorBrush = SolidColor(Color.Black),
        onValueChange = {
            if (it.length <= length) {
                onValueChange(it)
            }
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = {
            Row(
                Modifier.size(width = (boxWidth + spaceBetweenFields) * length, height = boxHeight),
                horizontalArrangement = Arrangement.spacedBy(spaceBetweenFields),
            ) {
                repeat(length) { index ->
                    Box(
                        modifier = Modifier
                            .size(boxWidth, boxHeight)
                            .drawBehind {
                                val strokeWidth = 2.dp.toPx()
                                val y = size.height
                                drawLine(
                                    color = if (!isErrorOnCodeWritten) {
                                        if (index == value.length) boxesCompleteColor else defaultIncompleteColor
                                    } else {
                                        errorOnCodeColor
                                    },
                                    start = androidx.compose.ui.geometry.Offset(0f, y),
                                    end = androidx.compose.ui.geometry.Offset(size.width, y),
                                    strokeWidth = strokeWidth
                                )
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = value.getOrNull(index)?.toString() ?: "",
                            textAlign = TextAlign.Center,
                            color = textColor
                        )
                    }
                }
            }
        }
    )
}

@Preview
@Composable
private fun SeparatedTextFieldPrev() {
    SeparatedTextField(value = "5", length = 4, onValueChange = {}, isErrorOnCodeWritten = false)
}

