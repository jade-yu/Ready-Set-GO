package ph.edu.dlsu.uhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class FirstAidActivity extends AppCompatActivity {

    ImageButton ibCPR, ibUnconscious, ibBleeding, ibBurns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_aid);

        ibCPR = findViewById(R.id.ib_cpr);
        ibUnconscious = findViewById(R.id.ib_unconscious);
        ibBleeding = findViewById(R.id.ib_bleeding);
        ibBurns = findViewById(R.id.ib_burns);

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

    }
}
