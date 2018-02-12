/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util.mens;

/**
 *
 * @author bob.lamsens
 */
public enum Rijbewijs {
   A("A"), B("B"), C("C"), D("D"), BE("B+E"), CE("C+E"), DE("D+E");
   private final String code;
   Rijbewijs (String codeRijbewijs){
       this.code = codeRijbewijs;
   }
   public String getCode(){
       return this.code;
   }
}
