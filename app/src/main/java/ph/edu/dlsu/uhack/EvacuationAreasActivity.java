package ph.edu.dlsu.uhack;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class EvacuationAreasActivity extends FragmentActivity implements OnMapReadyCallback {

    final int ACCESS_LOCATION_PERMISSION = 1;

    private GoogleMap mMap;
    private FusedLocationProviderClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evacuation_areas);

        client = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng dlsu = new LatLng(14.5643, 120.9932);
        mMap.addMarker(new MarkerOptions().position(dlsu).title("Current Location"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(dlsu, 14));

        getLocation();
    }

    public void getLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
            return;
        } else {
            client.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if(location != null) {
                        Log.d("getLocation", location.getLatitude() + ", " + location.getLongitude());
                        LatLng currLocation = new LatLng(location.getLatitude(), location.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(currLocation).title("Current Location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(currLocation));
                        Log.d("getLocation", "success");
                    } else {
                        Log.d("getLocation", "null");
                    }
                }
            });
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_LOCATION_PERMISSION);
    }
}
