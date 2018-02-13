/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.util.*;
import be.vdab.util.mens.Mens;
import static be.vdab.util.mens.Rijbewijs.A;
import static be.vdab.util.mens.Rijbewijs.B;
import static be.vdab.util.mens.Rijbewijs.BE;
import static be.vdab.util.mens.Rijbewijs.C;
import static be.vdab.util.mens.Rijbewijs.CE;
import static be.vdab.util.mens.Rijbewijs.D;
import be.vdab.voertuigen.*;
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author bob.lamsens
 */
public class AutoworldMain {
    public static void main (String[] args){
        
        Mens BESTUURDER_A = new Mens("Andree",A);
        Mens BESTUURDER_AB = new Mens("Amadeus",A,B);
        Mens BESTUURDER_B = new Mens("Bernard",B);
        Mens BESTUURDER_BC = new Mens("Beatrice-Clothilde",B,C);
        Mens BESTUURDER_C = new Mens("Catherina",C);
        Mens BESTUURDER_D = new Mens("Didier",D);
        Mens BESTUURDER_BE = new Mens("Beatrice-Emanuella",BE);
        Mens BESTUURDER_BBE = new Mens("Babette-Emanuella",B,BE);
        Mens BESTUURDER_CE = new Mens("Cederic-Eduard",CE);
        Mens BESTUURDER_DE = new Mens("Dominique-Emille",CE);
        Mens BESTUURDER_BBECCE = new Mens("Ammelie",B,BE,C,CE);
        Mens INGEZETENE_A = new Mens("Anita");
        Mens INGEZETENE_B = new Mens("Bert");
        Mens INGEZETENE_C = new Mens("Christina");
        Mens INGEZETENE_D = new Mens("Duts");
        Mens INGEZETENE_E = new Mens("Elsa");
        Mens INGEZETENE_F = new Mens("Fred");
        Mens INGEZETENE_G = new Mens("Gerda");
        Mens INGEZETENE_H = new Mens("Hedwig");
        Mens INGEZETENE_I = new Mens("Ingrid");
        
        Set<Voertuig> voertuigen = new TreeSet<>();
        Set<Voertuig> voertuigen2 = new TreeSet<>();
        
        Voertuig v1 = new Personenwagen("Opel Corsa", 15000, Color.BLACK, 4, 
                                        BESTUURDER_B, INGEZETENE_A, INGEZETENE_B);
        voertuigen.add(v1);
        
        Voertuig v2 = new Personenwagen("VW Touran", 25000, Color.BLACK, 4, 
                                        BESTUURDER_BC, INGEZETENE_C, INGEZETENE_D, INGEZETENE_E);
        voertuigen.add(v2);
        
        Volume vol1 = new Volume(20,20,5, Maat.decimeter);
        Voertuig v3 = new Pickup("Nissan Navara", 30000, 4, Color.GRAY, vol1, BESTUURDER_C );
        voertuigen.add(v3);
        
        Volume vol2 = new Volume(150,200,60, Maat.centimeter);
        Voertuig v4 = new Pickup("VW Amarok", 35000, 4, Color.BLUE, vol2, BESTUURDER_CE, INGEZETENE_F );
        voertuigen.add(v4);
        
        Volume vol3 = new Volume(4,2,2, Maat.meter);
        Voertuig v5 = new Vrachtwagen("DAF", 100000, 2, vol3, 4, 4, BESTUURDER_D );
        voertuigen.add(v5);
        
        for (Voertuig eenVoertuig:voertuigen)
        {
            System.out.println(eenVoertuig.toString() + " " + eenVoertuig.getMerk());
        }
        System.out.println();
        System.out.println("saving data");
        try{
            FileOutputStream ofs = new FileOutputStream("c:/tmp/wagenpark.dat");
            ObjectOutputStream oos = new ObjectOutputStream(ofs);
            oos.writeObject(voertuigen);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("retreiving data");
        try{
            FileInputStream ifs = new FileInputStream("c:/tmp/wagenpark.dat");
            ObjectInputStream ois = new ObjectInputStream(ifs);
            try{
                voertuigen2 = (Set<Voertuig>) ois.readObject();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        System.out.println();
        for (Voertuig eenVoertuig:voertuigen2)
        {
            System.out.println(eenVoertuig.toString() + " " + eenVoertuig.getMerk());
        }

        System.out.println();
        System.out.println("sorteer op Merk");

        Comparator cv = voertuigen2.iterator().next().getMerkComparator();
        voertuigen2.stream().sorted(cv).forEach(voertuig -> {Voertuig v = (Voertuig)voertuig;System.out.println(v.getMerk() + " " +v.toString());});
        
        System.out.println();
        System.out.println("datum test");
        try{
            Datum d1 = new Datum (5000,2,10);
            System.out.println(d1);
            
        }
        catch(DatumException de){
            System.out.println("Oops!!!");
        }

    }
}
