/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compras_internet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author batoi
 */
public abstract class Aparador {

    private String nom;
    private Marques marca;
    private HashSet<StockProducte> estocProductes;
    private final int MAXIM_PRODUCTES = 20;
    private final int MINIM_STOCK = 1;
    private final int MAXIM_STOCK = 10;
    private Random aleatori = new Random();

    public Aparador(String nom, Marques marca, ArrayList<Producte> productes) throws CanNotMergeBrandsException {
        assert productes.size() > 0 : "Al generar un aparador l'array ha de tindre minim un Producte";
        this.nom = nom;
        this.marca = marca;
        this.estocProductes = new HashSet<>();
        for (int i = 0; i < MAXIM_PRODUCTES && i < productes.size(); i++) {
            if (productes.get(i).marca != this.marca) {
                throw new CanNotMergeBrandsException();
            }
            estocProductes.add(new StockProducte(productes.get(i), aleatori.nextInt(MINIM_STOCK, MAXIM_STOCK + 1)));

        }
    }

    public HashSet<Producte> productesAmbStock() {
        HashSet<Producte> productes = new HashSet<>();
        for (StockProducte estocProducte : this.estocProductes) {
            if (estocProducte.getUnitatsDisponibles() > 0) {
                productes.add(estocProducte.getProducte());
            }

        }

        return productes;
    }

    public boolean hiHaSuficients(int num, String id) {
        assert num > 0 : "Has de consultar per un numero mayor que 0";
        Producte aux = new Producte(id, Marques.FLORDELTARONJER, 1);
        if (productesAmbStock().contains(aux)) {
            for (StockProducte estoc : estocProductes) {
                if (estoc.getProducte().equals(aux)) {
                    if (estoc.getUnitatsDisponibles() >= num) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isEnStock(Producte producte) {
        assert producte != null : "No pots consultar el stock de un Producte null";
        if (productesAmbStock().contains(producte)) {
            return true;
        }
        return false;
    }

    public int unitatsDisponibles(Producte producte) {
        assert producte != null : "No pots consultar les unitats de un producte null";

        for (StockProducte estoc : estocProductes) {
            if (estoc.getProducte().equals(producte)) {
                return estoc.getUnitatsDisponibles();
            }
        }
        return 0;
    }

    protected abstract boolean isObert();

    public void comprar(Producte producte, int unitats) throws NotExistEnoughItemException, ShowRoomNotOpenException {
        assert producte != null : "Al comprar el producte no pot ser null";
        assert unitats > 0 : "Al comprar les unitats han de ser mayor que 0";

        if (isObert()) {
            if (hiHaSuficients(unitats, producte.getIdentificador())) {
                StockProducte aux = new StockProducte(producte, (unitatsDisponibles(producte)) - unitats);
                estocProductes.remove(new StockProducte(producte, unitats));
                estocProductes.add(aux);
                return;
            }
        } else {
            throw new ShowRoomNotOpenException();
        }
        throw new NotExistEnoughItemException();
    }

    public ArrayList<Producte> productesOrdenats() {
        ArrayList<Producte> ordenats = new ArrayList<>();
        Producte aux = null;
        boolean semaforo = true;
        for (StockProducte estocs : this.estocProductes) {
            if (semaforo) {
                aux = estocs.getProducte();
                semaforo = false;
            }
            if (estocs.getProducte().isMenor(aux)) {
                aux = estocs.getProducte();
            }
        }
        ordenats.add(aux);
        while (ordenats.size() < estocProductes.size()) {
            Producte apoyo = null;
            for (StockProducte estocs : this.estocProductes) {
                int iteracion = 0;
                if (!ordenats.contains(estocs.getProducte())) {
                    if (apoyo == null || estocs.getProducte().isMenor(apoyo)) {
                        apoyo = estocs.getProducte();

                    }
                }
            }
            ordenats.add(apoyo);
        }
        return ordenats;
    }

}
