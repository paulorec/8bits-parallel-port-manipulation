/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.modelo;

/**
 *
 * @author paulo
 */
public class ConexaoParalela implements Conexao{
 private int porta;
 private static ConexaoParalela referencia;
 
 static
 {
  System.loadLibrary("8bitslib");
 }
 native void escrever(int porta,int valor);
 native int ler(int porta);
 /**
  * Construtor privado para acessar os metodos desta classe utilie getInstance
  */
 private ConexaoParalela()
 {

 }

 /**
  * Singleton - Retorna uma instancia da classe ConexaoParalela
  * @return
  */
 public static ConexaoParalela getInstance()
 {
   if(ConexaoParalela.referencia == null) ConexaoParalela.referencia = new ConexaoParalela();
   return ConexaoParalela.referencia;
 }

 public void setPorta(int porta)
 {
   this.porta = porta;
 }

 public void enviar(int valor) throws Exception
 {
  if(valor > 255) throw new Exception("Valor Acima da Capacidade de I/O.");
  if(valor < 0) throw new Exception("Valores negativos não são suportados.");
  if(this.porta == 0) throw new Exception("O valor da porta não pode ser nulo.");
  //System.out.println("Escrevendo " + valor + " na porta " + porta);
  try {
  this.escrever(this.porta, valor);
  }
  catch(Exception e)
  {
   System.out.println("-----===================X=x==X======================-------");
      System.out.println("Um erro acaba de ocorrer! nome do erro: " + e.getMessage());
  System.out.println("-----===================X=x==X======================-------");
  this.enviar(valor);
  }
 }

 public int getStatus(int porta)
 {
     int resultado = 0;
     try {
     resultado = this.ler(porta);
  }
  catch(Exception e)
  {
   System.out.println("-----===================X=x==X======================-------");
      System.out.println("Um erro acaba de ocorrer! nome do erro: " + e.getMessage());
  System.out.println("-----===================X=x==X======================-------");
  this.getStatus(porta);
  }
  return resultado;
 }

    public int ler() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void escrever() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void getStatus() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}