package ph.edu.dlsu.uhack;

public class GoBagItems {
    public static final String TABLE_NAME = "bag";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WATER = "water";
    public static final String COLUMN_FOOD = "food";
    public static final String COLUMN_RADIO = "radio";
    public static final String COLUMN_FLASH = "flash";
    public static final String COLUMN_KIT = "kit";
    public static final String COLUMN_BATT = "batt";
    public static final String COLUMN_WHISTLE = "whistle";
    public static final String COLUMN_MASK = "mask";
    public static final String COLUMN_PLASTIC = "plastic";
    public static final String COLUMN_TOOLS = "tools";
    public static final String COLUMN_CAN = "can";
    public static final String COLUMN_MAPS = "maps";
    public static final String COLUMN_PHONES = "phones";
    public static final String COLUMN_MEDIC = "medic";
    public static final String COLUMN_CASH = "cash";
    public static final String COLUMN_DOCU = "docu";
    public static final String COLUMN_BLANKET = "blanket";


    private long id;
    private boolean Water;
    private boolean Food;
    private boolean Radio;
    private boolean Flashlight;
    private boolean Kit;
    private boolean Batteries;
    private boolean Whistle;
    private boolean Mask;
    private boolean Plastic;
    private boolean Tools;
    private boolean Canopener;
    private boolean Maps;
    private  boolean Phones;
    private boolean Medications;
    private boolean Cash;
    private boolean Documents;
    private boolean Blanket;

    public GoBagItems(){}

    public GoBagItems(boolean water, boolean food, boolean radio, boolean flashlight, boolean kit,
                      boolean batteries, boolean whistle, boolean mask, boolean plastic, boolean tools,
                      boolean canopener, boolean maps, boolean phones, boolean medications, boolean cash,
                      boolean documents, boolean blanket) {
        Water = water;
        Food = food;
        Radio = radio;
        Flashlight = flashlight;
        Kit = kit;
        Batteries = batteries;
        Whistle = whistle;
        Mask = mask;
        Plastic = plastic;
        Tools = tools;
        Canopener = canopener;
        Maps = maps;
        Phones = phones;
        Medications = medications;
        Cash = cash;
        Documents = documents;
        Blanket = blanket;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isWater() {
        return Water;
    }

    public void setWater(boolean water) {
        Water = water;
    }

    public boolean isFood() {
        return Food;
    }

    public void setFood(boolean food) {
        Food = food;
    }

    public boolean isRadio() {
        return Radio;
    }

    public void setRadio(boolean radio) {
        Radio = radio;
    }

    public boolean isFlashlight() {
        return Flashlight;
    }

    public void setFlashlight(boolean flashlight) {
        Flashlight = flashlight;
    }

    public boolean isKit() {
        return Kit;
    }

    public void setKit(boolean kit) {
        Kit = kit;
    }

    public boolean isBatteries() {
        return Batteries;
    }

    public void setBatteries(boolean batteries) {
        Batteries = batteries;
    }

    public boolean isWhistle() {
        return Whistle;
    }

    public void setWhistle(boolean whistle) {
        Whistle = whistle;
    }

    public boolean isMask() {
        return Mask;
    }

    public void setMask(boolean mask) {
        Mask = mask;
    }

    public boolean isPlastic() {
        return Plastic;
    }

    public void setPlastic(boolean plastic) {
        Plastic = plastic;
    }

    public boolean isTools() {
        return Tools;
    }

    public void setTools(boolean tools) {
        Tools = tools;
    }

    public boolean isCanopener() {
        return Canopener;
    }

    public void setCanopener(boolean canopener) {
        Canopener = canopener;
    }

    public boolean isMaps() {
        return Maps;
    }

    public void setMaps(boolean maps) {
        Maps = maps;
    }

    public boolean isPhones() {
        return Phones;
    }

    public void setPhones(boolean phones) {
        Phones = phones;
    }

    public boolean isMedications() {
        return Medications;
    }

    public void setMedications(boolean medications) {
        Medications = medications;
    }

    public boolean isCash() {
        return Cash;
    }

    public void setCash(boolean cash) {
        Cash = cash;
    }

    public boolean isDocuments() {
        return Documents;
    }

    public void setDocuments(boolean documents) {
        Documents = documents;
    }

    public boolean isBlanket() {
        return Blanket;
    }

    public void setBlanket(boolean blanket) {
        Blanket = blanket;
    }

}
