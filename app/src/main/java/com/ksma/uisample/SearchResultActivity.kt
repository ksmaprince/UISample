package com.ksma.uisample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ksma.uisample.databinding.ActivitySearchResultBinding

class SearchResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchResultBinding
    private val carAdapter = CarAdapter()
    private lateinit var rvCar: RecyclerView
    private lateinit var ivBackArrow: ImageView

    companion object {
        fun newInstance(context: Context): Intent {
            return Intent(context, SearchResultActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvCar = binding.rvCarList
        ivBackArrow = binding.ivArrowBack

        val cars = arrayListOf<Car>()
        cars.add(Car("Caldina", "CRL100z   5 Seater", "https://static.carfromjapan.com/spec_eab9d0c5-44db-4ac6-8e51-b5e0a63f718c_640_0"))
        cars.add(Car("Zusuki", "PPM145p   5 Seater", "https://mcmscache.epapr.in/post_images/website_300/post_18234677/thumb.jpg"))
        cars.add(Car("Toyota M2 ", "KTL7780   5 Seater", "https://static.carfromjapan.com/spec_0ab0491d-6763-494d-b553-2af11b46bc18_640_0"))
        cars.add(Car("Tesla", "SMS190z   5 Seater", "https://www.focus2move.com/wp-content/uploads/2020/08/Tesla-Roadster-2020-1024-03.jpg"))
        cars.add(Car("Mazada 3", "SM-AT0z   5 Seater", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaoEHVUq7_Uq21jvc0n8LDtAdWbS6OhLH27A&usqp=CAU"))
        cars.add(Car("Isuzu", "SMS1dk0z   5 Seater", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYazYA6TDrOkxpHnOHiyql-1sRlUEyI-9cWjqnPSvocARWRBNjYZ65Yaw73FWdAKMLrdE&usqp=CAU"))
        cars.add(Car("Nissan", "KTL100z   5 Seater", "https://s.aolcdn.com/dims-global/dims3/GLOB/legacy_thumbnail/350x197/quality/95/https://s.aolcdn.com/os/ab/_cms/2021/07/08200758/Nissan-Skyline-GT-R-R34-auction-02.jpg"))
        cars.add(Car("Maruti", "SMOp00z   5 Seater", "https://im.rediff.com/money/2015/oct/26maruiti-baleno.jpg"))
        cars.add(Car("Carfex", "SMS100z   5 Seater", "https://cfx-wp-images.imgix.net/2019/10/2020-Chevrolet-Corvette-Stingray.jpg?auto=compress%2Cformat&fit=crop&h=620&ixlib=php-3.3.0&w=930&wpsize=neve-blog&s=febdb20b4ae91b42276fd57dd274d39d"))
        cars.add(Car("Orgy", "SMS100z   5 Seater", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxbpeZ169YnehcUAIRdaWqR-am0UECi8fudA&usqp=CAU"))
        cars.add(Car("Insight", "SMMt00Pz   5 Seater", "https://di-honda-enrollment.s3.amazonaws.com/2021/model-pages/insight/model-image-2021-honda-insight-front.png"))
        cars.add(Car("Honda Insight", "ADz000A   5 Seater", "http://img.autoabc.lv/Honda-Insight/Honda-Insight_2009_Hecbeks_15112613029_12.jpg"))

        rvCar.layoutManager = LinearLayoutManager(this)
        rvCar.setHasFixedSize(true)
        rvCar.adapter = carAdapter

        carAdapter.cars = cars

        ivBackArrow.setOnClickListener {
            onBackPressed()
        }
        
        carAdapter.setOnItemClickListener(object : CarAdapter.OnItemClickListener{
            override fun onItemClick() {
                startActivity(BookingActivity.newInstance(this@SearchResultActivity))
                overridePendingTransition(
                    R.anim.anim_fade_in, R.anim.anim_fade_out
                )
            }

        })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(
            R.anim.anim_fade_in, R.anim.anim_fade_out
        )
    }
}