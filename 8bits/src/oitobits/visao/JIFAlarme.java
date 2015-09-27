/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.visao;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import oitobits.controlador.Fachada;
import oitobits.modelo.Alarme;

class JIFAlarme extends JInternalFrame
{
 protected JButton toggleArma;
 protected JLabel status;
 
 public JIFAlarme()
 {
  super("Alarme");

  Container container = this.getContentPane();
  container.setLayout(new GridLayout(0,1));
  status = new JLabel("Alarme desarmado.");
  container.add(status);
  toggleArma = new JButton();
  if(Alarme.getInstance().isArmado()) toggleArma.setText("Desarmar Alarme");
  else toggleArma.setText("Armar Alarme");
  toggleArma.addActionListener(new AlarmeListener(this));
  container.add(toggleArma);
  this.setVisible(true);
  this.setResizable(true);
  this.setMaximizable(true);
  this.setIconifiable(true);
  this.setClosable(true);
  this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  this.pack();
 }
}

class AlarmeListener implements ActionListener{
    private JIFAlarme jif;
    
    public AlarmeListener(JIFAlarme jif)
    {
      this.jif = jif;
    }
    
    public void actionPerformed(ActionEvent e)
    {
     if(e.getSource().equals(this.jif.toggleArma))
     {
      String senha = JOptionPane.showInputDialog("Para Armar/Desarmar o Alarme é necessário fornecer a senha");

      try
      {
       if(senha == null) throw new Exception("A senha deve ser fornecida.");
       if(Alarme.getInstance().isArmado())
       {
        Alarme.getInstance().desarmar(senha);
        this.jif.toggleArma.setText("Armar Alarme");
       }
       else
       {
        this.jif.status.setIcon(new ImageIcon("loader.gif"));
        this.jif.status.setText("");
        this.jif.toggleArma.setText("Ativando Alarme...");
        this.jif.toggleArma.setEnabled(false);
        Aguardar timer = new Aguardar(this.jif,senha);
        timer.start();
       }
      }
      catch(Exception ex)
      {
       Fachada.showErro("Não foi possivel armar/desarmar: " + ex.getMessage());
      }
     }
    }
}

 class Aguardar extends Thread {
    private JIFAlarme jif;
    private String senha;
    public Aguardar(JIFAlarme jif,String senha)
    {
     this.jif = jif;
     this.senha = senha;
    }
    public void run() {
        try
        {
         Alarme.getInstance().armar(this.senha);
         jif.repaint();
         Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Aguardar.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(Exception e)
        {
         Fachada.showErro("Não foi possivel armar/desarmar: " + e.getMessage());
        }
        finally {
         jif.status.setIcon(null);
         jif.toggleArma.setEnabled(true);
         this.jif.status.setText("Dispositivo Armado");
         jif.toggleArma.setText("Desarmar Alarme");
        }
    }

     
 }