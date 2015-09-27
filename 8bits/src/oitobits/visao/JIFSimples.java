/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.visao;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import oitobits.modelo.Dispositivo;
import oitobits.modelo.Paralela;

class JIFSimples extends JInternalFrame
{
 public static JButton[] botoes;
 public static JLabel[] labels;
 
 public JIFSimples(Dispositivo[] dispositivos)
 {
  super("Liga/Desliga");
  JIFSimplesListener listener = new JIFSimplesListener(this);
  Container container = this.getContentPane();
  container.setLayout(new GridLayout(0,2));
 System.out.println(Paralela.getInstancia().getDispositivos().length);
  botoes = new JButton[Paralela.getInstancia().getDispositivos().length];
  labels = new JLabel[Paralela.getInstancia().getDispositivos().length];
  for(int x =0;x<Paralela.getInstancia().getDispositivos().length;x++)
  {
   labels[x] = new JLabel(Paralela.getInstancia().getDispositivos()[x].getNome());
   botoes[x] = new JButton();
   if(Paralela.getInstancia().getDispositivos()[x].isLigado()) botoes[x].setText("Desligar");
   else botoes[x].setText("Ligar");

   botoes[x].setToolTipText("Liga ou desliga esse dispositivo");
   botoes[x].addActionListener(listener);
   container.add(labels[x]);
   container.add(botoes[x]);
  }

  this.setVisible(true);
  this.setResizable(true);
  this.setMaximizable(true);
  this.setIconifiable(true);
  this.setClosable(true);
  this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
  this.pack();
 }

  public void refresh()
  {
   for(int x =0;x<Paralela.getInstancia().getDispositivos().length;x++)
   {
    if(Paralela.getInstancia().getDispositivos()[x].isLigado()) botoes[x].setText("Desligar");
    else botoes[x].setText("Ligar");
   }
  }
}

class JIFSimplesListener implements ActionListener{
   private JIFSimples jif;

   public JIFSimplesListener(JIFSimples jif)
   {
       this.jif = jif;
   }

   public void actionPerformed(ActionEvent e)
   {
    int x =0;
    for (JButton botao : JIFSimples.botoes) {
     if(e.getSource() == botao)
     {
       //JOptionPane.showMessageDialog(null, "Pino do dispositivo: " + Paralela.getInstancia().getDispositivos()[x].getPino());
       try
       {
       /**
        * Verifica se existe uma porta configurada.
        */
        if(Paralela.getInstancia().getPorta() == 0)
        {
         String porta = JOptionPane.showInputDialog("Não foi encontrado uma " +
                " configuração de porta válida.\n Entre com o número de porta" +
                " válida.Atenção uma porta inválida pode causar instabilidade " +
                " na maquina virtual");
         Paralela.getInstancia().setPorta(Paralela.getInstancia().castPorta(porta));
        }
          
          Paralela.getInstancia().toggleDispositivo(Paralela.getInstancia().getDispositivos()[x]);
          JIFStatus.adicionar(Paralela.getInstancia().ler());
          this.jif.refresh();
       }
       catch(Exception ex)
       {
        JOptionPane.showMessageDialog(null,"Houve uma falha acionando este dispositivo. Exceção:" + ex.getMessage());
        ex.printStackTrace();
       }
       
     }
     x++;
    }
   }
    
}