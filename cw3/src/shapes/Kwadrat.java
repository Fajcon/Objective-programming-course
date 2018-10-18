package shapes;

public class Kwadrat extends Shape{

    public int a;
    public Kwadrat(String _name, int _a) {
        name = _name;
        a = _a;
    }

    public void draw(){
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print("x");
            }
            System.out.println();
        }
    }

}
