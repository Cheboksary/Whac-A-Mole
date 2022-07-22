package com.example.whac_a_mole.screens

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.forEach
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.whac_a_mole.R
import com.example.whac_a_mole.databinding.FragmentGameBinding
import kotlin.random.Random

class GameFragment : Fragment() {

    lateinit var binding: FragmentGameBinding
    private val handler = Handler(Looper.getMainLooper())
    private var timerIsCounting = true

    private var score = 0
        set(value) {
            binding.score.text = value.toString()
            field = value
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gameField.grid.forEach {
            it.setOnClickListener(whackClickListener)
        }
        startCountDownTimer()
        startGame()
    }

    private fun startGame() {
        Thread {
            while (timerIsCounting) {
                when (Random.nextInt(1, 9)) {
                    1 -> {
                        handler.post { binding.gameField.mole1.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole1.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    2 -> {
                        handler.post { binding.gameField.mole2.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole2.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    3 -> {
                        handler.post { binding.gameField.mole3.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole3.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    4 -> {
                        handler.post { binding.gameField.mole4.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole4.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    5 -> {
                        handler.post { binding.gameField.mole5.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole5.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    6 -> {
                        handler.post { binding.gameField.mole6.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole6.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    7 -> {
                        handler.post { binding.gameField.mole7.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole7.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    8 -> {
                        handler.post { binding.gameField.mole8.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole8.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                    9 -> {
                        handler.post { binding.gameField.mole9.visibility = View.VISIBLE }
                        handler.postDelayed({binding.gameField.mole9.visibility = View.INVISIBLE},DELAY)
                        Thread.sleep(DELAY)
                    }
                }
            }
        }.start()
    }

    private fun startCountDownTimer() {
        object : CountDownTimer(30000, 1000) {
            override fun onTick(p0: Long) {
                val sec = p0/1000
                val timer = if(p0/1000 > 9)
                    "0:$sec"
                else
                    "0:0$sec"
                binding.timer.text = timer
            }

            override fun onFinish() {
                timerIsCounting = false
                findNavController().navigate(
                    R.id.action_gameFragment_to_endFragment,
                    bundleOf(EndFragment.SCORE to score)
                )
            }
        }.start()
    }

    private val whackClickListener = View.OnClickListener {
        when(it.id){
            R.id.mole1 -> if(binding.gameField.mole1.isVisible) {
                binding.gameField.mole1.visibility = View.INVISIBLE
                score++
            }
            R.id.mole2 -> if(binding.gameField.mole2.isVisible) {
                binding.gameField.mole2.visibility = View.INVISIBLE
                score++
            }
            R.id.mole3 -> if(binding.gameField.mole3.isVisible) {
                binding.gameField.mole3.visibility = View.INVISIBLE
                score++
            }
            R.id.mole4 -> if(binding.gameField.mole4.isVisible) {
                binding.gameField.mole4.visibility = View.INVISIBLE
                score++
            }
            R.id.mole5 -> if(binding.gameField.mole5.isVisible) {
                binding.gameField.mole5.visibility = View.INVISIBLE
                score++
            }
            R.id.mole6 -> if(binding.gameField.mole6.isVisible) {
                binding.gameField.mole6.visibility = View.INVISIBLE
                score++
            }
            R.id.mole7 -> if(binding.gameField.mole7.isVisible) {
                binding.gameField.mole7.visibility = View.INVISIBLE
                score++
            }
            R.id.mole8 -> if(binding.gameField.mole8.isVisible) {
                binding.gameField.mole8.visibility = View.INVISIBLE
                score++
            }
            R.id.mole9 -> if(binding.gameField.mole9.isVisible) {
                binding.gameField.mole9.visibility = View.INVISIBLE
                score++
            }
        }
    }

    companion object {
        const val DELAY = 500L
    }
}