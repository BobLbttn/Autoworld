/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bob.lamsens
 */
public class Mens {
    private String naam;
    private List<Rijbewijs> rijbewijzen = new ArrayList <>();

    public Mens(String naam) {
        this.naam = naam;
    }
    
    
}
