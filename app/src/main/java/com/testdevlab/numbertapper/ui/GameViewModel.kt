package com.testdevlab.numbertapper.ui

import androidx.lifecycle.ViewModel
import com.testdevlab.numbertapper.R
import com.testdevlab.numbertapper.common.GRAY
import com.testdevlab.numbertapper.common.GREEN
import com.testdevlab.numbertapper.common.INITIAL_LINGO
import com.testdevlab.numbertapper.common.ORANGE
import kotlinx.coroutines.flow.*
import java.lang.NumberFormatException
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private val _lingoNumber = MutableStateFlow(INITIAL_LINGO)
    private val _onError = MutableSharedFlow<Int>(replay = 1)
    private val _times = MutableStateFlow(1)

    var generatedLingo = randomNumberList()
    var reizes: Int = 0
    val times = _times.asStateFlow()
    val onError = _onError.asSharedFlow()

    fun returnListe(): List<String> {
        return generatedLingo
    }

    fun randomNumber(): String {
        return Random.nextInt(10).toString()
    }

    fun randomNumberList(): List<String> {
        return listOf(randomNumber(), randomNumber(), randomNumber(), randomNumber())
    }

    fun inputCheck(input: String): Boolean {
        try {
            val testIfNumber = input.toInt()
            if (input.length != 4) {
                _onError.tryEmit(R.string.length_error)
            }
            else {
                _lingoNumber.value = input
                return true
            }
        } catch (e: NumberFormatException) {
            _onError.tryEmit(R.string.input_error)
        }
        return false
    }

    fun colorCheck(userInput: String, pos: Int): Int {
        _times.value += 1
        return if (userInput == generatedLingo[pos]) {
            ORANGE
        } else if (userInput in generatedLingo) {
            GREEN
        } else {
            GRAY
        }
    }

    fun finished(input: String): Boolean {
        val inputEl = input.toList()
        if (inputEl.toString() == generatedLingo.toString()){
            return true
        }
        return false
    }

    fun tries() {
        reizes += 1
    }

    fun updateList() {
        generatedLingo = randomNumberList()
    }
}
