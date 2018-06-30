package ph.edu.dlsu.uhack;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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

    private ArrayList<Contact> contacts = new ArrayList<>();

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
        rvContacts = findViewById(R.id.rv_contacts);

        db = new DatabaseHelper(getBaseContext());

        //one time run
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            loadContacts();
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

        ca = new ContactsAdapter(getBaseContext(), db.getAllContactsCursor());
        rvContacts.setAdapter(ca);

        //TODO check status of checkbox by using the method -> isChecked()

        rvContacts.setLayoutManager(new LinearLayoutManager(
                getBaseContext(), LinearLayoutManager.VERTICAL, false
        ));

        ca.setOnItemClickListener(new ContactsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(long id) {
                Contact c = db.getContact(id);
                if(c.getChecked() == 0) {
                    c.setChecked(1);
                    Log.d("checked", "CHECKED SET TO ONE");
                }
                else {
                    c.setChecked(0);
                    Log.d("checked", "CHECKED SET TO ZERO");
                }
                db.editContact(id, c);
            }
        });
    }

    private ArrayList<Contact> loadContacts() {
        Log.d("load", "ITS GETTING CONTACTS");
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor =
                contentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                        null, null,null,null);
        if(cursor.getCount() > 0) {
            while(cursor.moveToNext()) {
                String id = cursor.getString(
                        cursor.getColumnIndex((ContactsContract.Contacts._ID)));
                String name = cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                int hasPhoneNumber = Integer.parseInt(cursor.getString(
                        cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)));

                if(hasPhoneNumber > 0) {
                    Cursor cursor2 = contentResolver.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);

                    while(cursor2.moveToNext()) {
                        String phoneNumber = cursor2.getString(
                                cursor2.getColumnIndex(
                                        ContactsContract.CommonDataKinds.Phone.NUMBER));
                        //builder.append("Contact: ").append(name).append("\nPhone Number: ").
                        //        append(phoneNumber).append("\n\n");
                        //add to arraylist
                        contacts.add(new Contact(name, phoneNumber));
                        db.addContact(new Contact(name, phoneNumber));
                    }

                    cursor2.close();
                }
            }
        }

        cursor.close();

        //tvContacts.setText(builder.toString());
        return contacts;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ca.changeCursor(db.getAllContactsCursor());
    }
}
