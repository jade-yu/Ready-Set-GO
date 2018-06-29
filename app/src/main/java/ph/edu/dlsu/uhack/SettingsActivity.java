package ph.edu.dlsu.uhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    ImageView ivBack, ivContacts, ivMessage;
    RelativeLayout rlContacts, rlMessage;
    TextView tvSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

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
