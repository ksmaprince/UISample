package com.ksma.uisample

import android.os.Bundle
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.ksma.uisample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding
    private lateinit var ivnoti: ImageView
    private lateinit var ivSend: ImageView
    private lateinit var rlSec4: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ivnoti= binding.ivNoti
        ivSend = binding.ivSend
        rlSec4 = binding.currentLocationLayout.rlSec4

        ivnoti.setOnClickListener {
            startActivity(SearchResultActivity.newInstance(this))
            overridePendingTransition(
                R.anim.anim_fade_in, R.anim.anim_fade_out
            )
        }
        ivSend.setOnClickListener {
            startActivity(SearchResultActivity.newInstance(this))
            overridePendingTransition(
                R.anim.anim_fade_in, R.anim.anim_fade_out
            )
        }
        rlSec4.setOnClickListener {
            startActivity(SearchResultActivity.newInstance(this))
            overridePendingTransition(
                R.anim.anim_fade_in, R.anim.anim_fade_out
            )
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val pagoda = LatLng(16.8362188,96.1904679)

        val padathar= LatLng(16.8362915,96.179045)

        val shwebaho = LatLng(16.8093443,96.1739543)

        val markerOption1 = MarkerOptions().position(LatLng(pagoda.latitude,pagoda.longitude))
        markerOption1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
        markerOption1.position(pagoda)
        val marker1 = mMap.addMarker(markerOption1)
        marker1.title = "Kyike Ka San Pagoda, Thingangyune Township"

        val markerOption2 = MarkerOptions().position(LatLng(padathar.latitude,padathar.longitude))
        markerOption2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW))
        markerOption2.position(padathar)
        val marker2 = mMap.addMarker(markerOption2)
        marker2.title = "Padathar Market"

        val markerOption3 = MarkerOptions().position(LatLng(shwebaho.latitude,shwebaho.longitude))
        markerOption3.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        markerOption3.position(shwebaho)
        val marker3 = mMap.addMarker(markerOption3)
        marker3.title = "Shwe Ba Ho Hospital"

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(pagoda, 12f), 500, null)
    }

}
