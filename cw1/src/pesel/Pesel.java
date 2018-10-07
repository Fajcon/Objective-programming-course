package pesel;

public class Pesel {
    public static boolean check(String pesel){

        if (pesel.length() != 11) return false;
        Integer test = Integer.parseInt(pesel.substring(0, 1))*9+
        Integer.parseInt(pesel.substring(1, 2))*7+
        Integer.parseInt(pesel.substring(2, 3))*3+
        Integer.parseInt(pesel.substring(3, 4))+
        Integer.parseInt(pesel.substring(4, 5))*9+
        Integer.parseInt(pesel.substring(5, 6))*7+
        Integer.parseInt(pesel.substring(6, 7))*3+
        Integer.parseInt(pesel.substring(7, 8))+
        Integer.parseInt(pesel.substring(8, 9))*9+
        Integer.parseInt(pesel.substring(9, 10))*7;


        if(test%10 == Integer.parseInt(pesel.substring(10, 11))){
            return true;
        }
        else return false;
    }
}
