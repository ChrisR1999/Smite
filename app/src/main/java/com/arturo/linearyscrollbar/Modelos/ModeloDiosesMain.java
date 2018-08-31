package com.arturo.linearyscrollbar.Modelos;

public class ModeloDiosesMain {
    private int godId;
    private String godName;
    private String resourceImage;
    private int godCategory;
    private int godPanteon;
    private int godType;

    public ModeloDiosesMain() {

    }

    public ModeloDiosesMain(int godId, String godName, int godCategory, int godPanteon, String resourceImage, int godType) {
        this.godId = godId;
        this.godName = godName;
        this.godCategory = godCategory;
        this.godPanteon = godPanteon;
        this.resourceImage = resourceImage;
        this.godType = godType;
    }

    public int getGodId() {
        return godId;
    }

    public void setGodId(int godId) {
        this.godId = godId;
    }

    public String getGodName() {
        return godName;
    }

    public void setGodName(String godName) {
        this.godName = godName;
    }

    public int getGodCategory() {
        return godCategory;
    }

    public void setGodCombo(String godCombo) {
        this.godCategory = godCategory;
    }

    public void setGodCategory(int godCategory) {
        this.godCategory = godCategory;
    }

    public int getGodPanteon() {
        return godPanteon;
    }

    public void setGodPanteon(int godPanteon) {
        this.godPanteon = godPanteon;
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getGodType() {
        return godType;
    }

    public void setGodType(int godType) {
        this.godType = godType;
    }
}
