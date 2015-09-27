/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import oitobits.model.Paralela;


/**
 *
 * @author paulo amorim
 */
public class JanelaOpSimples extends JFrame{
    private JButton enviar;
    private JTextField porta,valor;
    public Paralela controlador;
    public JLabel statusPorta;

    public JanelaOpSimples(Paralela p)
    {
      super("8Bits Automações - Software para controle da porta paralela 0.01");
      this.controlador = p;
      Container container = this.getContentPane();
      container.setLayout(new GridLayout(0,5));

      enviar = new JButton();
      enviar.setText("Enviar");
      porta = new JTextField(15);
      porta.setText("0x378");

      porta.setToolTipText("Para utilizar valores hexadecimais utilize o prefixo 0x");
      valor = new JTextField(15);

      enviar.addActionListener(new EnviarBytes(this));
      valor.addKeyListener(new MascaraDigitos(valor));
      porta.addKeyListener(new MascaraHexa(porta));
      
      statusPorta = new JLabel();
      statusPorta.setToolTipText("Este é o estado atual da porta paralela");

      container.add(new JLabel("Porta:"));
      container.add(porta);
      container.add(new JLabel("Valor:"));
      container.add(valor);
      container.add(enviar);
      container.add(new JLabel("Status:"));
      container.add(statusPorta);
      this.setSize(350, 75);
      this.setVisible(true);
      this.setResizable(false);
      this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
Toolkit tk = Toolkit.getDefaultToolkit();
this.setLocation((int)((tk.getScreenSize().getWidth() - (double)this.getWidth()) / 2D), (int)((tk.getScreenSize().getHeight() - (double)this.getHeight()) / 2D));
    }

    public void erro(String erro)
    {
      JOptionPane.showMessageDialog(null, erro, "FALHA",JOptionPane.ERROR_MESSAGE);
    }

    public String getPorta()
    {
      return this.porta.getText();
    }
    
    public String getValor()
    {
      return this.valor.getText();
    }

}
class EnviarBytes implements ActionListener{
    JanelaOpSimples menu;
    public EnviarBytes(JanelaOpSimples menu)
    {
     this.menu = menu;
    }

    public void actionPerformed(ActionEvent e) {
     String porta = this.menu.getPorta();
     String valor = this.menu.getValor();

     /**
      * Tenta converter os valores para inteiros
      */
      try 
      {
        int valorInt = Integer.parseInt(valor);
        int portaInt;
        if((porta.length() > 1) && (porta.substring(0, 2).equals("0x")))
        {
          portaInt = Integer.parseInt(porta.substring(2), 16);
        }
        else portaInt = Integer.parseInt(porta);

        this.menu.controlador.setPorta(portaInt);
        this.menu.controlador.escrever(valorInt);
        this.menu.controlador.ler();
      }
      catch(Exception ex)
      {
       this.menu.erro("Dados inválidos! \n Os dois campos devem estar preenchidos e o" +
               " valor da porta em hexadecimal dever ser precedido de 0x");
       System.out.println(ex.getMessage());
      }
      
     JOptionPane.showMessageDialog(null, ":-)");
    }
}

class MascaraDigitos implements KeyListener{
 JTextField jt;
 Pattern padrao;

    public MascaraDigitos(JTextField jt)
    {
     this.jt = jt;
     this.padrao = Pattern.compile("[^0-9]");
    }

    public void keyTyped(KeyEvent e) {
     /*Matcher pesquisa = padrao.matcher(Character.toString(e.getKeyChar()));
     if(pesquisa.matches())
         e.setKeyChar(' ');*/
    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

     Matcher pesquisa = padrao.matcher(jt.getText());
     jt.setText(pesquisa.replaceAll(""));
    }
}

class MascaraHexa implements KeyListener{
 JTextField jt;
 Pattern padrao;

    public MascaraHexa(JTextField jt)
    {
     this.jt = jt;
     this.padrao = Pattern.compile("[^0-9a-fA-FxX]");
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

     Matcher pesquisa = padrao.matcher(jt.getText());
     jt.setText(pesquisa.replaceAll(""));
     if(jt.getText().length() > 5)
      jt.setText(jt.getText().substring(0, 5));
    }
}