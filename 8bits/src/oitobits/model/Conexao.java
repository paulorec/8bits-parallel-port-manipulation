/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.model;

/**
 *
 * @author paulo
 */
public interface Conexao {
    int porta = 128;

    public int ler();
    public void escrever();
    public void getStatus();
}
