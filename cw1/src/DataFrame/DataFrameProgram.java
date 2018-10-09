package DataFrame;

import java.util.ArrayList;

public class DataFrameProgram {
    public static void main(String[] argv) {
        DataFrame test = new DataFrame(new String[]{"kol1", "kol2", "kol3"},
                new String[]{"int", "double", "MyCustomType"});
        test.data.get(0).add(12);
        test.data.get(1).add(13.5);
        test.data.get(2).add("test1");
        test.data.get(0).add(14);
        test.data.get(1).add(11.5);
        test.data.get(2).add("test2");

        System.out.println(test.size());
        System.out.println(test.get("kol1").get(1));

    }

}
