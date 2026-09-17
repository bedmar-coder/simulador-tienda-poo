/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compras_internet;

/**
 *
 * @author batoi
 */
public class NotExistEnoughItemException extends RuntimeException{

    public NotExistEnoughItemException() {
        super("Unitats no disponibles");
    }
    
}
