package MultiThread;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.stream.DoubleStream;


public class GenerateRandoms {
    public static void main(String[] args) {
        Random random = new Random();
        MaxMultiThread multiThread = new MaxMultiThread();
        ArrayList<Future<DoubleStream>> futureArrayList = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            futureArrayList.add(multiThread.execute(
                    () -> {
                        DoubleStream r = random.doubles(10000);
                        return r;
                    }));
        }
        try {
            PrintWriter printWriter = new PrintWriter("randoms.txt");
        for (Future<DoubleStream> f : futureArrayList) {
                DoubleStream s = f.get();
                s.forEach((double i) -> {
                    printWriter.print(i + " ");
                });
                printWriter.println();
            }
            multiThread.end();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}