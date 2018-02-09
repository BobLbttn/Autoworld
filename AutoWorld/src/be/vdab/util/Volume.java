/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

import java.io.Serializable;

/**
 *
 * @author bob.lamsens
 */
public class Volume implements Comparable<Volume>, Serializable {
    
    private final int breedte;
    private final int hoogte;
    private final int diepte;
    private final Maat maat;

    public Volume(int breedte, int hoogte, int diepte, Maat maat) {
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.diepte = diepte;
        this.maat = maat;
    }
    
    public long getVolume() throws VolumeException{
        long factor = (long)Math.pow(maat.getFactor(), 3);
        long volume = breedte*hoogte*diepte*factor;
        if (volume >= 0)
            return volume;
        else
            throw new VolumeException("Negative volume");
    }
    
    @Override 
    public boolean equals (Object o){
        if (o instanceof Volume){
            Volume v = (Volume) o;
            return (   (v.breedte == breedte) 
                    && (v.hoogte == hoogte) 
                    && (v.diepte == diepte)
                    && (v.maat.ordinal() == maat.ordinal()));
        }
        else {
            return false;
        }
    }
    
    @Override
    public int compareTo (Volume v){
        long v1 = 0, v2 = 0;
        try{
            v1 = getVolume();
        }
        catch (VolumeException ve){
            System.out.println("can not compare, invalid volume");
        }
        try{
            v2 = v.getVolume();
        }
        catch (VolumeException ve){
            System.out.println("can not compare, invalid volume");
        }

        return (int)(v1-v2);
    }
}
