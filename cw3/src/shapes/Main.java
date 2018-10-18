package shapes;

import java.util.ArrayList;

public class Main {
    public static void main(String[] argv) {
        Kwadrat testKwadrat = new Kwadrat("test", 4);
        Prostokąt testProstokat = new Prostokąt("test", 6, 7);
        Trójkąt testTrojkat = new Trójkąt("test", 6);
        ArrayList<Shape> tablicaShape = new ArrayList<>();
        tablicaShape.add(testKwadrat);
        tablicaShape.add(testProstokat);
        tablicaShape.add(testTrojkat);
        for (int i = 0; i < tablicaShape.size(); i++) {
            tablicaShape.get(i).draw();
            System.out.println();
        }
    }
}
