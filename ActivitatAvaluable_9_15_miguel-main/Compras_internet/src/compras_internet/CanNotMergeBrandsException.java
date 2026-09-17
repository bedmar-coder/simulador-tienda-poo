/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compras_internet;

/**
 *
 * @author batoi
 */
public class CanNotMergeBrandsException extends RuntimeException {

    public CanNotMergeBrandsException() {
        super("Tots els productes de l'estoc han de ser de la mateixa marca que la de l'aparador");
    }

}
