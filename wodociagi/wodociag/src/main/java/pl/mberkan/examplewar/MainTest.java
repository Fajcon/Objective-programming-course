package pl.mberkan.examplewar;

public class MainTest {
    public static void main(String[] args){
        DB db = new DB();
        Node node = new Node("1",1,1,1,1,"1");
        NetworkGraf networkGraf = new NetworkGraf();
        networkGraf.addNode(node);
        db.addNetwork(networkGraf);
    }
}
