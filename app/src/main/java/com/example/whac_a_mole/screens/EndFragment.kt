package com.example.whac_a_mole.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.whac_a_mole.APP_PREFERENCES
import com.example.whac_a_mole.R
import com.example.whac_a_mole.RECORD_SCORE
import com.example.whac_a_mole.databinding.FragmentEndBinding

class EndFragment : Fragment() {

    private lateinit var binding: FragmentEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEndBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val score = requireArguments().getInt(SCORE)
        val scoreText = "Your score:$score"
        binding.scoreText.text = scoreText

        val recordScore = APP_PREFERENCES.getInt(RECORD_SCORE,0)
        if(score>recordScore) {
            APP_PREFERENCES.edit().putInt(RECORD_SCORE, score).apply()
            binding.newRecordText.visibility = View.VISIBLE
        }
        val recordText = "Record score:$recordScore"
        binding.recordText.text = recordText


        binding.menuButton.setOnClickListener {
            findNavController().navigate(R.id.action_endFragment_to_startFragment)
        }
        binding.playAgainButton.setOnClickListener {
            findNavController().navigate(R.id.action_endFragment_to_gameFragment)
        }
    }

    companion object{
        const val SCORE = "score"
    }
}