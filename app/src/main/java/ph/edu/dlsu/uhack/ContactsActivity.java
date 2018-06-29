package ph.edu.dlsu.uhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class ContactsActivity extends AppCompatActivity {

    ImageView ivBack;
    Button btnSave;
    RecyclerView rvContacts;
    ContactsAdapter ca;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactsActivity.super.onBackPressed();
            }
        });

        btnSave = findViewById(R.id.btn_save);

        final ArrayList<Contacts> contacts = new ArrayList<>();

        db = new DatabaseHelper(getBaseContext());
        ca = new ContactsAdapter(getBaseContext(), db.getAllContactsCursor());
        rvContacts.setAdapter(ca);

        //TODO check status of checkbox by using the method -> isChecked()

        rvContacts.setLayoutManager(new LinearLayoutManager(
                getBaseContext(), LinearLayoutManager.VERTICAL, false
        ));

    }
}
