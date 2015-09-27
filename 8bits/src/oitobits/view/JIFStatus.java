/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.view;
import javax.swing.*;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import oitobits.model.Paralela;

class JIFStatus extends JInternalFrame
{
 private static JTextArea ta;
 public JIFStatus()
 {
  super("Histórico");

  Container container = this.getContentPane();
  container.setLayout(new GridLayout(0,1));
  JIFStatus.ta = new JTextArea(5, 30);
  JIFStatus.ta.setText("[00:00:00](0x???)>");
  JIFStatus.ta.setBackground(Color.black);
  JIFStatus.ta.setForeground(Color.green);
  JIFStatus.ta.setLineWrap(true);

  JScrollPane scp = new JScrollPane(JIFStatus.ta);
  container.add(scp);
  //container.add(new JTextField());

  this.setVisible(true);
  this.setResizable(true);
  this.setMaximizable(true);
  this.setIconifiable(true);
  this.setClosable(true);
this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  this.pack();
 }

 public static void adicionar(String sequencia)
 {
   int _seqInt = Integer.parseInt(sequencia);
   SimpleDateFormat sd = new SimpleDateFormat("H:m:s");
   String hora = sd.format(new Date());
   
   String binario = Integer.toBinaryString(_seqInt);
   if(binario.length() != 8)
   {
    int zeros = 8 - binario.length();
    String pad = "";
    while(zeros != 0)
    {
     pad += "0";
     zeros--;
    }
    binario = pad + binario;
  }
     JIFStatus.ta.setText(JIFStatus.ta.getText() + "\n[" + hora + "](0x" + Integer.toHexString(Paralela.getPorta()) + ")" + "> " + binario);
 }
}