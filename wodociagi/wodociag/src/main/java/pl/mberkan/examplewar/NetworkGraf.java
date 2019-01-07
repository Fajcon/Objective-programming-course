package pl.mberkan.examplewar;

import java.util.ArrayList;

public class NetworkGraf {
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    ArrayList<Node> nodes = new ArrayList<>();
    ArrayList<Pipe> pipes = new ArrayList<>();
    public void addNode(Node n){
        nodes.add(n);
    }
    public void addPipe(Pipe p){
        pipes.add(p);
    }
}
