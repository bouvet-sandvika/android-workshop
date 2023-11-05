package com.example.androidworkshop.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private val seekBarListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
            binding.tvtTipPercentLabel.text = "$progress%"
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {}

        override fun onStopTrackingTouch(p0: SeekBar?) {}

    }

    companion object {
        private const val INITIAL_TIP_PERCENT = 15
    }
}