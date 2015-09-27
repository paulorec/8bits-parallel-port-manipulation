/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.model;

/**
 *
 * @author paulo
 */
public class Alarme extends Dispositivo{
    private final String nome = "alarme";
    public final String senha = "86d9a88a5015cae4f7e9417478f21dc8";
    private boolean isArmado = false;
    private static Alarme instancia;
    
    private Alarme(){
        
    }

    public static Alarme getInstance()
    {
     if(Alarme.instancia == null) Alarme.instancia = new Alarme();
     return Alarme.instancia;
    }

    public boolean isArmado()
    {
        return this.isArmado;
    }

    /**
     * implementar tempo de espera.
     */
    public void armar(String senha) throws Exception{
     if(Hash.md5(senha).equals(this.senha))
     {
        this.isArmado = true;
        String numeroPauloVivo = "558181730907";
        String numeroPauloOi = "558186493223";
        String numeroDeyvison = "558187133250";
        String numeroDiego = "558188715541";
        String numeroZe = "558187974527";
        String numeroIssack = "558187091716";

        //SMS.enviar(numeroDeyvison, SMS.MSG_ALARME_ARMADO);
        //SMS.enviar(numeroDiego, SMS.MSG_ALARME_ARMADO);
        //SMS.enviar(numeroZe, SMS.MSG_ALARME_ARMADO);
        //SMS.enviar(numeroIssack, SMS.MSG_ALARME_ARMADO);
        SMS.enviar(numeroPauloVivo, SMS.MSG_ALARME_ARMADO);
        SMS.enviar(numeroPauloOi, SMS.MSG_ALARME_ARMADO);

     }
     else throw new Exception("Senha inválida!");
    }

    public void desarmar(String senha) throws Exception
    {
     if(Hash.md5(senha).equals(this.senha))
        this.isArmado = false;
     else throw new Exception("Senha inválida!");
    }

}
/**
 * paulorec@hotmail.com
 */