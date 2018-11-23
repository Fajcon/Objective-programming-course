package wykres;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.*;

public class Wielomian {
    private String _wzor;
    private Pattern _pattern;
    private double result;


    public Wielomian(String wzor) {
        _pattern = Pattern.compile("(\\+|\\-)(\\d*)(\\w)(\\^)?(\\-?\\d*)");
        if (wzor.charAt(0) != '-')_wzor = '+' + wzor;
        else _wzor = wzor;

    }
    public double getResult(int x) {
        Matcher matcher = _pattern.matcher(_wzor);
        result = 0;
        while (matcher.find()) {
            if (matcher.group(1).equals("-")) {
                if (matcher.group(2).equals("")) {
                    if (matcher.group(5).equals("")) result -= 1 * x;
                    else result -= 1 * pow(x, Double.parseDouble(matcher.group(5)));
                } else {
                    if (matcher.group(5).equals("")) result -= Double.parseDouble(matcher.group(2)) * x;
                    else result -= Double.parseDouble(matcher.group(2)) * pow(x, Double.parseDouble(matcher.group(5)));
                }
            } else {
                if (matcher.group(2).equals("")) {
                    if (matcher.group(5).equals("")) result += 1 * x;
                    else result += 1 * pow(x, Double.parseDouble(matcher.group(5)));
                } else {
                    if (matcher.group(5).equals("")) result += Double.parseDouble(matcher.group(2)) * x;
                    else result += Double.parseDouble(matcher.group(2)) * pow(x, Double.parseDouble(matcher.group(5)));
                }

            }
        }
        return result;
    }
}
