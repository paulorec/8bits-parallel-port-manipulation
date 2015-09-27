/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.visao;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;

class JIFProgramacao extends JInternalFrame
{
 public JIFProgramacao()
 {
  super("Controle por programação");

  Container container = this.getContentPane();
  container.setLayout(new GridLayout(0,6));

  SpinnerModel smHora = new SpinnerNumberModel(12,0,23,1);
  SpinnerModel smMinuto = new SpinnerNumberModel(50,0,59,1);
  container.add(new JLabel("Hora"));
  container.add(new JSpinner(smHora));
  container.add(new JSpinner(smMinuto));
  JComboBox cb = new JComboBox();
  cb.addItem("LED");
  cb.addItem("Irrigador");
  cb.addItem("Alarme");
  cb.addItem("Geladeira");
  cb.addItem("Bomba dagua");
  cb.addItem("Antena");
  cb.addItem("Roteador");
  cb.addItem("Portão");

  container.add(cb);
  container.add(new JButton("Salvar"));
  this.setVisible(true);
  this.setResizable(true);
  this.setMaximizable(true);
  this.setIconifiable(true);
  this.setClosable(true);
  this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

  this.pack();
 }
}