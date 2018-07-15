package com.arturo.linearyscrollbar.Modelos;

public class ModeloDioses {
    private int godId;
    private String godName;
    private String godCombo;
    private static String counter;
    private String counterBy;
    private String resourceImage;

    public ModeloDioses(){

    }

    public ModeloDioses(int godId, String godName, String godCombo, String counter, String counterBy, String resourceImage) {
        this.godId = godId;
        this.godName = godName;
        this.godCombo = godCombo;
        this.counter = counter;
        this.counterBy = counterBy;
        this.resourceImage = resourceImage;
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

    public String getGodCombo() {
        return godCombo;
    }

    public void setGodCombo(String godCombo) {
        this.godCombo = godCombo;
    }

    public static String getCounter() {
        return counter;
    }

    public void setCounter(String counter) {
        this.counter = counter;
    }

    public String getCounterBy() {
        return counterBy;
    }

    public void setCounterBy(String counterBy) {
        this.counterBy = counterBy;
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }
}
