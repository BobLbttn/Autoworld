/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bob.lamsens
 */
public class Mens implements Serializable {
    private static final long serialVersionUID = 1L;
    private String naam;
    private List<Rijbewijs> rijbewijzen = new ArrayList <>();

    public Mens(String naam, Rijbewijs...rijbewijzen) {
        this.naam = naam;
        this.rijbewijzen = Arrays.asList(rijbewijzen);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public List<Rijbewijs> getRijbewijzen() {
        return rijbewijzen;
    }

    public void setRijbewijzen(List<Rijbewijs> rijbewijzen) {
        this.rijbewijzen = rijbewijzen;
    }
    
    public boolean hasRijbewijs (){
        return (rijbewijzen.size()>0);
    }
}
