package pl.mberkan.examplewar;

public class MainTest {
    public static void main(String[] args){
        
    }
    public static int[] PESEL(String[][] pesel){
        int[] result = new int[pesel.length];
        int sum = 0;
        for (int i = 0; i < pesel.length; i++) {
            sum = pesel[i][0].charAt(0) + pesel[i][0].charAt(1)*3 +pesel[i][0].charAt(2)*7 +pesel[i][0].charAt(3)*9 +
                    pesel[i][0].charAt(4) +pesel[i][0].charAt(5)*3 +pesel[i][0].charAt(6)*7 +pesel[i][0].charAt(7)*9 +
                    pesel[i][0].charAt(8) + pesel[i][0].charAt(0)*3 +pesel[i][0].charAt(0);
            if(sum%10 == 0){
                pesel[i][1] = "poprawny";
            }
            else{
                pesel[i][1] = "błędny";
            }
            result[i] = sum;
        }
        return result;
    }
}
