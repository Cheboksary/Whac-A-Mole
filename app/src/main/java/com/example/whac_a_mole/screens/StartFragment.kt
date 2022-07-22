package com.example.whac_a_mole.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.whac_a_mole.APP_PREFERENCES
import com.example.whac_a_mole.R
import com.example.whac_a_mole.RECORD_SCORE
import com.example.whac_a_mole.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recordScore = APP_PREFERENCES.getInt(RECORD_SCORE,0)
        val recordScoreText = "Your record score:$recordScore"
        binding.recordText.text = recordScoreText

        binding.playButton.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_gameFragment)
        }
    }

}