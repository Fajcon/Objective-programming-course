package moviesub;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class DelaySub {
    public static void main(String[] argv) {

        try {
            delay(argv[0], argv[1], Integer.parseInt(argv[2]), Integer.parseInt(argv[3]));
        }catch (NoMatchException e){
            System.out.println(e.getMessage());
        }
        //delay("gravity.txt","out.txt", 10, 24);
    }

    static void delay(final String in, final String out, int delay, int fps) throws NoMatchException {
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
            if (matcher.find()) {
                int start = Integer.parseInt(matcher.group(1)) + (delay * 1000) / fps;
                int end = Integer.parseInt(matcher.group(2)) + (delay * 1000) / fps;

                StringBuilder result = new StringBuilder();
                result.append("{").append(start).append("}{").append(end).append("}").append(matcher.group(3));
                outPrinter.println(result.toString());
            }else throw new NoMatchException();

        }

    }
}
