package ru.sbgeu.lichman.basic;

public enum Location {
    FOREST("Густой лес"),
    PLAIN("Равнина"),
    SWAMP("Болото");
    private String nameRus;

    public String getNameRus(){
        return nameRus;
    }

    Location (String nameRus) {
        this.nameRus = nameRus;
    }
}
