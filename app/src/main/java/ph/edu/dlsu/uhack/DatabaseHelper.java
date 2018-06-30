package ph.edu.dlsu.uhack;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by G301 on 11/7/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String SCHEMA = "uhack";
    public static final int VERSION = 2;

    public DatabaseHelper(Context context) {
        super(context, SCHEMA, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // ROLE: create the tables for the schema
        // It will only be called once by the system
        // -- when the schema with given name doesn't exist yet

        // creates the task
        String sql = "CREATE TABLE " + SOSMessage.TABLE_NAME + " ("
                + SOSMessage.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + SOSMessage.COLUMN_MSG + " TEXT"
                + ");";
        sqLiteDatabase.execSQL(sql);

        //creates Category
        sql = "CREATE TABLE " + GoBagItems.TABLE_NAME + " ("
                + GoBagItems.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GoBagItems.COLUMN_WATER + " TEXT,"
                + GoBagItems.COLUMN_FOOD + " TEXT,"
                + GoBagItems.COLUMN_RADIO + " TEXT,"
                + GoBagItems.COLUMN_FLASH + " TEXT,"
                + GoBagItems.COLUMN_KIT + " TEXT,"
                + GoBagItems.COLUMN_BATT + " TEXT,"
                + GoBagItems.COLUMN_WHISTLE + " TEXT,"
                + GoBagItems.COLUMN_MASK + " TEXT,"
                + GoBagItems.COLUMN_PLASTIC + " TEXT,"
                + GoBagItems.COLUMN_TOOLS + " TEXT,"
                + GoBagItems.COLUMN_CAN+ " TEXT,"
                + GoBagItems.COLUMN_MAPS + " TEXT,"
                + GoBagItems.COLUMN_PHONES + " TEXT,"
                + GoBagItems.COLUMN_MEDIC  + " TEXT,"
                + GoBagItems.COLUMN_CASH + " TEXT,"
                + GoBagItems.COLUMN_DOCU + " TEXT,"
                + GoBagItems.COLUMN_BLANKET + " TEXT"
                + ");";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,
                          int i, int i1) {
        // ROLE: update the current schema
        // Will be called when version number is newer/higher

        // migration
        // drop current tables
        String sql = "DROP TABLE IF EXISTS " + SOSMessage.TABLE_NAME + ";";
        sqLiteDatabase.execSQL(sql);

        sql = "DROP TABLE IF EXISTS " + GoBagItems.TABLE_NAME + ";";
        sqLiteDatabase.execSQL(sql);

        // call onCreate
        onCreate(sqLiteDatabase);
    }

    public String working () {
        return "connected";
    }
    public long addMsg(SOSMessage msg){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SOSMessage.COLUMN_MSG, msg.getMessage());

        long id = db.insert(SOSMessage.TABLE_NAME,
                null,
                contentValues);
        db.close();
        return id;
    }

    public long addGoBag(GoBagItems bag){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(GoBagItems.COLUMN_BATT, bag.isBatteries());
        contentValues.put(GoBagItems.COLUMN_BLANKET, bag.isBlanket());
        contentValues.put(GoBagItems.COLUMN_CAN, bag.isCanopener());
        contentValues.put(GoBagItems.COLUMN_CASH, bag.isCash());
        contentValues.put(GoBagItems.COLUMN_DOCU, bag.isDocuments());
        contentValues.put(GoBagItems.COLUMN_FLASH, bag.isFlashlight());
        contentValues.put(GoBagItems.COLUMN_FOOD, bag.isFood());
        contentValues.put(GoBagItems.COLUMN_KIT, bag.isKit());
        contentValues.put(GoBagItems.COLUMN_MAPS, bag.isMaps());
        contentValues.put(GoBagItems.COLUMN_MASK, bag.isMask());
        contentValues.put(GoBagItems.COLUMN_MEDIC, bag.isMedications());
        contentValues.put(GoBagItems.COLUMN_PHONES, bag.isPhones());
        contentValues.put(GoBagItems.COLUMN_PLASTIC, bag.isPlastic());
        contentValues.put(GoBagItems.COLUMN_RADIO, bag.isRadio());
        contentValues.put(GoBagItems.COLUMN_TOOLS, bag.isTools());
        contentValues.put(GoBagItems.COLUMN_WATER, bag.isWater());
        contentValues.put(GoBagItems.COLUMN_WHISTLE, bag.isWhistle());

        long id = db.insert(GoBagItems.TABLE_NAME,
                null,
                contentValues);

        db.close();
        return id;
    }
    public boolean editMsg(SOSMessage msg, long currentId){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(SOSMessage.COLUMN_MSG, msg.getMessage());

        int rowsAffected = db.update(SOSMessage.TABLE_NAME,
                contentValues,
                SOSMessage.COLUMN_ID + "=?",
                new String[]{msg.getId()+""});
        db.close();

        return rowsAffected >0;
    }

    public boolean editGoBagItems(GoBagItems bag,long currentId){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(GoBagItems.COLUMN_BATT, bag.isBatteries());
        contentValues.put(GoBagItems.COLUMN_BLANKET, bag.isBlanket());
        contentValues.put(GoBagItems.COLUMN_CAN, bag.isCanopener());
        contentValues.put(GoBagItems.COLUMN_CASH, bag.isCash());
        contentValues.put(GoBagItems.COLUMN_DOCU, bag.isDocuments());
        contentValues.put(GoBagItems.COLUMN_FLASH, bag.isFlashlight());
        contentValues.put(GoBagItems.COLUMN_FOOD, bag.isFood());
        contentValues.put(GoBagItems.COLUMN_KIT, bag.isKit());
        contentValues.put(GoBagItems.COLUMN_MAPS, bag.isMaps());
        contentValues.put(GoBagItems.COLUMN_MASK, bag.isMask());
        contentValues.put(GoBagItems.COLUMN_MEDIC, bag.isMedications());
        contentValues.put(GoBagItems.COLUMN_PHONES, bag.isPhones());
        contentValues.put(GoBagItems.COLUMN_PLASTIC, bag.isPlastic());
        contentValues.put(GoBagItems.COLUMN_RADIO, bag.isRadio());
        contentValues.put(GoBagItems.COLUMN_TOOLS, bag.isTools() );
        contentValues.put(GoBagItems.COLUMN_WATER, bag.isWater());
        contentValues.put(GoBagItems.COLUMN_WHISTLE, bag.isWhistle() );

        int rowsAffected = db.update(GoBagItems.TABLE_NAME,
                contentValues,
                GoBagItems.COLUMN_ID + "=?",
                new String[]{bag.getId()+""});
        db.close();

        return rowsAffected >0;
    }

    // getMessage
    public SOSMessage getMsg (long id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(SOSMessage.TABLE_NAME,
                null,
                SOSMessage.COLUMN_ID + "=?",
                new String[]{ id+"" },
                null,
                null,
                null);
        SOSMessage k = null;
        if(c.moveToFirst()){
            k = new SOSMessage();
            k.setMessage(c.getString(c.getColumnIndex(SOSMessage.COLUMN_MSG)));
            k.setId(id);
        }

        c.close();
        db.close();

        return k;
    }

    // getMessage
    public GoBagItems getBag(long id ){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(GoBagItems.TABLE_NAME,
                null,
                GoBagItems.COLUMN_ID + "=?",
                new String[]{ id+"" },
                null,
                null,
                null);

        GoBagItems k = null;
        if(c.moveToFirst()){
            k = new GoBagItems();
            k.setBatteries(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_BATT))));
            k.setBlanket(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_BLANKET))));
            k.setCanopener(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_CAN))));
            k.setCash(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_CASH))));
            k.setDocuments(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_DOCU))));
            k.setFlashlight(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_FLASH))));
            k.setFood(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_FOOD))));
            k.setKit(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_KIT))));
            k.setMaps(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MAPS))));
            k.setMask(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MASK))));
            k.setMaps(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MAPS))));
            k.setMedications(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MEDIC))));
            k.setPhones(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_PHONES))));
            k.setPlastic(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_PLASTIC))));
            k.setTools(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_TOOLS))));
            k.setWater(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_WATER))));
            k.setWhistle(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_WHISTLE))));
            k.setId(id);
        }

        c.close();
        db.close();

        return k;
    }

    public ArrayList<GoBagItems> getGoBag(){
        ArrayList<GoBagItems> bagList = new ArrayList<GoBagItems>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(GoBagItems.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        GoBagItems k = null;
        if(c.moveToFirst()){
            k = new GoBagItems();
            k.setBatteries(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_BATT))));
            k.setBlanket(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_BLANKET))));
            k.setCanopener(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_CAN))));
            k.setCash(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_CASH))));
            k.setDocuments(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_DOCU))));
            k.setFlashlight(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_FLASH))));
            k.setFood(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_FOOD))));
            k.setKit(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_KIT))));
            k.setMaps(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MAPS))));
            k.setMask(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MASK))));
            k.setMaps(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MAPS))));
            k.setMedications(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_MEDIC))));
            k.setPhones(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_PHONES))));
            k.setPlastic(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_PLASTIC))));
            k.setTools(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_TOOLS))));
            k.setWater(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_WATER))));
            k.setWhistle(Boolean.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_WHISTLE))));
            k.setId(Integer.valueOf(c.getString(c.getColumnIndex(GoBagItems.COLUMN_ID))));
            bagList.add(k);
        }

        return bagList;
    }
    public Cursor getAllGoBag(){
        return getReadableDatabase().query(GoBagItems.TABLE_NAME, null,null,null,null,null,null);
    }

}