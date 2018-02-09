/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.voertuigen.div.*;
import java.io.Serializable;

/**
 *
 * @author bob.lamsens
 */
public class Voertuig implements Comparable<Voertuig>, Serializable {
    private final Nummerplaat nummerplaat = Div.INSTANCE.generateNummerplaat();
    private String merk;
    private int aankoopprijs;

    public Voertuig(String merk, int aankoopprijs) {
        setMerk(merk);
        setAankoopprijs(aankoopprijs);
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        if (!merk.isEmpty())
            this.merk = merk;
        else
            System.out.println("merk is niet ingevuld");
    }

    public int getAankoopprijs() {
        return aankoopprijs;
    }

    public void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs >= 0)
            this.aankoopprijs = aankoopprijs;
        else
            System.out.println("aankoopprijs negatief");
    }
    
    @Override
    public String toString(){
        return nummerplaat.toString();
    }
    @Override
    public int hashCode(){
        int hash = 7;
        return (hash*43)+nummerplaat.toString().hashCode();
    }
    @Override 
    public boolean equals (Object o){
        if (o instanceof Voertuig){
            Voertuig v = (Voertuig) o;
            return v.nummerplaat.equals(nummerplaat);
        }
        else
            return false;
    }
    @Override
    public int compareTo (Voertuig v){
        return v.nummerplaat.compareTo(nummerplaat);
    }
}
