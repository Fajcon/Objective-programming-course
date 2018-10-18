package punkty;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    static LinkedList<Punkt3D> _punkty = new LinkedList<>();
    public static Punkt3D wczytajPunkt(){
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj x: ");
        double x = Double.parseDouble(odczyt.nextLine());
        System.out.println("Podaj y: ");
        double y = Double.parseDouble(odczyt.nextLine());
        System.out.println("Podaj z: ");
        double z = Double.parseDouble(odczyt.nextLine());
        System.out.println("Podaj nazwe punktu: ");
        String name = odczyt.nextLine();

        return new Punkt3D(x, y, z, name);
    }

    public static void wyswietlPunkty(){
        for (int i = 0; i < _punkty.size(); i++) {
            System.out.println(_punkty.get(i).name + ":" +_punkty.get(i).getX() + "," + _punkty.get(i).getY() + "," + _punkty.get(i).getZ());
        }
    }

    public static Double obliczOdleglosc(String punkty){
        String punkt1String = punkty.substring(2,3);
        String punkt2String = punkty.substring(6, 7);
        Punkt3D punkt1 = new Punkt3D(0,0,0, "Null");
        Punkt3D punkt2 = new Punkt3D(0,0,0, "Null");;
        for (int i = 0; i < _punkty.size(); i++) {
            if(_punkty.get(i).name.equals(punkt1String)){
                punkt1 = _punkty.get(i);
            }
            if(_punkty.get(i).name.equals(punkt2String)){
                punkt2 = _punkty.get(i);
            }
        }
        return punkt1.distance(punkt2);


    }

    public static void main(String[] argv){
        Scanner odczyt = new Scanner(System.in);
        while(true) {
            System.out.println("1. Wczytaj punkt 3D");
            System.out.println("2. Wyświetl wszystkie punkty");
            System.out.println("3. Oblicz odległość( 3[punkt1]_[punkt2] )");
            System.out.println("4. Zakończ");
            String numberString = odczyt.nextLine();
            if (numberString.equals("1")) _punkty.add(wczytajPunkt());
            else if (numberString.equals("2")) wyswietlPunkty();
            else if (numberString.charAt(0) == ('3')) System.out.println(obliczOdleglosc(numberString));
            else if (numberString.equals("4")) break;
            
        }

    }


}
