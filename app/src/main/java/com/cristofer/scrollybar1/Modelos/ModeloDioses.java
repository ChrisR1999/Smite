package com.cristofer.scrollybar1.Modelos;

import java.util.ArrayList;

public class ModeloDioses {
    private int godId;
    private String godName;
    private String godCombo;
    private ArrayList<String> countersBy;
    private ArrayList<String> counter;
    private String resourceImage;

    public ModeloDioses(){

    }

    public ModeloDioses(int godId, String godName, String godCombo, ArrayList<String> countersBy, ArrayList<String> counter, String resourceImage) {
        this.godId = godId;
        this.godName = godName;
        this.godCombo = godCombo;
        this.counter = counter;
        this.countersBy = countersBy;
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

    public ArrayList<String> getCountersBy() {
        return countersBy;
    }

    public void setCountersBy(ArrayList<String> countersBy) {
        this.countersBy = countersBy;
    }

    public ArrayList<String> getCounter() {
        return counter;
    }

    public void setCounter(ArrayList<String> counter) {
        this.counter = counter;
    }

    public String getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(String resourceImage) {
        this.resourceImage = resourceImage;
    }

}
