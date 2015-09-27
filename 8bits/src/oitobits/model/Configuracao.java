/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.model;

/**
 *
 * @author paulo
 */
public class Configuracao {
    private Dispositivo[] dispositivo;
    private String senha;
    private String tempoAlarme;

    public Dispositivo[] getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo[] dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = Hash.md5(senha);
    }

    public String getTempoAlarme() {
        return tempoAlarme;
    }

    public void setTempoAlarme(String tempoAlarme) {
        this.tempoAlarme = tempoAlarme;
    }

    

}
