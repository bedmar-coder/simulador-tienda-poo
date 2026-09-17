/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compras_internet;

import java.util.Objects;

/**
 *
 * @author batoi
 */
public class StockProducte {

    private Producte producte;
    private int unitatsDisponibles;

    public StockProducte(Producte producte, int unitatsDisponibles) {
        assert producte != null : "el producte no ha de ser null al inicialitzar StockProducte";
        assert unitatsDisponibles > 0 : "Al inicialitzar StockProducte  les unitatsDisponibles han de ser mayor a 0";

        this.producte = producte;
        this.unitatsDisponibles = unitatsDisponibles;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.producte);
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
        final StockProducte other = (StockProducte) obj;
        return Objects.equals(this.producte, other.producte);
    }

    protected int getUnitatsDisponibles() {
        return unitatsDisponibles;
    }

    protected Producte getProducte() {
        return producte;
    }

}
