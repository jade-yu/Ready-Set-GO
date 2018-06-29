package ph.edu.dlsu.uhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;

public class GoBagActivity extends AppCompatActivity {

    ImageView ivBack;
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
        cbBlanket = findViewById(R.id.cb_blanket);

    }
}
