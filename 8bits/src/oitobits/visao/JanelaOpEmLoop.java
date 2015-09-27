/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.visao;

import javax.swing.*;
import java.awt.*;
import oitobits.controlador.ControleOpEmLoop;
import oitobits.modelo.Paralela;

/**
 *
 * @author paulo
 */
@Deprecated
public class JanelaOpEmLoop extends JFrame{
 private JTextField porta,intervalo;
 private JTextField[] acoes;
 public JButton iniciar,parar;
 public JLabel status;
 
 @Deprecated
 public JanelaOpEmLoop(ControleOpEmLoop copLoop){
   super("8Bits Automações - Software para controle da porta paralela");
   Container container = this.getContentPane();
   container.setLayout(new GridLayout(0,2));

   

   porta = new JTextField("0x378");
   container.add(new JLabel("Endereço Paralela"));
   container.add(porta);
   acoes = new JTextField[4];

   for(int x=0;x < acoes.length;x++)
   {
    container.add(new JLabel("Byte " + x));
    if(acoes[x] == null) acoes[x] = new JTextField();
    container.add(acoes[x]);
   }
   container.add(new JLabel("Intervalo(em Ms)"));
   intervalo = new JTextField();
   container.add(intervalo);
   
   iniciar = new JButton("Iniciar");
   parar = new JButton("Parar");

   container.add(parar);
   container.add(iniciar);
   container.add(new JLabel("Status"));
   status = new JLabel("");
   container.add(status);
   this.setVisible(true);
   this.pack();
   this.setResizable(false);
   this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

   this.iniciar.addActionListener(copLoop);
   this.parar.addActionListener(copLoop);
Toolkit tk = Toolkit.getDefaultToolkit();
this.setLocation((int)((tk.getScreenSize().getWidth() - (double)this.getWidth()) / 2D), (int)((tk.getScreenSize().getHeight() - (double)this.getHeight()) / 2D));
 }
 
 public int[] getInteiros()
 {
  int bytes[] = new int[this.acoes.length];
  try
  {
   for(int x =0;x<acoes.length;x++)
   {
    if(!this.acoes[x].getText().equals(""))
    {
     bytes[x] = Integer.parseInt(this.acoes[x].getText());
    }
   }
  }
  catch(Exception e)
  {
   this.erro("Não possivel obter os bytes digitados.  Por favor entre com a base decimal" + e.getClass());
  }
  
  return bytes;
 }
@Deprecated
 public int getPorta()
 {
//   Paralela paralela = new Paralela();
   //return paralela.getPorta(this.porta.getText());
   return 0;
 }

 public int getIntervalo()
 {
   int intervalo = 500;
   try
   {
    intervalo = Integer.parseInt(this.intervalo.getText());
   }
   catch(Exception e)
   {
    this.erro("Não foi possivel obter o intevalo entre as sequencias.  Utilizando default de 500ms.");
   }
   return intervalo;
 }

 public void setStatus(String novoStatus)
 {
  this.status.setText(novoStatus);
 }

 public void erro(String erro)
 {
  JOptionPane.showMessageDialog(null, erro, "FALHA",JOptionPane.ERROR_MESSAGE);
 }
}
