/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compras_internet;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author batoi
 */
public class AparadorTemporalFInsFiExistencies extends Aparador {

    private final int DIES_OBERT = 3;
    private long tempsInicial;

    public AparadorTemporalFInsFiExistencies(String nom, Marques marca, ArrayList<Producte> productes) throws CanNotMergeBrandsException {
        super(nom, marca, productes);
        tempsInicial = System.currentTimeMillis();
    }

    private long diesEnMiliSegons() {
        return DIES_OBERT * 86400 * 1000;
    }

    @Override
    protected boolean isObert() {
        if (!productesAmbStock().isEmpty()) {
            if ((System.currentTimeMillis() - tempsInicial) < diesEnMiliSegons()) {
                return true;
            }
        }
        return false;
    }

    private long MiliSegonsQueQueden() {
        long aux = System.currentTimeMillis() - tempsInicial;
        aux = diesEnMiliSegons() - aux;
        if (aux <= 0) {
            return 0;
        }
        return aux;
    }

    public String tempsqueQueda() {

        long segundosTotales = MiliSegonsQueQueden() / 1000;
        long dias = segundosTotales / 86400;
        long horas = (segundosTotales % 86400) / 3600;
        long minutos = (segundosTotales % 3600) / 60;
        long segundos = segundosTotales % 60;

        return dias + " días, " + horas + " horas, "
                + minutos + " minutos, " + segundos + " segundos";
    }

}
