package com.pavan.track.models.enums;

public enum Store {

    BIG_BASKET("BigBasket"),
    DUNZO("Dunzo"),
    FTH("FTH"),
    STORE_SE("StoreSe"),
    APARTMENT("Apartment Security"),
    PROVISIONAL_STORE("Provisional Store");

    private final String storeName;

    Store(String storeName){
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }
}
