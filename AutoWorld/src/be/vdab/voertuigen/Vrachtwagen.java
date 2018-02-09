/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.*;

/**
 *
 * @author bob.lamsens
 */
public class Vrachtwagen extends Voertuig implements Laadbaar{

    private Volume laadvolume;
    private int maximaalToegelatenAssen;
    private int aantalAssen;

    public Vrachtwagen(Volume laadvolume, int maximaalToegelatenAssen, int aantalAssen, String merk, int aankoopprijs) {
        super(merk, aankoopprijs);
        this.laadvolume = laadvolume;
        setMaximaalToegelatenAssen(maximaalToegelatenAssen);
        setAantalAssen(aantalAssen);
    }

    public int getMaximaalToegelatenAssen() {
        return maximaalToegelatenAssen;
    }

    public void setMaximaalToegelatenAssen(int maximaalToegelatenAssen) {
        if (maximaalToegelatenAssen > 0)
            this.maximaalToegelatenAssen = maximaalToegelatenAssen;
        else
            System.out.println("ongeldig max toegelaten aantal assen.");
    }

    public int getAantalAssen() {
        return aantalAssen;
    }

    public void setAantalAssen(int aantalAssen) {
        if (aantalAssen > 0)
            this.aantalAssen = aantalAssen;
        else
            System.out.println("ongeldig aantal assen.");
    }
    
    @Override
    public Volume getLaadVolume() {
        return laadvolume;
    }

    @Override
    public void setLaadVolume(Volume laadvolume) {
        this.laadvolume = laadvolume;
    }

}
