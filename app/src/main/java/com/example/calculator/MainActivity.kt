package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var firstNumber: Double = 0.0
    var lastNumber: Double = 0.0
    var opertion: Opertion? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button8.setOnClickListener {
            onClickNumber(binding.button8)
        }
        binding.button10.setOnClickListener {
            onClickNumber(binding.button10)
        }
        binding.button9.setOnClickListener {
            onClickNumber(binding.button9)
        }
        binding.appCompatButton2.setOnClickListener {
            onClickNumber(binding.appCompatButton2)
        }
        binding.appCompatButton.setOnClickListener {
            onClickNumber(binding.appCompatButton)
        }
        binding.appCompatButton3.setOnClickListener {
            onClickNumber(binding.appCompatButton3)
        }
        binding.appCompatButton6.setOnClickListener {
            onClickNumber(binding.appCompatButton6)
        }
        binding.appCompatButton5.setOnClickListener {
            onClickNumber(binding.appCompatButton5)
        }
        binding.appCompatButton7.setOnClickListener {
            onClickNumber(binding.appCompatButton7)
        }
        binding.zero.setOnClickListener {
            onClickNumber(binding.zero)
        }
        binding.dot.setOnClickListener {
            onClickNumber(binding.dot)
        }
        binding.button11.setOnClickListener {
            cleanNumber()
        }
        binding.appCompatButton8.setOnClickListener {
            dataInOperator(Opertion.remainder)
        }
        binding.button.setOnClickListener {
            dataInOperator(Opertion.plural)
        }
        binding.button3.setOnClickListener {
            dataInOperator(Opertion.division)
        }
        binding.button1.setOnClickListener {
            dataInOperator(Opertion.subtraction)
        }
        binding.button2.setOnClickListener {
            dataInOperator(Opertion.multiply)
        }
        binding.res.setOnClickListener {
            val result = resultOfACalculation()
            binding.Text1.text = result.toString()
        }
        binding.appCompatButton4.setOnClickListener {
            stringWithoutLastNumber()
        }
    }

    private fun stringWithoutLastNumber() {
        if(binding.Text1.text.isNotEmpty()){
            val num=binding.Text1.text.toString()
            binding.Text1.text=num.substring(0,num.length-1)
        }
    }

    private fun resultOfACalculation():Double {
        lastNumber = binding.Text1.text.toString().toDouble()
       return when (opertion) {
            Opertion.plural -> firstNumber + lastNumber
            Opertion.multiply -> firstNumber * lastNumber
            Opertion.subtraction -> firstNumber - lastNumber
            Opertion.division -> firstNumber / lastNumber
            null -> 0.0
           Opertion.remainder ->firstNumber % lastNumber
       }
    }


    private fun cleanNumber() {
        binding.Text1.text = ""
    }

    private fun dataInOperator(oper: Opertion) {
        firstNumber = binding.Text1.text.toString().toDouble()
        cleanNumber()
        opertion = oper
    }


    private fun onClickNumber(b: Button) {
        val newDigit = b.text.toString()
        val oldDigit = binding.Text1.text.toString()
        val newTextNumber = oldDigit + newDigit
        binding.Text1.text = newTextNumber
    }


}




