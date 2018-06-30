package ph.edu.dlsu.uhack;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnTest;
    DatabaseHelper dbHelper;
    Button btnSOS;
    String msg = "THIS IS AN EMERGENCY! THIS IS MY LOCATION ... SEND HELP!";

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    String number = "09176273602";
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
                finish();
            }
        });

        ibEvac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), EvacuationAreasActivity.class);
                startActivity(i);
                finish();
            }
        });

        ibBag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), GoBagActivity.class);
                startActivity(i);
                finish();
            }
        });

        ibFirstaid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), FirstAidActivity.class);
                startActivity(i);
                finish();
            }
        });

        ibDrills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DrillsActivity.class);
                startActivity(i);
                finish();
            }
        });

        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(i);
                finish();
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


        btnSOS = (Button) findViewById(R.id.btn_sos);
        btnSOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("buttonClicked ", "Click");
                sendSMSMessage();
            }
        });
    }

    protected void sendSMSMessage() {
        Log.d("buttonClicked ", "sendSMSMessage");
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS) !=
                PackageManager.PERMISSION_GRANTED) {
            Log.d("TAG", "Permission not granted");
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    MY_PERMISSIONS_REQUEST_SEND_SMS);
            Log.d("TAG", "ACCEPTED");
        } else {
            Log.d("TAG","HERe");
            sendAgain();
        }
    }

    public void sendAgain() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "SMS sent.",
                    Toast.LENGTH_LONG).show();
        } catch (Exception e ) {
            Toast.makeText(getApplicationContext(), "SMS failed to send.",
                    Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        String test = Integer.toString(MY_PERMISSIONS_REQUEST_SEND_SMS);
        Log.d("TAG",test);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {
                if (permissions[0].equalsIgnoreCase(Manifest.permission.SEND_SMS)
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    sendAgain();
                } else {
                    // Permission denied.
                    Log.d("TAG", "FAILED PERMISSION");
                    Toast.makeText(this,"FAILED PERMISSION",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
