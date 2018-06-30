package ph.edu.dlsu.uhack;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Button btnTest;
    ImageButton ibHome, ibEvac, ibBag, ibFirstaid, ibDrills, ibSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.pbready);
        Drawable drawable2 = res.getDrawable(R.drawable.pbset);
        Drawable drawable3 = res.getDrawable(R.drawable.pbgo);

        final ProgressBar pbReady = findViewById(R.id.pbready);
        final ProgressBar pbSet = findViewById(R.id.pbset);
        final ProgressBar pbGo = findViewById(R.id.pbgo);

        ibHome = findViewById(R.id.ib_home);
        ibEvac = findViewById(R.id.ib_evac);
        ibBag = findViewById(R.id.ib_bag);
        ibFirstaid = findViewById(R.id.ib_firstaid);
        ibDrills = findViewById(R.id.ib_drills);
        ibSettings = findViewById(R.id.ib_settings);

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
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

        pbReady.setProgress(0);
        pbReady.setSecondaryProgress(100);
        pbReady.setMax(100);
        pbReady.setProgressDrawable(drawable);

        pbSet.setProgress(0);
        pbSet.setSecondaryProgress(100);
        pbSet.setMax(100);
        pbSet.setProgressDrawable(drawable2);

        pbGo.setProgress(0);
        pbGo.setSecondaryProgress(100);
        pbGo.setMax(100);
        pbGo.setProgressDrawable(drawable3);
    }

}
