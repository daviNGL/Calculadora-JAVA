/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.helpers;

import view.CalculadoraView;

/**
 *
 * @author davin
 */
public class CalculadoraHelper {
    
    private final CalculadoraView view;
    
    public CalculadoraHelper(CalculadoraView view) {
        this.view = view;
    }

    public void concatenarNoDisplay(String numeroClicado) {
        this.view.getTxtConta().setText( this.view.getTxtConta().getText() + numeroClicado );
    }

    public void limpar() {
        this.view.getTxtConta().setText("");
    }

    public String pegarNumeroDoDisplay() {
        return( this.view.getTxtConta().getText() );
    }

    public void exibir(String resultado) {
        this.view.getTxtConta().setText(resultado);
    }
    
}
