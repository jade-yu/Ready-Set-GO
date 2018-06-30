package ph.edu.dlsu.uhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FirstAidActivity extends AppCompatActivity {

    ImageButton ibCPR, ibUnconscious, ibBleeding, ibBurns, ibBack, ibHome, ibEvac, ibBag, ibFirstaid, ibDrills, ibSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        ibCPR = findViewById(R.id.ib_cpr);
        ibUnconscious = findViewById(R.id.ib_unconscious);
        ibBleeding = findViewById(R.id.ib_bleeding);
        ibBurns = findViewById(R.id.ib_burns);
        ibHome = findViewById(R.id.ib_home);
        ibEvac = findViewById(R.id.ib_evac);
        ibBag = findViewById(R.id.ib_bag);
        ibFirstaid = findViewById(R.id.ib_firstaid);
        ibDrills = findViewById(R.id.ib_drills);
        ibSettings = findViewById(R.id.ib_settings);
        ibBack = findViewById(R.id.btn_back);

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstAidActivity.super.onBackPressed();
            }
        });


        ibCPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), CPRActivity.class);
                startActivity(i);
            }
        });

        ibUnconscious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), UnconsciousActivity.class);
                startActivity(i);

            }
        });

        ibBleeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), BleedActivity.class);
                startActivity(i);

            }
        });

        ibBurns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), BurnActivity.class);
                startActivity(i);

            }
        });

        ibEvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EvacuationAreasActivity.class);
                startActivity(i);
            }
        });

        ibBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), GoBagActivity.class);
                startActivity(i);
            }
        });

        ibFirstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), FirstAidActivity.class);
                startActivity(i);
            }
        });

        ibDrills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DrillsActivity.class);
                startActivity(i);
            }
        });

        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(i);
            }
        });

    }
}
