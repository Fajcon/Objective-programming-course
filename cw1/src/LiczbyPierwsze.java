import static java.lang.Math.*;

public class LiczbyPierwsze {
    public static void pierwsze(boolean[] numbers){

        int number = numbers.length;
        int j;

        for (int i = 2; i < number; i++){
            if (numbers[i]){
                j = i + i;
                while (j < number){
                    numbers[j] = false;
                    j += i;
                }
            }
        }

    }
}
