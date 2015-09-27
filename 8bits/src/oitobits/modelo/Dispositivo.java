/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.modelo;

import oitobits.controlador.*;

/**
 *
 * @author paulo
 */
public class Dispositivo {
 private int status;
 private String nome;
 private int pino;

 public boolean isLigado()
 {
   if(this.status == 1) return true;
   return false;
 }

 public String getNome()
 {
   return this.nome;
 }

 public void setNome(String nome)
 {
  this.nome = nome;
 }

 public void setStatus(int status)
 {
  this.status = status;
 }

 public void setPino(int pino)
 {
  this.pino = pino;
 }

 public int getPino()
 {
  return this.pino;
 }

}
