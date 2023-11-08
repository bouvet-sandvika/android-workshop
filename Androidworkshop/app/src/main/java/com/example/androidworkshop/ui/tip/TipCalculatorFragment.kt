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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTipCalculatorBinding.inflate(inflater, container, false)

        val root: View = binding.root

        binding.seekbarTip.progress = INITIAL_TIP_PERCENT
        binding.tvtTipPercentLabel.text = "$INITIAL_TIP_PERCENT%"
        binding.etBaseAmount.addTextChangedListener(textChangedListener)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private val textChangedListener = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(p0: Editable?) {
        }
    }


    companion object {
        private const val INITIAL_TIP_PERCENT = 15
    }
}