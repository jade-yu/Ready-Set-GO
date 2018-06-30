package ph.edu.dlsu.uhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GoBagActivity extends AppCompatActivity {

    ImageView ivBack;
    ImageButton ibHome, ibEvac, ibBag, ibFirstaid, ibDrills, ibSettings;
    Button btnSave;
    CheckBox cbWater, cbFood, cbRadio, cbFlashlight, cbKit, cbBatteries, cbWhistle, cbMask, cbPlastic,
            cbTools, cbCanopener, cbMaps, cbPhones, cbMedications, cbCash, cbDocuments, cbBlanket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_bag);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoBagActivity.super.onBackPressed();
            }
        });

        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cbWater = findViewById(R.id.cb_water);
        cbFood = findViewById(R.id.cb_food);
        cbRadio = findViewById(R.id.cb_radio);
        cbFlashlight = findViewById(R.id.cb_flashlight);
        cbKit = findViewById(R.id.cb_kit);
        cbBatteries = findViewById(R.id.cb_batteries);
        cbWhistle = findViewById(R.id.cb_whistle);
        cbMask = findViewById(R.id.cb_mask);
        cbPlastic = findViewById(R.id.cb_plastic);
        cbTools = findViewById(R.id.cb_tools);
        cbCanopener = findViewById(R.id.cb_canopener);
        cbMaps = findViewById(R.id.cb_maps);
        cbPhones = findViewById(R.id.cb_phones);
        cbMedications = findViewById(R.id.cb_medications);
        cbCash = findViewById(R.id.cb_cash);
        cbDocuments = findViewById(R.id.cb_documents);
        cbBlanket = findViewById(R.id.cb_blanket);ibHome = findViewById(R.id.ib_home);
        ibEvac = findViewById(R.id.ib_evac);
        ibBag = findViewById(R.id.ib_bag);
        ibFirstaid = findViewById(R.id.ib_firstaid);
        ibDrills = findViewById(R.id.ib_drills);

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

    }
}
