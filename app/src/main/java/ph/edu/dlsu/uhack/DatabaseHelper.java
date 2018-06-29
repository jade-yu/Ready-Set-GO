package ph.edu.dlsu.uhack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by G301 on 11/7/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SCHEMA = "contacts";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // ROLE : create the tables of this schema
        // will only be called once at the start by the system
        // when there is no db, it is called by the system

        String sql = "CREATE TABLE " + Contact.TABLE_NAME + " ("
                + Contact.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Contact.COLUMN_NAME + " TEXT, "
                + Contact.COLUMN_NUMBER + " TEXT, "
                + Contact.COLUMN_CHECKED + " INTEGER "
                + ");";
        db.execSQL(sql);

        addContact(db, new Contact("Vincent Tan", "09326286802"));
        // do not close conn
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int i, int i1) {
        // will only be called if there is change in version numbers

        // you want to migrate to the new db
        // drop the current tables
        String sql = "DROP TABLE IF EXISTS " + Contact.TABLE_NAME + ";";
        db.execSQL(sql);

        // call onCreate to get the latest db design
        onCreate(db);
    }

    // add Contact
    public boolean addContact(Contact contact){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contact.COLUMN_NAME, contact.getName());
        contentValues.put(Contact.COLUMN_NUMBER, contact.getNumber());
        contentValues.put(Contact.COLUMN_CHECKED, contact.getChecked());

        // id = -1 if fail
        long id = db.insert(Contact.TABLE_NAME,
                null,
                contentValues);
        db.close();
        return (id != -1);
    }

    public boolean addContact(SQLiteDatabase db, Contact contact){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contact.COLUMN_NAME, contact.getName());
        contentValues.put(Contact.COLUMN_NUMBER, contact.getNumber());
        contentValues.put(Contact.COLUMN_CHECKED, contact.getChecked());

        // id = -1 if fail
        long id = db.insert(Contact.TABLE_NAME,
                null,
                contentValues);
        return (id != -1);
    }

    // edit Contact
    public boolean editContact(long currentId, Contact newDetails){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Contact.COLUMN_NAME, newDetails.getName());
        contentValues.put(Contact.COLUMN_NUMBER, newDetails.getNumber());
        contentValues.put(Contact.COLUMN_CHECKED, newDetails.getChecked());

        int rows = db.update(Contact.TABLE_NAME,
                contentValues,
                Contact.COLUMN_ID + "=?",
                new String[]{currentId+""});
        db.close();
        return rows >0;
    }

    // remove Contact
    public boolean removeContact(long id){
        SQLiteDatabase db = getWritableDatabase();
        int rows = db.delete(Contact.TABLE_NAME,
                Contact.COLUMN_ID + " =?",
                new String[]{id+""});
        db.close();
        return rows > 0;
    }

    // retrieve Contact
    public Contact getContact(long id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(Contact.TABLE_NAME,
                null, // SELECT *
                Contact.COLUMN_ID + " =? ", // where clause
                new String[]{id+""}, // where args
                null, // groupby
                null, // having
                null); // orderby

        Contact contact = null;
        if(c.moveToFirst()){
            contact = new Contact();
            String name = c.getString(c.getColumnIndex(Contact.COLUMN_NAME));
            String number = c.getString(c.getColumnIndex(Contact.COLUMN_NUMBER));
            int checked = c.getInt(c.getColumnIndex(Contact.COLUMN_CHECKED));

            contact.setName(name);
            contact.setNumber(number);
            contact.setChecked(checked);
            contact.setId(id);
        }

        c.close();
        db.close();

        return contact;
    }

    // retrieve all Contacts
    public ArrayList<Contact> getAllContacts(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c= db.query(Contact.TABLE_NAME, null,null,null,null,null,null);

        ArrayList<Contact> contacts = null;

        if(c.moveToFirst()){
            do {
                Contact contact = null;
                String name= c.getString(c.getColumnIndex(Contact.COLUMN_NAME));
                String number = c.getString(c.getColumnIndex(Contact.COLUMN_NUMBER));
                int checked = c.getInt(c.getColumnIndex(Contact.COLUMN_CHECKED));
                long id = c.getLong(c.getColumnIndex(Contact.COLUMN_ID));

                contact.setName(name);
                contact.setNumber(number);
                contact.setChecked(checked);
                contact.setId(id);
            }while(c.moveToNext());
        }

        c.close();
        db.close();

        return contacts;
    }

    public Cursor getAllContactsCursor(){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(Contact.TABLE_NAME, null,null,null,null,null,null);
    }
}





