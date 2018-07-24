package com.arturo.linearyscrollbar.Modelos;

public class ModeloDioses {
    private int godId;
    private String godName;
    private String godCombo;
    private static String counter;
    private String counterBy;
    private String resourceImage;
   private  String counter2;

    public ModeloDioses(){

    }



    public ModeloDioses(int godId, String godName, String godCombo, String counter, String counterBy, String resourceImage, String counter2) {
        this.godId = godId;
        this.godName = godName;
        this.godCombo = godCombo;
        this.counter = counter;
        this.counterBy = counterBy;
        this.resourceImage = resourceImage;
        this.counter2 = counter2;
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

    public String getCounter() {
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
    public String getCounter2() {
        return counter2;
    }

    public void setCounter2(String counter2) {
        this.counter2 = counter2;
    }
}
