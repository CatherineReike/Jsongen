package com.edti.Models;

import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("net.hexar.json2pojo")
public class OEKurzusokFelhasznalokkalKurzusHallgatokAdat {
    @SerializedName("NeptunKod")
    private String neptunKod;

    public OEKurzusokFelhasznalokkalKurzusHallgatokAdat(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    public String getNeptunKod() {
        return neptunKod;
    }

    public void setNeptunKod(String neptunKod) {
        this.neptunKod = neptunKod;
    }

    @Override
    public String toString() {
        return "OEKurzusokFelhasznalokkalKurzusHallgatokAdat{" +
                "neptunKod='" + neptunKod + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof OEKurzusokFelhasznalokkalKurzusHallgatokAdat)) {
            return false;
        }

        OEKurzusokFelhasznalokkalKurzusHallgatokAdat other = (OEKurzusokFelhasznalokkalKurzusHallgatokAdat) obj;
        if (other == this) {
            return true;
        }

        if (this.neptunKod.equals(other.getNeptunKod())) {
            return true;
        }

        return false;
    }
}
