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

    /**
     * Atualiza o número exibido no display da calculadora
     * @param text Número do botão clicado
     */
    public void atualizarNumeroExibido(String num) {
        this.helper.concatenarNoDisplay(num);
    }

    /**
     * Limpa a tela que exibe o número no display
     */
    public void limparTela() {
        this.helper.limpar();
    }

    /**
     * Define o sinal do operacao e armazena numero atual digitado.
     * Se não houver nenhum numero no display, o método é ignorado.
     * @param text Sinal da operacao que será realizada.
     */
    public void definirOperacao(String op) {
        
        String numDoDisplay = this.helper.pegarNumeroDoDisplay();
        
        if( numDoDisplay.equals("") ) //Se não tem nenhum número no display, encerra o metodo
            return;
        
        //Define o numero1 e operacao
        this.view.setNum1(numDoDisplay);
        this.view.setOperacao(op);
        
        //Limpa o display
        this.helper.limpar();
    }

    /**
     * Exibe o resultado da operacao entre os dois números.
     * Caso não tenha o numero1 ainda, não faz nada.
     */
    public void exibirResultado() {
        
        String txtNumero1 = this.view.getNum1();
        String operacao = this.view.getOperacao();
        String txtNumero2 = this.helper.pegarNumeroDoDisplay();
        
        //Se não tiver numero1, encerra o método.
        if( txtNumero1.equals("") ) return;
        
        //Se não tiver número no display, o resultado é o próprio numero1
        if( txtNumero2.equals("") )
            this.helper.exibir( txtNumero1 );
        
        //Se tiver nnumero1, e algum numero no display
        
        //Guarda o numero2 na variavel
        this.view.setNum2(txtNumero2);
        
        //Calcula o resultado da operacao
        float resultado = 0;
        
        if( operacao.equals("+") )
            resultado = Float.parseFloat(txtNumero1) + Float.parseFloat(txtNumero2);
        
        else if( operacao.equals("-") )
            resultado = Float.parseFloat(txtNumero1) - Float.parseFloat(txtNumero2);
        
        else if( operacao.equals("x") )
            resultado = Float.parseFloat(txtNumero1) * Float.parseFloat(txtNumero2);
        
        else
            resultado = Float.parseFloat(txtNumero1) / Float.parseFloat(txtNumero2);
        
        this.helper.exibir(String.valueOf( resultado ));
    }
    
}
