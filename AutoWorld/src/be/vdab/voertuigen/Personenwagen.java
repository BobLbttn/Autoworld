/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.voertuigen;

/**
 *
 * @author bob.lamsens
 */
public class Personenwagen extends Voertuig {
    private int zitplaatsen=1;

    public Personenwagen(int zitplaatsen, String merk, int aankoopprijs) {
        super(merk, aankoopprijs);
        setZitplaatsen(zitplaatsen);
    }

    public int getZitplaatsen() {
        return zitplaatsen;
    }

    public void setZitplaatsen(int zitplaatsen) {
        if (zitplaatsen > 0)
            this.zitplaatsen = zitplaatsen;
        else
            System.out.println("Een personenauto zonder zitplaatsen is absurd");
    }
}
