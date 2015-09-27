/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.view;
import javax.swing.*;
import java.awt.*;

class JIFCamera extends JInternalFrame
{
 public JIFCamera()
 {
  super("Camera");

  Container container = this.getContentPane();
  container.setLayout(new GridLayout(0,1));

  JPanel painel = new CapturaFoto();
  painel.setBackground(Color.BLACK);
  painel.setSize(200,200);
  container.add(painel);
  //container.add(new JLabel("Aguardando conexao..."));
  this.setVisible(true);
  this.setResizable(true);
  this.setMaximizable(true);
  this.setIconifiable(true);
  this.setClosable(true);
  this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  this.pack();
 }
}