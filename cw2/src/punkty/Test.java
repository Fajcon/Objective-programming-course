package punkty;

import java.util.*;

public class Test {
    static LinkedList<Punkt3D> punkty = new LinkedList<>();
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
        for (int i = 0; i < punkty.size(); i++) {
            System.out.println(punkty.get(i).name + ":" +punkty.get(i).getX() + "," + punkty.get(i).getY() + "," + punkty.get(i).getZ());
        }
    }

    public static void obliczOdleglosc(){
        Scanner odczyt = new Scanner(System.in);
        System.out.println("test");
    }

    public static void main(String[] argv){
        Scanner odczyt = new Scanner(System.in);
        while(true) {
            System.out.println("1. Wczytaj punkt 3D");
            System.out.println("2. Wyświetl wszystkie punkty");
            System.out.println("3. Oblicz odległość");
            System.out.println("4. Zakończ");
            String numberString = odczyt.nextLine();
            if (numberString.equals("1")) punkty.add(wczytajPunkt());
            else if (numberString.equals("2")) wyswietlPunkty();
            else if (numberString.charAt(0) == '3') obliczOdleglosc();
            else if (numberString.equals("4")) wczytajPunkt();
        }

    }


}
