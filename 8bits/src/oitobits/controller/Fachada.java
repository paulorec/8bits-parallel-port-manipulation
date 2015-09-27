/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.controller;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import oitobits.model.Dispositivo;
import oitobits.model.Paralela;
import oitobits.model.SMS;
import oitobits.view.JanelaDesktop;

/**
 *
 * @author paulo
 */
public class Fachada {

 /**
  * Retorna um array de dispositivos associados a porta paralela
  * @return Dispostivo[]
  */
 public static Dispositivo[] getDispositivos()
 {
   Dispositivo[] dispositivos = new Dispositivo[8] ;
   for(int x=0;x<dispositivos.length;x++)
   {
       dispositivos[x] = new Dispositivo();
   }
    dispositivos[0].setNome("Dispositivo 1");
    dispositivos[1].setNome("Dispositivo 2");
    dispositivos[2].setNome("Dispositivo 3");
    dispositivos[3].setNome("Dispositivo 4");
    dispositivos[4].setNome("Dispositivo 5");
    dispositivos[5].setNome("Dispositivo 6");
    dispositivos[6].setNome("Dispositivo 7");
    dispositivos[7].setNome("Dispositivo 8");


    dispositivos[0].setPino(1);
    dispositivos[1].setPino(2);
    dispositivos[2].setPino(3);
    dispositivos[3].setPino(4);
    dispositivos[4].setPino(5);
    dispositivos[5].setPino(6);
    dispositivos[6].setPino(7);
    dispositivos[7].setPino(8);

    return dispositivos;
 }

 /**
  * Inicia a interface gráfica da aplicação.
  */
 public static void iniciarInterface()
 {
     JanelaDesktop jd = new JanelaDesktop();
 }

 /**
  * Metodo principal da aplicação.
  * @param argumentos
  */
 public static void main(String[] argumentos)
 {
  try
  {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    Fachada.resetParalela();
    Paralela.getInstancia().setDispositivos(Fachada.getDispositivos());
    Fachada.iniciarInterface();
  }
  catch(Exception e) { e.printStackTrace();}
     
 }

 public static void showErro(String erro)
 {
  JOptionPane.showMessageDialog(null, erro);
 }

 /**
  * Envia uma mensagem via celular para o número especificado.
  * @param numero
  * @param texto
  */
 public static void enviarSms(String numero, String texto)
 {
  try
  {
   SMS.enviar(numero, texto);
  }
  catch(Exception e)
  {
   Fachada.showErro("Não foi possivel enviar SMS: " + e.getMessage());
   e.printStackTrace();
  }
 }

 /**
  * Desliga todos os dispositivos associados a paralela.
  */
 public static void resetParalela()
 {
   Paralela.getInstancia().setPorta(888);
   Paralela.getInstancia().escrever(0);
 }
}