package ph.edu.dlsu.uhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    ImageView ivBack, ivContacts, ivMessage;
    ImageButton ibHome, ibEvac, ibBag, ibFirstaid, ibDrills, ibSettings;
    RelativeLayout rlContacts, rlMessage;
    TextView tvSelected;
    Button btnSOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        btnSOS = findViewById(R.id.btn_sos);
        ibHome = findViewById(R.id.ib_home);
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
        btnSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setClass(getBaseContext(), SOSMessageActivity.class);
            }
        });

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SettingsActivity.super.onBackPressed();
            }
        });

        ivContacts = findViewById(R.id.iv_contacts);
        ivMessage = findViewById((R.id.iv_message));

        rlContacts = findViewById(R.id.rl_contacts);
        rlContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_CALL);
                i.setClass(getBaseContext(), ContactsActivity.class);
            }
        });

        rlMessage = findViewById(R.id.rl_message);
        rlMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tvSelected = findViewById(R.id.tv_selected);
        //TODO get total number of selected people then setText("");
    }
}
