package ph.edu.dlsu.uhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DrillsActivity extends AppCompatActivity {




    ImageButton ibTyphoon, ibFlood, ibEarthquake, ibFire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drills);

        ibTyphoon = findViewById(R.id.ib_typhoon);
        ibFlood = findViewById(R.id.ib_flood);
        ibEarthquake = findViewById(R.id.ib_earthquake);
        ibFire = findViewById(R.id.ib_fire);

        ibTyphoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ibFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ibEarthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ibFire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
