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
public class TestShopOnline {

    public static void main(String[] args) {
        //Comienza el a
        System.out.println("APARTAT A\n");
        Producte potRatlles = new Producte("pot a ratlles", Marques.LACOSTERA, 50);
        Producte vestitBanyBlau = new Producte("vestit de bany blau", Marques.LACOSTERA, 40);

        //Comienza el b
        System.out.println("\nAPARTAT B\n");
        ArrayList<Producte> productesInicials = new ArrayList<>();
        productesInicials.add(potRatlles);
        productesInicials.add(vestitBanyBlau);
        AparadorTemporalFInsFiExistencies estiuLaCostera2025
                = new AparadorTemporalFInsFiExistencies("estiuLaCostera2025", Marques.LACOSTERA, productesInicials);

        //Comienza el c
        System.out.println("\nAPARTAT C\n");
        System.out.print("Productes disponibles:");
        for (Producte producte : estiuLaCostera2025.productesOrdenats()) {
            System.out.print("[");
            System.out.print(producte);
            System.out.print("]");
        }
        System.out.println("");

        //comienza el d
        System.out.println("\nAPARTAT D\n");
        System.out.println("Unitats disponibles de " + potRatlles + ": " + estiuLaCostera2025.unitatsDisponibles(potRatlles));
        System.out.println("Unitats disponibles de " + vestitBanyBlau + ": " + estiuLaCostera2025.unitatsDisponibles(vestitBanyBlau));

        //comienza el e
        System.out.println("\nAPARTAT E\n");
        System.out.println("Temps disponible obert de l'aparador: " + estiuLaCostera2025.tempsqueQueda());

        //comienza el f
        System.out.println("\nAPARTAT F\n");
        try {
            estiuLaCostera2025.comprar(potRatlles, estiuLaCostera2025.unitatsDisponibles(potRatlles));

            estiuLaCostera2025.comprar(vestitBanyBlau, estiuLaCostera2025.unitatsDisponibles(vestitBanyBlau));
        } catch (ShowRoomNotOpenException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Unitats disponibles de " + potRatlles + "tras compra: " + estiuLaCostera2025.unitatsDisponibles(potRatlles));
        System.out.println("Unitats disponibles de " + vestitBanyBlau + ":tras compra " + estiuLaCostera2025.unitatsDisponibles(vestitBanyBlau));

        //comienza el g
        System.out.println("\nAPARTAT G\n");
        System.out.println("L'aaprador s'encontra: " + (estiuLaCostera2025.isObert() ? "obert" : "tancat"));

        //PRUEBAS EXTRA
        System.out.println("\nROVES EXTRA\n");
        /* Abajo he comprobado no puedo iniciar aparador porque es clase abstracta
        Aparador aparador = new Aparador("ejemplo", Marques.PEPEWEAR, productesInicials);*/
        //Abajo compruebo no aceptan productos de marca diferente al aparador y de paso creo uno de fi de existencies despues
        try {
            AparadorFInsFiExistencies fiExistenciesError = new AparadorFInsFiExistencies("fiExistencies", Marques.PEPEWEAR, productesInicials);
        } catch (CanNotMergeBrandsException e) {
            System.out.println(e.getMessage());
        }
        Producte joguet = new Producte("joguet", Marques.PEPEWEAR, 50);
        Producte pilota = new Producte("pilota", Marques.PEPEWEAR, 40);
        ArrayList<Producte> productesPepe = new ArrayList<>();
        productesPepe.add(joguet);
        productesPepe.add(pilota);
        AparadorFInsFiExistencies fiExistencies = new AparadorFInsFiExistencies("fiExistencies", Marques.PEPEWEAR, productesPepe);

        System.out.println("Comprobem cuants n'hi ha de productes avancs de comprar: ");
        System.out.println("Unitats disponibles de " + joguet + ": " + fiExistencies.unitatsDisponibles(joguet));
        System.out.println("Unitats disponibles de " + pilota + ": " + fiExistencies.unitatsDisponibles(pilota));

        //Compruebo abajo si es posible comprar un numero  de la cantidad ens tock y uno mayor
        System.out.printf("Puc comprar %d del producte %s?: %b",
                fiExistencies.unitatsDisponibles(joguet), joguet, fiExistencies.hiHaSuficients(fiExistencies.unitatsDisponibles(joguet), "joguet"));
        System.out.println("");

        System.out.printf("Puc comprar %d del producte %s?: %b",
                fiExistencies.unitatsDisponibles(pilota) + 3, joguet, fiExistencies.hiHaSuficients(fiExistencies.unitatsDisponibles(pilota) + 3, "pilota"));
        System.out.println("");

        /*Intento comprar más unidades de las que hay en stock y veo que genera
        la excepción de no obligada captura NotExistEnouhItemException
        
       try{
           fiExistencies.comprar(joguet, fiExistencies.unitatsDisponibles(joguet)+5);
       } catch(ShowRoomNotOpenException e){
           System.out.println(e.getMessage());
       }*/
        //Mostre productes amb un metode diferent al de ordenats
        System.out.print("Productes:");
        for (Producte producte : fiExistencies.productesAmbStock()) {
            System.out.print("[");
            System.out.print(producte);
            System.out.print("]");
        }
        System.out.println("");

        //Agote tot el stock d'un producte
        try {
            fiExistencies.comprar(joguet, fiExistencies.unitatsDisponibles(joguet));
        } catch (ShowRoomNotOpenException e) {
            System.out.println("Obligat tratctamente altra vegada");
        }

        System.out.println("Unitats disponibles de " + joguet + ": " + fiExistencies.unitatsDisponibles(joguet));

        //Ara demane la llista de productes amb stock i no ha de donarme joguet
        System.out.print("Productes amb stock:");
        for (Producte producte : fiExistencies.productesAmbStock()) {
            System.out.print("[");
            System.out.print(producte);
            System.out.print("]");
        }
        System.out.println("");

        //Li vaig a preguntar si te stock del dos preguntes directament
        System.out.printf("Hi ha stock de %s? %b\n", pilota, fiExistencies.isEnStock(pilota));
        System.out.printf("Hi ha stock de %s? %b\n", joguet, fiExistencies.isEnStock(joguet));

        //pruebo la función que dispone el tipo de aparador finsFiExistencies per tancarlo
        System.out.println("L'aprador s'encontra: " + (fiExistencies.isObert() ? "obert" : "tancat"));
        fiExistencies.tancarAparador();
        System.out.println("L'aprador s'encontra: " + (fiExistencies.isObert() ? "obert" : "tancat"));

        //Finalmente compruebo funciona la ultima subclase de aparador inicializando una variable suya
        AparadorTemporal estiuLaCosteraTemporal
                = new AparadorTemporal(10, "estiuLaCostera2025", Marques.LACOSTERA, productesInicials);

    }

}
