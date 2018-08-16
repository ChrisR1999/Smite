package com.arturo.linearyscrollbar.Modelos;

public class ModeloDiosesMain {
    private int godId;
    private String godName;
    private String resourceImage;
    private String godCategory;
    private String godPanteon;
    private String godType;

    public ModeloDiosesMain() {

    }

    public ModeloDiosesMain(int godId, String godName, String godCategory, String godPanteon, String resourceImage, String godType) {
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

    public String getGodCategory() {
        return godCategory;
    }

    public void setGodCombo(String godCombo) {
        this.godCategory = godCategory;
    }

    public void setGodCategory(String godCategory) {
        this.godCategory = godCategory;
    }

    public String getGodPanteon() {
        return godPanteon;
    }

    public void setGodPanteon(String godPanteon) {
        this.godPanteon = godPanteon;
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getGodType() {
        return godType;
    }

    public void setGodType(String godType) {
        this.godType = godType;
    }
}
