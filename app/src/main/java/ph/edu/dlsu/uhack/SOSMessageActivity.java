package ph.edu.dlsu.uhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SOSMessageActivity extends AppCompatActivity {

    ImageView ivBack;
    EditText etMessage;
    Button btnSave, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sosmessage);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SOSMessageActivity.super.onBackPressed();
            }
        });

        etMessage = findViewById(R.id.et_message);
        etMessage.setText("[SOS] \n" +
                            "This is my location: ___. Please send help!");
        //TODO get customized sos message if exists then setText("");


        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO save to db
                SOSMessageActivity.super.onBackPressed();
            }
        });

        btnCancel = findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SOSMessageActivity.super.onBackPressed();
            }
        });
    }
}
