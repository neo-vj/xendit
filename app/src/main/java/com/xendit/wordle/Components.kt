package com.xendit.wordle

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import com.xendit.wordle.ui.viewmodel.WordleViewModel

@ExperimentalComposeUiApi
@Composable
fun WordleTextFields(modifier: Modifier = Modifier, length: Int,wordleViewModel: WordleViewModel, onFilled: (code: String) -> Unit){
    var code: List<Char> by remember { mutableStateOf(listOf()) }


    val focusRequesters: List<FocusRequester> = remember {
        val temp = mutableListOf<FocusRequester>()
        repeat(length) {
            temp.add(FocusRequester())
        }
        temp
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    Row(modifier = Modifier.height(60.dp)) {
        (0 until length).forEach { index ->
            OutlinedTextField(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
                    .focusOrder(focusRequester = focusRequesters[index]) {
                        focusRequesters[index + 1].requestFocus()
                    },
                textStyle = MaterialTheme.typography.subtitle2.copy(
                    textAlign = TextAlign.Center, color = Color.Black,fontWeight = FontWeight.Bold
                ),
                singleLine = true,
                value = code.getOrNull(index = index)?.takeIf {
                    it.isLetter()
                }?.toString()?.toUpperCase() ?: "",
                onValueChange = { value: String ->
                    if (focusRequesters[index].freeFocus()) {
                        val temp = code.toMutableList()
                        if (value == "") {
                            if (temp.size > index) {
                                temp.removeAt(index = index)
                                code = temp
                                focusRequesters.getOrNull(index - 1)?.requestFocus()
                            }
                        } else {
                            if (code.size > index) {
                                temp[index] = value.getOrNull(0) ?: ' '
                            } else {
                                temp.add(value.getOrNull(0) ?: ' ')
                                code = temp
                                focusRequesters.getOrNull(index = index + 1)?.requestFocus()
                                    ?: null
                            }
                        }
                    }

                },

                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = if ((index+1)<length){
                        ImeAction.Next}else{
                        ImeAction.Done
                    }
                ),

                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        wordleViewModel.firstWordle.value=code
                        onFilled(code.joinToString(separator = ""))
                    },
                    onPrevious = {
                        focusRequesters.getOrNull(index = index-1)?.requestFocus()
                    }
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black,
                    cursorColor = Color.Transparent
                )



                // visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.width(15.dp))

        }
    }
}