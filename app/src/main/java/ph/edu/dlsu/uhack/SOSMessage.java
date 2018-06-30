package ph.edu.dlsu.uhack;

public class SOSMessage {
    public static final String TABLE_NAME = "sos";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_MSG = "message";

    private long id;
    private String message;

    public SOSMessage() {
    }
    public SOSMessage(String message) {

        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
