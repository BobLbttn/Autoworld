/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab;

import be.vdab.schoolgerief.Boekentas;
import be.vdab.util.*;
import be.vdab.voertuigen.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author bob.lamsens
 */
public class AutoworldMain {
    public static void main (String[] args){
        
        Set<Voertuig> voertuigen = new TreeSet<>();
        Set<Voertuig> voertuigen2 = new TreeSet<>();
        List<Laadbaar> laadtest = new ArrayList <>();
        
        Voertuig v1 = new Personenwagen(4, "Opel Corsa", 15000);
        voertuigen.add(v1);
        
        Voertuig v2 = new Personenwagen(6, "VW Touran", 25000);
        voertuigen.add(v2);
        
        Volume vol1 = new Volume(20,20,5, Maat.decimeter);
        Voertuig v3 = new Pickup(vol1, 4, "Nissan Navara", 30000);
        voertuigen.add(v3);
        
        Volume vol2 = new Volume(150,200,60, Maat.centimeter);
        Voertuig v4 = new Pickup(vol2, 5, "VW Amarok", 35000);
        voertuigen.add(v4);
        
        Volume vol3 = new Volume(4,2,2, Maat.meter);
        Voertuig v5 = new Vrachtwagen(vol3, 4, 4, "DAF", 100000);
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
        System.out.println("test laadbaar");
        
        laadtest.add((Pickup)v3);
        laadtest.add((Pickup)v4);
        laadtest.add((Vrachtwagen)v5);
        
        Boekentas b1 = new Boekentas("rood",new Volume(50,10,60,Maat.centimeter) );
        laadtest.add (b1);
        
        for (Laadbaar lading:laadtest){
            
            if (lading instanceof Voertuig){
                Voertuig v = (Voertuig) lading;
                try{
                    System.out.println(v.getMerk() + " " + Long.toString(lading.getLaadVolume().getVolume()));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
            else{
                try{
                    System.out.println ("boekentas volume: " + Long.toString(lading.getLaadVolume().getVolume()));
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
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
