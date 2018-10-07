/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Szymon
 */
public class LoginProgram {
    public static void main(String[] argv){
      Login log = new Login ("ala", "makota");
	  try{
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader bfr = new BufferedReader(rd);

        // TODO: prosba o wpisanie hasła i loginu
		System.out.println("Podaj Login");
		String login = bfr.readLine();
		  System.out.println("Podaj Haslo");
        String password = bfr.readLine();


        /*TODO: sprawdzenie czy podane hasło i login zgadzaja sie z tymi
         przechowywanymi w obiekcie log Jeśli tak, to ma zostać
         wyswietlone "OK", jesli nie - prosze wyswietlić informacje o błedzie
         */

        if (log.check(login, password)){
        	System.out.println("OK");
		}
		else System.out.println("Zle haslo");

	  }catch(IOException e){e.printStackTrace();}

    }
}
