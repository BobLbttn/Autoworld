/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen.div;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author bob.lamsens
 */
public class Nummerplaat implements Comparable<Nummerplaat>, Serializable {
    
    private static final long serialVersionUID = 1L; 
    private String nummerplaat;
    
    protected Nummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }
    
    @Override 
    public String toString(){
        return nummerplaat;
    }
    
    @Override 
    public boolean equals(Object o){
        if (o instanceof Nummerplaat){
            Nummerplaat np = (Nummerplaat) o;
            return np.equals(nummerplaat);
        }
        else
            return false;
    }
    
    @Override
    public int hashCode(){
        int hash = 5;
        return (hash*43) + Objects.hashCode(this.nummerplaat);
    }
    
    @Override
    public int compareTo(Nummerplaat np){
        return nummerplaat.compareTo(np.getNummerplaat());
    }
    
}
