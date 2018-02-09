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
public class Pickup extends Personenwagen implements Laadbaar{
    private Volume laadvolume;

    public Pickup(Volume laadvolume, int zitplaatsen, String merk, int aankoopprijs) {
        super(zitplaatsen, merk, aankoopprijs);
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
