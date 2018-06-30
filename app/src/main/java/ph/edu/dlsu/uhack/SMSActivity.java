package ph.edu.dlsu.uhack;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.app.Activity;

import android.support.v4.app.ActivityCompat;
import android.telephony.SmsManager;

import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SMSActivity extends Activity {
    SOSMessage msg;
    Button btnSOS;
    DatabaseHelper dbHelper;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    String number = "09229171551";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String def = "THIS IS AN EMERGENCY! THIS IS MY LOCATION ... SEND HELP!";
        long id = dbHelper.addMsg(new SOSMessage(def));
        msg = dbHelper.getMsg(id);

        //ArrayList<Contact> = retrieve contacts from database
        btnSOS = (Button) findViewById(R.id.send_btn);
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
            smsManager.sendTextMessage(number, null, msg.getMessage(), null, null);
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