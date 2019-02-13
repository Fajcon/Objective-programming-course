package pl.mberkan.examplewar;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private Connection conn2 = null;
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/wodociag","root", "");
            conn2 = DriverManager.getConnection("jdbc:mysql://localhost/wodociag","root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addNode(Node n){
        connect();
        try {
                stmt = conn.createStatement();
                String newValue = ("'"+n.getID()+"','"+n.getAltitude()+"','"+n.getPositionX()+"','"+n.getPositionY()+"','"+n.getPredefinedWaterUsage()+"','"
                        +n.getAdres()+"','"+n.getPrevID()+"'");
                stmt.executeUpdate("INSERT INTO punkty VALUES("+ newValue+");");
                stmt.close();
                stmt = conn2.createStatement();
                newValue = ("'"+n.getID()+"','"+0+"',"+0);
                stmt.executeUpdate("INSERT INTO woda VALUES("+ newValue+");");
                stmt.close();
                conn.close();
                conn2.close();
        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }

        }
    }

    public NetworkGraf getNetwork(){
        connect();
        NetworkGraf result = new NetworkGraf();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM punkty");
            while(rs.next()){
                result.nodes.add(new Node(rs.getString(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7)));
            }
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;

    }
    public Node getNode(String id){
        connect();
        Node result = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM punkty WHERE ID ="+'\"'+id+'\"');
            while(rs.next()){
                result = new Node(rs.getString(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
            }
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;

    }
    public ArrayList<Node> getNextNode(String id){
        connect();
        ArrayList<Node> result =new ArrayList<>();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM punkty WHERE PrevID ="+'\"'+id+'\"');
            while(rs.next()){
                result.add(new Node(rs.getString(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7)));
            }
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;

    }
    public Node getPrevNode(String id){
        connect();
        Node result = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM punkty WHERE ID ="+'\"'+prevID(id)+'\"');
            while(rs.next()){
                result = new Node(rs.getString(1),rs.getDouble(2),rs.getDouble(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6),rs.getString(7));
            }
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;

    }
    public String getWaterIn(String id){
        connect();
        String result = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT WaterIn FROM woda WHERE ID ="+'\"'+id+'\"');
            while(rs.next()){
                result = rs.getString(1);
            }
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;
    }
    public String getWaterOut(String id){
        connect();
        String result = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT WaterOut FROM woda WHERE ID ="+'\"'+id+'\"');
            while(rs.next()){
                result = rs.getString(1);
            }
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;
    }

    public boolean getWater(String id){
        boolean result = true;
        float water1 = 0;
        float water2 = 0;
        String prevID = prevID(id);
        ArrayList<Node> nodes = getNextNode(prevID);
        connect();
        try {
            stmt = conn.createStatement();
            for (Node n:nodes) {
                rs = stmt.executeQuery("SELECT WaterIn FROM woda WHERE ID =" + '\"' + n.getID()+ '\"');
                while(rs.next()) {
                    water1 += rs.getFloat(1);
                }
            }
            stmt.close();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT WaterOut FROM woda WHERE ID ="+'\"'+prevID+'\"');
            while (rs.next()){
                water2=rs.getFloat(1);
            }
            if(water1!=water2){
                result = true;
            } else result = false;
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return true;

    }
    public String prevID(String id){
        connect();
        String result = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT PrevID FROM punkty WHERE ID ="+'\"'+id+'\"');
            while(rs.next()){
                result = rs.getString(1);
            }
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void removeNode(String id){
        connect();
        Node result = null;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM punkty WHERE ID ="+'\"'+id+'\"');
            stmt.executeUpdate("DELETE FROM woda WHERE ID ="+'\"'+id+'\"');
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        connect();


        try {
            stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM punkty WHERE 1");
            stmt.executeUpdate("DELETE FROM woda WHERE 1");
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        DB db = new DB();
       db.delete();
    }
}
