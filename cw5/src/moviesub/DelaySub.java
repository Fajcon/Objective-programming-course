package moviesub;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DelaySub {
    public static void main(String[] argv) {

        delay(argv[0], argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));

    }

    static void delay(final String in, final String out, int delay, int fps){
        Pattern compiledPattern = Pattern.compile("\\{(\\d+)\\}\\{(\\d+)\\}(.+)");
        File inFile = new File(in);
        Scanner sc = null;

        try {
            sc = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        PrintWriter outPrinter = null;
        try {
            outPrinter = new PrintWriter(out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher matcher = compiledPattern.matcher(line);
            int start = Integer.parseInt(matcher.group(1));
            int end = Integer.parseInt(matcher.group(2));

            start += delay/fps*1000;
            end += delay/fps*1000;


            System.out.println(line)

        }
        ;
    }
}
