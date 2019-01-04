package MultiThread;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Future;

public class GenerateRandoms {
    public static void main(String[] args) {
        Random random = new Random();
        MaxMultiThread multiThread = new MaxMultiThread();
        ArrayList<Future<ArrayList<Double>>> futureArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            futureArrayList.add(multiThread.execute(
                    () -> {
                        ArrayList<Double> r = new ArrayList<>();
                        for (int j = 0; j < 10000; j++) {
                            r.add(random.nextDouble());
                        }
                        return r;
                    }));
        }
        try {
            PrintWriter printWriter = new PrintWriter("randoms.txt");
        for (Future<ArrayList<Double>> f : futureArrayList) {
                ArrayList<Double> s = f.get();
            for (Double d:s) {
                printWriter.print(d + " ");
            }
                printWriter.println();
            }
            multiThread.end();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}