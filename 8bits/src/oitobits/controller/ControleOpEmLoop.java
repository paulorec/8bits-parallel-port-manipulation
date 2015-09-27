/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.controller;

import oitobits.model.ConexaoParalela;
import oitobits.model.Paralela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import oitobits.view.JanelaOpEmLoop;

/**
 *
 * @author paulo
 */

@Deprecated
public class ControleOpEmLoop implements ActionListener {
 JanelaOpEmLoop jol;
 Loop thread;
 
  public void startJanela()
  {
   jol = new JanelaOpEmLoop(this);
  }

  public void actionPerformed(ActionEvent e) {
   if(e.getSource() == this.jol.iniciar)
   {
      int valores[] = this.jol.getInteiros();
     //Paralela paralela = new Paralela();
      int porta = jol.getPorta();
      int intervalo = jol.getIntervalo();

      //Status status = new Status(porta, jol.status);
      //status.start();
      if(porta != 0 && intervalo  != 0)
      {
       this.thread = new Loop(valores, porta, intervalo);
       this.thread.iniciado = true;
       this.thread.start();
       this.jol.iniciar.setEnabled(false);
       this.jol.parar.setEnabled(true);
      }
   }
   if(e.getSource() == this.jol.parar)
   {
     if(this.thread != null) this.thread.iniciado = false;
     this.jol.iniciar.setEnabled(true);
     this.jol.parar.setEnabled(false);
   }
  }
    public static void main(String[] args) {
        ControleOpEmLoop copLoop = new ControleOpEmLoop();
        copLoop.startJanela();
    }
}
class Loop extends Thread
{
 private int tempoEspera;
 private int[] sequenciaValores;
 private Paralela paralela;
 private int porta;
 public boolean iniciado = false;
 
 public Loop(int[] valores, int porta, int tempo)
 {
  this.sequenciaValores = valores;
  this.tempoEspera = tempo;
  //this.paralela = new Paralela();
  this.porta = porta;
 }

 @Override
 public void run()
 {
  try
  {
   while(this.iniciado)
   {
    for (int i : sequenciaValores)
    {
     this.paralela.setPorta(porta);
     this.paralela.escrever(i);
     Thread.sleep(tempoEspera);
    }
   }
  }
  catch(Exception e)
  {
   System.out.println("Excecao disparada por thread ");
   e.printStackTrace();   
  }
 }
}
