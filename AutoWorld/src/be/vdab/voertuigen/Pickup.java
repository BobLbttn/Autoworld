/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.*;
import be.vdab.util.mens.Mens;
import java.awt.Color;

/**
 *
 * @author bob.lamsens
 */
public class Pickup extends Personenwagen implements Laadbaar{
    private Volume laadvolume;

    public Pickup(String merk, int aankoopprijs, int zitplaatsen, 
                    Color kleur, Volume laadvolume, Mens...inzittende  ) {
        super(merk, aankoopprijs, kleur, zitplaatsen,inzittende);
        this.laadvolume = laadvolume;
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
