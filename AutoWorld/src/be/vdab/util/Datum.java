/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author bob.lamsens
 */
public class Datum implements Comparable<Datum>, Serializable{
    private static final long serialVersionUID = 1L;
    private static final LocalDate START_OF_TIME = LocalDate.of(1583, 1, 1);
    private static final LocalDate END_OF_TIME = LocalDate.of(4099, 1, 1);
    private final LocalDate currentDate;

    public Datum(int jaar, int maand, int dag) throws DatumException{
        
        try{
            LocalDate setDate = LocalDate.of(jaar,maand,dag);
            if (setDate.isAfter(START_OF_TIME) && setDate.isBefore(END_OF_TIME)){
                currentDate = LocalDate.of(jaar,maand,dag);
            }
            else{
                throw new DatumException("buiten de limieten.");
            }            
        }
        catch (DateTimeException dte){
            throw new DatumException("invalid jaar-maand-dag");
        }
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }
 
    @Override
    public String toString(){
        return currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                                                                    .toString();
    }
    @Override
    public boolean equals(Object o){
        if (o instanceof Datum){
            Datum d = (Datum) o;
            return currentDate.equals(d.getCurrentDate());
        }
        else{
            return false;
        }
    }
    @Override
    public int compareTo(Datum d){
        return currentDate.compareTo(d.getCurrentDate());
    }
    @Override
    public int hashCode(){
        return currentDate.hashCode();
    }
    
}
