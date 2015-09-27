/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oitobits.modelo;

/**
 *
 * @author paulo
 */
public class Hash {

    public static String md5(String string)
    {
       try {
          java.security.MessageDigest md =
             java.security.MessageDigest.getInstance("MD5");
          md.update(string.getBytes());
          byte[] hash = md.digest();
          StringBuffer hexString = new StringBuffer();
          for (int i = 0; i < hash.length; i++) {
             if ((0xff & hash[i]) < 0x10)
                hexString.append(
                   "0" + Integer.toHexString((0xFF & hash[i])));
             else
                hexString.append(Integer.toHexString(0xFF & hash[i]));
          }
          string = hexString.toString();
       }
       catch (Exception e) {
          e.printStackTrace();
       }
       return string;
    }
    public static void main(String[] args) {
        System.out.println(Hash.md5("123"));
    }
}
