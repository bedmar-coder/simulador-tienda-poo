/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package compras_internet;

/**
 *
 * @author batoi
 */
public enum Marques {
    PEPEWEAR,
    LACOSTERA,
    FLORDELTARONJER;

    @Override
    public String toString() {
        return switch (this) {
            case PEPEWEAR -> "PepeWear";
            case LACOSTERA -> "LaCostera";
            case FLORDELTARONJER -> "Flor del taronjer";
        };
    }
}
