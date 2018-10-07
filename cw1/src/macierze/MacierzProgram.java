package macierze;

public class MacierzProgram{
        public static void main(String[] argv) {
            int[] macierzA = {1,6,2,3,4,1};
            int[] macierzB = {0,-3,5,1,4,6};
            Macierz a = new Macierz(2, 3, macierzA);
            Macierz b = new Macierz(3, 2, macierzB);
            Macierz result = a.mul(b);
            for (int i = 0; i < result.table.length; i++) {
                System.out.println(result.table[i]);
            }
        }
}
