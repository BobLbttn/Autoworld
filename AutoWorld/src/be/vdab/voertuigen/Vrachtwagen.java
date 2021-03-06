/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.*;
import be.vdab.util.mens.Mens;

/**
 *
 * @author bob.lamsens
 */
public class Vrachtwagen extends Voertuig implements Laadbaar{

    private static final int MAX_AANTAL_ZITPLAATSEN=3;
    private Volume laadvolume;
    private int maximaalToegelatenAssen;
    private int aantalAssen;

    public Vrachtwagen(String merk, int aankoopprijs, int zitplaatsen, 
                          Volume laadvolume, int maximaalToegelatenAssen, 
                                       int aantalAssen, Mens...inzittende) {
        super(merk, aankoopprijs, zitplaatsen, inzittende);
        this.laadvolume = laadvolume;
        setMaximaalToegelatenAssen(maximaalToegelatenAssen);
        setAantalAssen(aantalAssen);
    }

    public final int getMaximaalToegelatenAssen() {
        return maximaalToegelatenAssen;
    }

    public final void setMaximaalToegelatenAssen(int maximaalToegelatenAssen) {
        if (maximaalToegelatenAssen > 0)
            this.maximaalToegelatenAssen = maximaalToegelatenAssen;
        else
            System.out.println("ongeldig max toegelaten aantal assen.");
    }

    public final int getAantalAssen() {
        return aantalAssen;
    }

    public final void setAantalAssen(int aantalAssen) {
        if (aantalAssen > 0)
            this.aantalAssen = aantalAssen;
        else
            System.out.println("ongeldig aantal assen.");
    }
    @Override
    public int getMAX_AANTAL_ZITPLAATSEN() {
        return MAX_AANTAL_ZITPLAATSEN;
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
