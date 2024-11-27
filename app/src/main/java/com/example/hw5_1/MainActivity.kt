package com.example.hw5_1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.hw5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    private val presenter = CounterPresenter()
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachCounterView(this)

        binding.apply {
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
            btnIncrerment.setOnClickListener {
                presenter.onIncrement()
            }
        }

    }

    override fun showResult(count: Int) {
        binding.tvResult.text = count.toString()
    }

    override fun showToast(count: String) {
        Toast.makeText(this, count, Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(count: Int) {
        binding.tvResult.setTextColor(count)
    }
}