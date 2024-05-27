
package fi.tuni.prog3.json;

import java.util.ArrayList;

/**
 *
 * @author janik
 */
public class ValueNode extends Node {
    private Object val;

    public ValueNode() {
        this.val = null;
    }

    public ValueNode(double value) {
        this.val = value;
    }

    public ValueNode(boolean value) {
        this.val = value;
    }

    public ValueNode(String value) {
        if (value != null) {
            val = value;
        }
    }

    public boolean isNumber() {
        return val instanceof Number;
    }

    public boolean isBoolean()    {
        return val instanceof Boolean;
    }

    public boolean isString() {
        return val instanceof String;
    }

    public boolean isNull() {
        return val == null;
    }

    public double getNumber() {
        return ((Number) val).doubleValue();
    }

    public boolean getBoolean() {
        return (boolean) val;
    }

    public String getString() {
        return (String) val;
    }

    public Object getNull() {
        return val;
    }

    /*ValueNode luokka, joka sisältää numeroarvon, totuusarvon, merkkijonoarvon tai null-arvon. Luokan julkiset jäsenet ovat:

    Rakentaja ValueNode(), joka asettaa olion tiedoksi null-arvon.

    Rakentajat ValueNode(double value), ValueNode(boolean value) ja ValueNode(String value) asettavat olion tiedoksi jonkin edellä mainituista tyypeistä. Tehtävässä oletetaan, että ValueNode(String value)-rakentajalle ei anneta parametriksi null-arvoa.

    Boolean-tyyppiset jäsenfunktiot isNumber(), isBoolean(), isString() ja isNull(), joista kukin tutkii onko olion tieto tiettyä tyyppiä. Esimerkiksi isString palauttaa true-arvon, jos ja vain jos olioon talletettu tieto on merkkijono.

    Jäsenfunktiot double getNumber(), boolean getBoolean(), String getString() ja Object getNull(), joista kukin palauttaa olion sisältämän tiedon. Saantifunktion kutsujan vastuulla on varmistaa ennen kutsua oikea tietotyyppi tyypin tarkistavalla jäsenfunktiolla. Esimerkiksi getBoolean()-funktiota kutsuttaessa oletetaan, että aiemmin on todettu isBoolean()-funktiolla tiedon tyypiksi boolean.
     */

}
