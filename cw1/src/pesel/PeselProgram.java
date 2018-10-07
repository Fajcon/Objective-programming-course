package pesel;

import javaIn.*;

public class PeselProgram {
    public static void main(String [] argv){
        System.out.println("Podaj pesel");
        String pesel_ = JIn.getString();
        if(Pesel.check(pesel_)) System.out.println("Ok");
        else System.out.println("Zly pesel");

    }
}
