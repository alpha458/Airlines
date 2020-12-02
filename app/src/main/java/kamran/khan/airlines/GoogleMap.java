package kamran.khan.airlines;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

/*import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;*/

public class GoogleMap extends FragmentActivity /*implements OnMapReadyCallback*/ {

    /*com.google.android.gms.maps.GoogleMap mapAPI;
    SupportMapFragment mapFragment;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);
       /* mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapAPI);
        mapFragment.getMapAsync(this);*/
    }

   /* @Override
    public void onMapReady(com.google.android.gms.maps.GoogleMap googleMap) {
        mapAPI = googleMap;
        LatLng Abbtabad=new LatLng(34.156689450102604, 73.21590000000003);
        mapAPI.addMarker(new MarkerOptions().position(Abbtabad).title("Abbtabad"));
        mapAPI.moveCamera(CameraUpdateFactory.newLatLng(Abbtabad));


    }*/
}
