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
public class AparadorFInsFiExistencies extends Aparador {

    private boolean mantindreObert;

    public AparadorFInsFiExistencies(String nom, Marques marca, ArrayList<Producte> productes) throws CanNotMergeBrandsException {
        super(nom, marca, productes);
        mantindreObert = true;
    }

    public void tancarAparador() {
        mantindreObert = false;
    }

    @Override
    protected boolean isObert() {
        if (mantindreObert) {
            if (productesAmbStock().size() > 0) {
                return true;
            }

        }
        return false;
    }

}
