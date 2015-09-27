/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.view;
import javax.swing.*;
import java.awt.*;

class JIFConexaoRemota extends JInternalFrame
{
 public JIFConexaoRemota()
 {
  super("Conexao Remota");

  Container container = this.getContentPane();
  container.setLayout(new GridLayout(0,3));

  container.add(new JLabel("IP"));
  container.add(new JTextField());
  container.add(new JButton("Conectar"));
  this.setVisible(true);
  this.setResizable(true);
  this.setMaximizable(true);
  this.setIconifiable(true);
  this.setClosable(true);
  this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  this.pack();
 }
}