package ezy.demo.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import ezy.demo.theme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.btnDefault.setOnClickListener { AppTheme.update(Themes.Default) }
        binding.btnDay.setOnClickListener { AppTheme.update(Themes.Day) }
        binding.btnNight.setOnClickListener { AppTheme.update(Themes.Night) }

    }
}