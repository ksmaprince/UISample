package com.ksma.uisample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ksma.uisample.databinding.ActivityBookingBinding
import com.smarteist.autoimageslider.SliderView
import com.smarteist.autoimageslider.SliderViewAdapter


class BookingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookingBinding

    private lateinit var ivArrowBack: ImageView

    private lateinit var imageSlider: SliderView


    private val sliderAdapter = ImageSliderAdapter()

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, BookingActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ivArrowBack = binding.ivArrowBack
        imageSlider = binding.imageSlider

        val imageList = arrayListOf<String>()
        imageList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaoEHVUq7_Uq21jvc0n8LDtAdWbS6OhLH27A&usqp=CAU")
        imageList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYazYA6TDrOkxpHnOHiyql-1sRlUEyI-9cWjqnPSvocARWRBNjYZ65Yaw73FWdAKMLrdE&usqp=CAU")
        imageList.add("https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/350x197/quality/95/https://s.aolcdn.com/os/ab/_cms/2021/07/08200758/Nissan-Skyline-GT-R-R34-auction-02.jpg")
        imageList.add("https://im.rediff.com/money/2015/oct/26maruiti-baleno.jpg")

        imageSlider.setSliderAdapter(sliderAdapter)
        sliderAdapter.renewItems(imageList)
        imageSlider.isAutoCycle = true
        imageSlider.startAutoCycle()
        ivArrowBack.setOnClickListener {
            onBackPressed()
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(
            R.anim.anim_fade_in, R.anim.anim_fade_out
        )
    }


}