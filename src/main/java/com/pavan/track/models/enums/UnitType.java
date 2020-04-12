package com.pavan.track.models.enums;

public enum UnitType {

    KILOGRAMS("Kilogram"),
    LITRES("Litre"),
    PIECE("Piece");

    private final String type;

    UnitType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public enum Unit{
        KG("kg", UnitType.KILOGRAMS),
        GMS("g", UnitType.KILOGRAMS),
        LTR("L", UnitType.LITRES),
        ML("ml", UnitType.LITRES),
        PC("pc", UnitType.PIECE);

        private final String unitValue;
        private final UnitType unitType;

        Unit(String unitValue, UnitType unitType){
            this.unitValue = unitValue;
            this.unitType = unitType;
        }

        public String getUnitValue(){
            return unitValue;
        }

        public String getUnitType(){
            return unitType.getType();
        }
    }
}
