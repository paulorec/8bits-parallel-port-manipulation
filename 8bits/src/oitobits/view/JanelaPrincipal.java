/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.view;

import java.awt.event.ActionEvent;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;

import oitobits.controller.ControleOpEmLoop;
import oitobits.model.Paralela;

/**
 *
 * @author paulo
 */

@Deprecated
public class JanelaPrincipal extends JFrame{
 private JMenuBar barraMenu;
 JMenu aplicativo,operacoes;
 public JMenuItem operacaoSimples,operacaoLoop,sair;

 public JanelaPrincipal()
 {
  super("8Bits Automações");
  Container container = this.getContentPane();
  container.setLayout(new FlowLayout());

  barraMenu = new JMenuBar();
  aplicativo = new JMenu();
  operacoes = new JMenu();
  
  operacaoSimples = new JMenuItem();
  operacaoLoop = new JMenuItem();
  sair = new JMenuItem();

  aplicativo.setText("Aplicativo");
  operacoes.setText("Operações");
  operacaoSimples.setText("Operação Simples");
  operacaoLoop.setText("Operação em Loop");
  sair.setText("Sair");

  operacoes.add(operacaoSimples);
  operacoes.add(operacaoLoop);
  
  barraMenu.add(aplicativo);
  barraMenu.add(operacoes);
  barraMenu.add(new JMenu("Sobre"));
  barraMenu.add(sair);

  aplicativo.add(new JMenuItem(":-)"));
  
  operacaoSimples.addActionListener(new JanelaPrincipalAction(this));
  operacaoLoop.addActionListener(new JanelaPrincipalAction(this));
  sair.addActionListener(new JanelaPrincipalAction(this));
  
  container.add(barraMenu);
  container.add(new JLabel(new ImageIcon("logo.gif")));
  this.setVisible(true);
  this.setSize(250, 175);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Toolkit tk = Toolkit.getDefaultToolkit();
this.setLocation((int)((tk.getScreenSize().getWidth() - (double)this.getWidth()) / 2D), (int)((tk.getScreenSize().getHeight() - (double)this.getHeight()) / 2D));
 }
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());

        JanelaPrincipal programa = new JanelaPrincipal();

    }
}
class JanelaPrincipalAction implements ActionListener
{
 private JanelaPrincipal jp;
 
 public JanelaPrincipalAction(JanelaPrincipal jp)
 {
  this.jp = jp;
 }
 
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource() == this.jp.operacaoLoop)
  {
    ControleOpEmLoop cl = new ControleOpEmLoop();
    cl.startJanela();
  }
  if(e.getSource() == this.jp.operacaoSimples)
  {
    //Paralela pl = new Paralela();
    //pl.startOpSimples();
  }
  if(e.getSource() == this.jp.sair)
  {
    this.jp.dispose();
  }
 }
    
}
