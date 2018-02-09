/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.vdab.util;

/**
 *
 * @author bob.lamsens
 */
public enum Maat {
    centimeter(1), decimeter(10), meter(100);
    private final int factor;

    private Maat(int factor) {
        this.factor = factor;
    }

    public int getFactor() {
        return factor;
    }
    
}
