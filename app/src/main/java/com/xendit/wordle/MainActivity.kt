package com.xendit.wordle

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.xendit.wordle.ui.theme.WordleTheme
import com.xendit.wordle.ui.viewmodel.WordleViewModel

class MainActivity : ComponentActivity() {

    lateinit var wordleViewModel: WordleViewModel

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wordleViewModel=ViewModelProvider(this).get(WordleViewModel::class.java)
        setContent {
            WordleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TopAppBar(title = {
                            Text(text = "Wordle App")
                        }, modifier = Modifier
                            .height(60.dp)
                            .background(color = Color.Blue))
                    }


                    wordleViewModel.getWordleLiveData1().observe(this, Observer {
                        Toast.makeText(this,it.toString().toUpperCase(),Toast.LENGTH_SHORT).show()
                    })

                    wordleViewModel.getWordleLiveData1().observe(this, Observer {
                        Toast.makeText(this,it.toString().toUpperCase(),Toast.LENGTH_SHORT).show()
                    })

                    wordleViewModel.getWordleLiveData2().observe(this, Observer {
                        Toast.makeText(this,it.toString().toUpperCase(),Toast.LENGTH_SHORT).show()
                    })

                    wordleViewModel.getWordleLiveData3().observe(this, Observer {
                        Toast.makeText(this,it.toString().toUpperCase(),Toast.LENGTH_SHORT).show()
                    })

                    wordleViewModel.getWordleLiveData4().observe(this, Observer {
                        Toast.makeText(this,it.toString().toUpperCase(),Toast.LENGTH_SHORT).show()
                    })

                    wordleViewModel.getWordleLiveData5().observe(this, Observer {
                        Toast.makeText(this,it.toString().toUpperCase(),Toast.LENGTH_SHORT).show()
                    })

                    wordleViewModel.getWordleLiveData6().observe(this, Observer {
                        Toast.makeText(this,it.toString().toUpperCase(),Toast.LENGTH_SHORT).show()
                    })

                    // Wordle Screen

                    WordleScreen(wordleViewModel)



                }


            }
        }
    }
}




@ExperimentalComposeUiApi
@Composable
fun WordleScreen(wordleViewModel: WordleViewModel) {
    val context = LocalContext.current
    var getWords: String? = null

    Column(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            WordleTextFields(length = 5,wordleViewModel = wordleViewModel) { getWordS ->
                getWords = getWordS
                wordleViewModel.wordleLiveData1.value=getWordS
            }

            Spacer(modifier = Modifier.height(10.dp))

            WordleTextFields(length = 5,wordleViewModel = wordleViewModel) { getWordS ->
                getWords = getWordS
                wordleViewModel.wordleLiveData2.value=getWordS
            }

            Spacer(modifier = Modifier.height(10.dp))

            WordleTextFields(length = 5,wordleViewModel = wordleViewModel) { getWordS ->
                getWords = getWordS
                wordleViewModel.wordleLiveData3.value=getWordS
            }

            Spacer(modifier = Modifier.height(10.dp))

            WordleTextFields(length = 5,wordleViewModel = wordleViewModel) { getWordS ->
                getWords = getWordS
                wordleViewModel.wordleLiveData4.value=getWordS
            }

            Spacer(modifier = Modifier.height(10.dp))

            WordleTextFields(length = 5,wordleViewModel = wordleViewModel) { getWordS ->
                getWords = getWordS
                wordleViewModel.wordleLiveData5.value=getWordS
            }

            Spacer(modifier = Modifier.height(10.dp))

            WordleTextFields(length = 5,wordleViewModel = wordleViewModel) { getWordS ->
                getWords = getWordS
                wordleViewModel.wordleLiveData6.value=getWordS
            }
        }
    }


}



