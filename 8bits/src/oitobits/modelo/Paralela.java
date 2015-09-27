/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.modelo;

import oitobits.controlador.Fachada;
import oitobits.modelo.ConexaoParalela;

/**
 *
 * @author paulo
 */
public class Paralela {
 private ConexaoParalela conexao;
 private Dispositivo[] dispositivos;
 private static int porta;
 private static Paralela referencia;

    public Dispositivo[] getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(Dispositivo[] dispositivos) {
        this.dispositivos = dispositivos;
    }

 

 private Paralela()
 {
  try
  {
   this.conexao = ConexaoParalela.getInstance();
  }
  catch(Exception e)
  {
   Fachada.showErro(e.getMessage());
   e.printStackTrace();
  }
 }

 public static Paralela getInstancia()
 {
   if(Paralela.referencia == null) Paralela.referencia = new Paralela();
   return Paralela.referencia;
 }

 public static int getPorta() {
    return porta;
 }

 public static void setPorta(int porta) {
     Paralela.porta = porta;
 }

 public void escrever(int valor)
 {
  try
  {
  this.conexao.setPorta(Paralela.porta);
  this.conexao.enviar(valor);
  }
  catch(Exception e)
  {
   System.out.println("Não foi possivel escrever.\n" + e.getMessage());
  }
 }
 public String ler()
 {
  String status = Integer.toString(this.conexao.getStatus(Paralela.porta));
  return status;
 }

 public int castPorta(String porta)
 {
  int portaInt = 0;
  try
  {  
    if((porta.length() > 1) && (porta.substring(0, 2).equals("0x")))
    {
      portaInt = Integer.parseInt(porta.substring(2), 16);
    }
    else portaInt = Integer.parseInt(porta);
   }
   catch(Exception ex)
   {
   Fachada.showErro("Erro obtendo endereco da porta.  Verifique o valor digitado e tente novamente");
   System.out.println(ex.getMessage());
   }
  return portaInt;
 }

 public void toggleDispositivo(Dispositivo dispositivo) throws Exception
 {
  if(dispositivo.getPino() > 8) throw new Exception("Valor do pino está acima da capacidade de I/O.");
  if(dispositivo.getPino() < 1) throw new Exception("Pino deve ser maior que zero.");

  Paralela paralela = new Paralela();

  int valorAtual =  Integer.parseInt(paralela.ler());
  String binario = Integer.toBinaryString(valorAtual);
  
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
//System.out.println("Valor Binario: " + binario);
  char[] sequencia = binario.toCharArray();
  
  if(sequencia[dispositivo.getPino() - 1] == '0') 
      sequencia[dispositivo.getPino() - 1] = '1';
  else sequencia[dispositivo.getPino() - 1] = '0';
  
  /**
   * Nova string binaria
   */
  binario = String.copyValueOf(sequencia);

  int novoValor = Integer.parseInt(binario,2);

  //if(novoValor > 255) throw new Exception("Este dispositivo já está ligado");

  paralela.escrever(novoValor);
  if(dispositivo.isLigado()) dispositivo.setStatus(0);
  else dispositivo.setStatus(1);
 }
}