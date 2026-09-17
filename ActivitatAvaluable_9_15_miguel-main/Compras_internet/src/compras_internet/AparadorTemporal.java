/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compras_internet;

import java.util.ArrayList;

/**
 *
 * @author batoi
 */
public class AparadorTemporal extends Aparador {

    private int dies;
    private long tempsInicial;

    public AparadorTemporal(int dies, String nom, Marques marca, ArrayList<Producte> productes) throws CanNotMergeBrandsException {
        super(nom, marca, productes);
        
        assert dies > 0 : "Al generar un aparador temporals el dies han de ser minim 1";
        
        this.dies = dies;
        tempsInicial = System.currentTimeMillis();
    }

    @Override
    protected boolean isObert() {
        if ((System.currentTimeMillis() - tempsInicial) < (dies * 86400 * 1000)) {
            return true;
        }
        return false;
    }

}
