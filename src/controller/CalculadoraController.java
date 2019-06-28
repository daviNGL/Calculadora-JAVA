/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.helpers.CalculadoraHelper;
import view.CalculadoraView;

/**
 *
 * @author davin
 */
public class CalculadoraController {
    
    private final CalculadoraView view;
    private final CalculadoraHelper helper;
    
    public CalculadoraController(CalculadoraView view) {
        this.view = view;
        this.helper = new CalculadoraHelper(view);
    }
    
}
