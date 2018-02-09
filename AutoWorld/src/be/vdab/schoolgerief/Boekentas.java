/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.schoolgerief;
import be.vdab.util.Laadbaar;
import be.vdab.util.Volume;
import java.io.Serializable;
/**
 *
 * @author bob.lamsens
 */
public class Boekentas implements Comparable<Boekentas>, Laadbaar, Serializable {
    
    private static final long serialVersionUID = 1L;
    private String kleur;
    private Volume laadvolume;

    public Boekentas(String kleur, Volume laadvolume) throws IllegalArgumentException{
        if (!(kleur.isEmpty() || laadvolume == null)){
            this.kleur = kleur;
            this.laadvolume = laadvolume;
        } 
        else{
            throw new IllegalArgumentException();
        }
        
            
    }

    public String getKleur() {
        return kleur;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    @Override
    public Volume getLaadVolume() {
        return laadvolume;
    }

    @Override
    public void setLaadVolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }
    
    @Override 
    public String toString(){
        return "boekentas:" + kleur + " - " + laadvolume.toString();
    }
    @Override
    public int hashCode(){
        int hash = 17;
        return (hash*43)+kleur.hashCode();
    }
    @Override 
    public boolean equals (Object o){
        if (o instanceof Boekentas){
            Boekentas b = (Boekentas) o;
            return ((b.laadvolume.equals(laadvolume)) && (b.kleur.equals(kleur)));
        }
        else
            return false;
    }
    @Override
    public int compareTo (Boekentas b){
        return b.laadvolume.compareTo(laadvolume);
    }
    
    
}
