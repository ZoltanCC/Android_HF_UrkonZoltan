package com.example.hf4;

public class Country {
    String nev, rovidNev;
    Double elad,vesz;
    int imageID;

    public Country(String nev, String rovidNev, Double elad, Double vesz, int imageID) {
        this.nev = nev;
        this.rovidNev = rovidNev;
        this.elad = elad;
        this.vesz = vesz;
        this.imageID = imageID;
    }
}
