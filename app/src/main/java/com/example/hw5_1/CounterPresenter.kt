package com.example.hw5_1

import android.graphics.Color

class CounterPresenter {

    private val model = CounterModel()
    private var counterView: CounterView? = null

    fun attachCounterView(counterView: CounterView) {
        this.counterView = counterView
        counterView.showResult(model.getReCount())
    }

    fun onIncrement() {
        model.increment()
        val result = model.getReCount()
        counterView?.showResult(model.getReCount())
        checkForSpecialValue(result)
    }

    fun onDecrement() {
        model.decrement()
        val result = model.getReCount()
        counterView?.showResult(model.getReCount())
        checkForSpecialValue(result)
    }

    fun detachCounterView() {
        this.counterView = null
    }

    private fun checkForSpecialValue(value: Int) {
        if (value == 10) {
            counterView?.showToast("Поздравляем")
        }
        if (value == 15 ) {
            counterView?.changeColor(Color.GREEN)
        } else {
            counterView?.changeColor(Color.BLACK)
        }
    }
}