/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.Datum;
import be.vdab.util.mens.Mens;
import be.vdab.util.mens.MensException;
import be.vdab.util.mens.Rijbewijs;
import be.vdab.voertuigen.div.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author bob.lamsens
 */
public abstract class Voertuig implements Comparable<Voertuig>, Serializable {
    private final Nummerplaat nummerplaat = Div.INSTANCE.generateNummerplaat();
    private String merk;
    private int aankoopprijs;
    private int aantalZitplaatsen;
    private Datum datumEersteInGebruikname;
    private LinkedList<Mens>inzittende = new LinkedList<>();

    public Voertuig(String merk, int aankoopprijs, 
                        int zitplaatsen, Mens...inzittende) 
                                   throws IllegalArgumentException {
        if (zitplaatsen < this.getMAX_AANTAL_ZITPLAATSEN()){    
            setAantalZitplaatsen(zitplaatsen);
            setMerk(merk);
            LinkedList<Mens> llInzittende = new LinkedList(Arrays.asList(inzittende));
            try{
                setInzittende(llInzittende);
            }
            catch(MensException me){
                System.out.println(me.getMessage());
            }
            setAankoopprijs(aankoopprijs);
        }
        else
            throw new IllegalArgumentException("teveel zitplaatsen gedefineerd");    
    }

    public final String getMerk() {
        return merk;
    }

    public final void setMerk(String merk) {
        if (!merk.isEmpty())
            this.merk = merk;
        else
            System.out.println("merk is niet ingevuld");
    }

    public final int getAankoopprijs() {
        return aankoopprijs;
    }

    public final void setAankoopprijs(int aankoopprijs) {
        if (aankoopprijs >= 0)
            this.aankoopprijs = aankoopprijs;
        else
            System.out.println("aankoopprijs negatief");
    }

    public final int getAantalZitplaatsen() {
        return aantalZitplaatsen;
    }

    public final void setAantalZitplaatsen(int aantalZitplaatsen) {
        this.aantalZitplaatsen = aantalZitplaatsen;
    }

    public final List<Mens> getInzittende() {
        return inzittende;
    }

    public final void setInzittende(LinkedList<Mens> inzittende) 
                                                    throws MensException {
        if (inzittende.size() <= aantalZitplaatsen){    
            if (inzittende.getFirst().hasRijbewijs())
                this.inzittende = inzittende;
            else
                throw new MensException("eerste inzittende van de " + merk +" is geen bestuurder");
        }
        else
            throw new MensException("teveel inzittende");
    }

    public final void addInzittende(Mens inzittende) throws MensException {
        if ( this.inzittende.size() < aantalZitplaatsen){    
            List<Rijbewijs> r = inzittende.getRijbewijzen();
                if (r.isEmpty())
                    this.inzittende.add(inzittende);
                else
                    this.inzittende.addFirst(inzittende);
        }
        else
            throw new MensException("teveel inzittende");
    }

    public final Datum getDatumEersteInGebruikname() {
        return datumEersteInGebruikname;
    }

    public final void setDatumEersteInGebruikname(Datum datumEersteInGebruikname) {
        this.datumEersteInGebruikname = datumEersteInGebruikname;
    }
    
    public final Nummerplaat getNummerplaat(){
        return nummerplaat;
    }

    abstract public int getMAX_AANTAL_ZITPLAATSEN();

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
            return nummerplaat.equals(v.getNummerplaat());
        }
        else
            return false;
    }
    @Override
    public int compareTo (Voertuig v){
        return nummerplaat.compareTo(v.getNummerplaat());
    }
    
    private class MerkComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2){
            if ((o1 instanceof Voertuig) && (o2 instanceof Voertuig ))
            {
                Voertuig v1 = (Voertuig) o1;
                Voertuig v2 = (Voertuig) o2;
                return v1.getMerk().compareTo(v2.getMerk());
            }
            else
            {
                System.out.println("Invalid argument in compare detected");
                return 0;
            }    
        }
    }
    private class AankoopprijsComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2){
            if ((o1 instanceof Voertuig) && (o2 instanceof Voertuig ))
            {
                Voertuig v1 = (Voertuig) o1;
                Voertuig v2 = (Voertuig) o2;
                return v1.getAankoopprijs()-v2.getAankoopprijs();
            }
            else
            {
                System.out.println("Invalid argument in compare detected");
                return 0;
            }    
        }
    }

    public Comparator getMerkComparator(){
        return new MerkComparator();
    }

    public Comparator getAankoopprijsComparator(){
        return new AankoopprijsComparator();
    }
}
