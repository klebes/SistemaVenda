/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.venda.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author KDS
 */
public class TestarConexao {
    public static void main(String[] args) {
        try {
            new ConectorFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (Exception error) {
            
            JOptionPane.showMessageDialog(null, "Erro ao conectar!" + error);
        }
    }
}
