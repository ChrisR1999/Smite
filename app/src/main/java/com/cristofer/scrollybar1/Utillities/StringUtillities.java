package com.cristofer.scrollybar1.Utillities;

public class StringUtillities {

    public String parseGodName(String godName) {
        String parsedGodName = "";
        return parsedGodName;
    }

    public static String parseItemName(String itemName){
        String item = "";
        item = itemName.toLowerCase();
        item = item.replace(" ","_");
        item = item.replace("'", "");
        return item;
    }
}

