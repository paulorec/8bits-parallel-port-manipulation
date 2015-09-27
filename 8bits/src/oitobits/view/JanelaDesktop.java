package oitobits.view;

import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;

import oitobits.controller.Fachada;

/**
 *
 * @author paulo
 */
public class JanelaDesktop extends JFrame
{
 private JDesktopPane desktop;
 protected JInternalFrame status,programacao,conexaoRemota,camera,alarme,controle;
 protected JCheckBoxMenuItem JMIstatus, JMIprogramacao, JMIconexaoRemota, JMIcamera, JMIalarme, JMIcontrole;
 
 public JanelaDesktop()
 {
  super("8Bits Automações");

    JDesktopPane desktop = new JDesktopPane();
    
    status = new JIFStatus();
    programacao = new JIFProgramacao();
    conexaoRemota = new JIFConexaoRemota();
    camera = new JIFCamera();
    alarme = new JIFAlarme();
    controle = new JIFSimples(Fachada.getDispositivos());

    controle.setSize(160, 275);
    status.setSize(750, 150);
    camera.setSize(200,200);
    alarme.setSize(245, 75);
    
    /**
     * Define a localização de cada frame interno.
     */
    controle.setLocation(5, 15);
    status.setLocation(0, 300);
    programacao.setLocation(175, 15);
    conexaoRemota.setLocation(175, 100);
    alarme.setLocation(175,200);
    camera.setLocation(550,85);

    desktop.setBackground(Color.gray);
    desktop.add(status);
    desktop.add(programacao);
    desktop.add(conexaoRemota);
    desktop.add(camera);
    desktop.add(alarme);
    desktop.add(controle);
    

    JFrame frame = this;
    JMenuBar mb = new JMenuBar();

    JMenu aplicativo = new JMenu("Aplicativo");
    JMenu janela = new JMenu("Janela");
    JMenu sobre = new JMenu("Sobre");

    /**
     * Instancia os JMI das janelas
     */
    this.JMIstatus = new JCheckBoxMenuItem("Histórico");
    this.JMIprogramacao = new JCheckBoxMenuItem("Programação");
    this.JMIconexaoRemota = new JCheckBoxMenuItem("Remoto");
    this.JMIcamera = new JCheckBoxMenuItem("Camêra");
    this.JMIalarme = new JCheckBoxMenuItem("Alarme");
    this.JMIcontrole = new JCheckBoxMenuItem("Controle");

    /**
     * Seleciona todos por default
     */
    JMIstatus.setSelected(true);
    JMIprogramacao.setSelected(true);
    JMIconexaoRemota.setSelected(true);
    JMIcamera.setSelected(true);
    JMIalarme.setSelected(true);
    JMIcontrole.setSelected(true);
    
    aplicativo.add(new JMenuItem("sair"));
    
    janela.add(JMIstatus);
    janela.add(JMIprogramacao);
    janela.add(JMIconexaoRemota);
    janela.add(JMIcamera);
    janela.add(JMIalarme);
    janela.add(JMIcontrole);

    JMIstatus.addActionListener(new MenuListener(this));
    JMIprogramacao.addActionListener(new MenuListener(this));
    JMIconexaoRemota.addActionListener(new MenuListener(this));
    JMIcamera.addActionListener(new MenuListener(this));
    JMIalarme.addActionListener(new MenuListener(this));
    JMIcontrole.addActionListener(new MenuListener(this));
    
    
    mb.add(aplicativo);
    mb.add(janela);
    mb.add(sobre);
    Container container = this.getContentPane();
    //container.setLayout(new FlowLayout());
    container.add(desktop, BorderLayout.CENTER);
    container.add(mb,BorderLayout.NORTH);
    
    frame.setSize(800, 600);
    frame.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Toolkit tk = Toolkit.getDefaultToolkit();
this.setLocation((int)((tk.getScreenSize().getWidth() - (double)this.getWidth()) / 2D), (int)((tk.getScreenSize().getHeight() - (double)this.getHeight()) / 2D));
 }
 
}

class MenuListener implements ActionListener
{
  private JanelaDesktop jd;
  
  public MenuListener(JanelaDesktop jd)
  {
   this.jd = jd;
  }

  public void actionPerformed(ActionEvent e)
  {
      if(e.getSource() == this.jd.JMIalarme)
      {
       if(this.jd.alarme.isVisible()) this.jd.alarme.setVisible(false);
       else this.jd.alarme.setVisible(true);
      }
      if(e.getSource() == this.jd.JMIcamera)
      {
        if(this.jd.camera.isVisible()) this.jd.camera.setVisible(false);
        else this.jd.camera.setVisible(true);
      }
      if(e.getSource() == this.jd.JMIconexaoRemota)
      {
        if(this.jd.conexaoRemota.isVisible()) this.jd.conexaoRemota.setVisible(false);
        else this.jd.conexaoRemota.setVisible(true);
      }
      if(e.getSource() == this.jd.JMIcontrole)
      {
        if(this.jd.controle.isVisible()) this.jd.controle.setVisible(false);
        else this.jd.controle.setVisible(true);
      }
      if(e.getSource() == this.jd.JMIprogramacao)
      {
        if(this.jd.programacao.isVisible()) this.jd.programacao.setVisible(false);
        this.jd.programacao.setVisible(true);
      }
      if(e.getSource() == this.jd.JMIstatus)
      {
        if(this.jd.status.isVisible()) this.jd.status.setVisible(false);
        else this.jd.status.setVisible(true);
      }

  }
    
}