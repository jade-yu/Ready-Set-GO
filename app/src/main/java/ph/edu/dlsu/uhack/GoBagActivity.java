package ph.edu.dlsu.uhack;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class GoBagActivity extends AppCompatActivity {
    DatabaseHelper dbHelper;
    long id;
    GoBagItems goItems;
    ImageView ivBack;
    Button btnSave;
    CheckBox cbWater, cbFood, cbRadio, cbFlashlight, cbKit, cbBatteries, cbWhistle, cbMask, cbPlastic,
            cbTools, cbCanopener, cbMaps, cbPhones, cbMedications, cbCash, cbDocuments, cbBlanket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_bag);
        dbHelper = new DatabaseHelper(getBaseContext());
        id = -1;
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

        ArrayList<GoBagItems> blist = dbHelper.getGoBag();
        Log.d("BLIST SIZE", Integer.toString(blist.size()));
        if (blist.size() > 0) {
            goItems = dbHelper.getBag(1);
            id = goItems.getId();

            cbWater.setChecked(goItems.isWater());
            cbFood.setChecked(goItems.isFood());
            cbRadio.setChecked(goItems.isRadio());
            cbFlashlight.setChecked(goItems.isFlashlight());
            cbKit.setChecked(goItems.isKit());
            cbBatteries.setChecked(goItems.isBatteries());
            cbWhistle.setChecked(goItems.isWhistle());
            cbPlastic.setChecked(goItems.isPlastic());
            cbTools.setChecked(goItems.isPlastic());
            cbCanopener.setChecked(goItems.isCanopener());
            cbMaps.setChecked(goItems.isMaps());
            cbPhones.setChecked(goItems.isPhones());
            cbMedications.setChecked(goItems.isMedications());
            cbCash.setChecked(goItems.isCash());
            cbDocuments.setChecked(goItems.isDocuments());
            cbBlanket.setChecked(goItems.isBlanket());

        }

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
                Log.d("TAG", "SAVE IS CLICKED!");
                GoBagItems gb = new GoBagItems(cbWater.isChecked(), cbFood.isChecked(), cbRadio.isChecked(), cbFlashlight.isChecked(), cbKit.isChecked(),
                        cbBatteries.isChecked(), cbWhistle.isChecked(), cbMask.isChecked(), cbPlastic.isChecked(), cbTools.isChecked(),
                        cbCanopener.isChecked(), cbMaps.isChecked(), cbPhones.isChecked(), cbMedications.isChecked(), cbCash.isChecked(),
                        cbDocuments.isChecked(), cbBlanket.isChecked());
                if(goItems == null) {
                    long _id = dbHelper.addGoBag(gb);
                    if(_id > 0)
                    Toast.makeText(getApplicationContext(), "SAVED",
                            Toast.LENGTH_LONG).show();
                } else {
                    boolean success = dbHelper.editGoBagItems(gb, id);
                    if(success)
                        Toast.makeText(getApplicationContext(), "SAVED",
                                Toast.LENGTH_LONG).show();

                    Log.d("Edited GO BAG", Long.toString(id));

                }
            }
        });


    }
}
