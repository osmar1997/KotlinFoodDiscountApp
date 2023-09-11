package ipca.combustivel.cmprojetooo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ipca.combustivel.cmprojetooo.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val mcdonalds = LatLng(41.53887883951652, -8.620200514110905)
        val steakandshake = LatLng(41.589555308034974, -8.404933133963713)
        val kfc = LatLng(41.580656349722304, -8.432030794512906)
        val burgerking = LatLng(41.537974616461916, -8.623538888610867)

        mMap.addMarker(MarkerOptions().position(burgerking).title("Burger King in Barcelos"))
        mMap.addMarker(MarkerOptions().position(kfc).title("Kfc in Braga"))
        mMap.addMarker(MarkerOptions().position(mcdonalds).title("Mcdonalds in Barcelos"))
        mMap.addMarker(MarkerOptions().position(steakandshake).title("SteakandShake in Braga"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mcdonalds, 10f))

    }
}