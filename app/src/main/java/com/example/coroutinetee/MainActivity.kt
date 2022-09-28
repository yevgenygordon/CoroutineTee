package com.example.coroutinetee

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.coroutinetee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var sound = MediaPlayer.create(this, R.raw.teelied)



        binding.homeFab.setOnClickListener {
            viewModel.loadData()
            binding.textImageTextView.text = ""
            sound = MediaPlayer.create(this, R.raw.teelied)

            sound.start()
        }
        
        
        binding.stopFAB.setOnClickListener { 
            sound.stop()
        }

        // image LiveData wird beobachtet und ändert Inhalt der TextView bei Bedarf
        viewModel.text.observe(
            this,
            Observer {
                binding.textImageTextView.text = it

               binding.progressBar.incrementProgressBy(5)
               // binding.progressBar.setProgress(10,true)

            }
        )

        // loading LiveData wird beobachtet und macht Spinner bei Bedarf sichtbar
        viewModel.loading.observe(
            this,
            Observer {
                if (it == true) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE


                }
            }
        )


    }


}
