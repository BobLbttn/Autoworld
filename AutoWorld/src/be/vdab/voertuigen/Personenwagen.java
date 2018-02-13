/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

import be.vdab.util.mens.Mens;
import java.awt.Color;
/**
 *
 * @author bob.lamsens
 */
public class Personenwagen extends Voertuig {
    private static final int MAX_AANTAL_ZITPLAATSEN=8;
    private Color kleur;

    public Personenwagen(String merk, int aankoopprijs, Color kleur,
                                int zitplaatsen,  Mens...inzittende) {
        
        super(merk, aankoopprijs, zitplaatsen,inzittende);
        setKleur(kleur);
    }

    public final Color getKleur() {
        return kleur;
    }

    public final void setKleur(Color kleur) {
        this.kleur = kleur;
    }

    @Override
    public int getMAX_AANTAL_ZITPLAATSEN() {
        return MAX_AANTAL_ZITPLAATSEN;
    }
}
