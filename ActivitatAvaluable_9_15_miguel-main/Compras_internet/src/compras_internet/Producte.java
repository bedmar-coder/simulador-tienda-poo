/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package compras_internet;

import java.util.Objects;

/**
 *
 * @author batoi
 */
public class Producte implements Comparable {

    private final String identificador;
    private float preu;
    protected final Marques marca;

    public Producte(String identificador, Marques marca, float preu) {
        assert preu > 0 : "el preu ha de ser positiu";

        this.identificador = identificador;
        this.marca = marca;
        this.preu = preu;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.identificador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producte other = (Producte) obj;
        return Objects.equals(this.identificador, other.identificador);
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public boolean isMenor(Producte producte) {
        assert producte != null : "el producte no ha de ser null";

        return identificador.compareToIgnoreCase(producte.getIdentificador()) < 0;
    }

    @Override
    public String toString() {
        return identificador;
    }

}
