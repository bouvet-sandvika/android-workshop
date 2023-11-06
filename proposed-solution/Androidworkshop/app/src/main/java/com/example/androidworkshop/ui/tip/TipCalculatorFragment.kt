package com.example.androidworkshop.ui.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidworkshop.R
import com.example.androidworkshop.databinding.FragmentTipCalculatorBinding

class TipCalculatorFragment : Fragment() {

    private var _binding: FragmentTipCalculatorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var tipCalculatorViewModel: TipCalculatorViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        tipCalculatorViewModel = ViewModelProvider(this)[TipCalculatorViewModel::class.java]
        _binding = FragmentTipCalculatorBinding.inflate(inflater, container, false)

        val root: View = binding.root

        binding.seekbarTip.progress = INITIAL_TIP_PERCENT
        binding.tvtTipPercentLabel.text = "$INITIAL_TIP_PERCENT%"
        binding.seekbarTip.setOnSeekBarChangeListener(seekBarListener)
        binding.etBaseAmount.addTextChangedListener(textChangedListener)

        computeTipAndTotal()
        updateTipDescription(binding.seekbarTip.progress)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun computeTipAndTotal() {
        val baseAmount = binding.etBaseAmount.text.toString().toDoubleOrNull() ?: 0.0
        val tipPercent = binding.seekbarTip.progress


        val tipAmount = baseAmount * tipPercent / 100
        val totalAmount = baseAmount + tipAmount

        binding.tvTipAmount.text = getString(R.string.tip_calculator_2_decimals_value, tipAmount)
        binding.tvTotalAmount.text = getString(R.string.tip_calculator_2_decimals_value, totalAmount)
    }

    private fun updateTipDescription(tipPercent: Int) {
        val tipDescription = when(tipPercent) {
            in 0..9 -> "Poor"
            in 10..14 -> "Acceptable"
            in 15..19 -> "Good"
            in 20..24 -> "Great"
            else -> "Amazing"
        }

        binding.tvTipDescription.text = tipDescription
    }


    private val seekBarListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
            binding.tvtTipPercentLabel.text = "$progress%"
            computeTipAndTotal()
            updateTipDescription(progress)
        }
        override fun onStartTrackingTouch(p0: SeekBar?) {}
        override fun onStopTrackingTouch(p0: SeekBar?) {}
    }

    private val textChangedListener = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {
            computeTipAndTotal()
        }
    }


    companion object {
        private const val INITIAL_TIP_PERCENT = 15
    }
}