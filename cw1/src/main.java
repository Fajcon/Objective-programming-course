import static java.lang.Math.*;
import javaIn.*;


public class main{
        public static void main(String[] argv) {
            System.out.println("Podaj liczbe");
            Integer number = JIn.getInteger();
            int j;
            boolean[] numbers = new boolean[number];
            for (int i = 2; i < number; i++){
                numbers[i] = true;
            }
            LiczbyPierwsze.pierwsze(numbers);

            for (int i = 2; i < number; i++) {
                if (numbers[i]){
                    System.out.println(i);
                }
            }

        }
}
