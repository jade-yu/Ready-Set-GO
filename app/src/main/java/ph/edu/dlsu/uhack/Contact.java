package ph.edu.dlsu.uhack;

/**
 * Created by G301 on 11/7/2017.
 */

public class Contact {

    public static final String EXTRA_ID = "id";
    public static final String EXTRA_TOADD = "add";

    public static final String TABLE_NAME = "Contact";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_CHECKED = "checked";

    private long id;
    private String name;
    private String number;
    private int checked;

    public Contact(){}

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
        this.checked = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}










