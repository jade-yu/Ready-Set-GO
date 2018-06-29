package ph.edu.dlsu.uhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class EvacuationAreasActivity extends AppCompatActivity {


    ImageButton ibTyphoon, ibFlood, ibEarthquake, ibFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evacuation_areas);
    }
}
