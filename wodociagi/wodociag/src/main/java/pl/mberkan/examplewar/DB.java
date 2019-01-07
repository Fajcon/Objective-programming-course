package pl.mberkan.examplewar;

import java.sql.*;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/ficon","ficon", "TBzLE3fcvoSVU1NG");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void addNetwork(NetworkGraf networkGraf){
        connect();
        try {
            for (Node n: networkGraf.getNodes()) {
                stmt = conn.createStatement();
                String newValue = ("'"+n.getID()+"','"+n.getAltitude()+"','"+n.getPositionX()+"','"+n.getPositionY()+"','"+n.getPredefinedWaterUsage()+"',"
                        +n.getAdres());
                stmt.executeUpdate("INSERT INTO wodociag VALUES("+ newValue+");");
                System.out.println("Sukces");
                stmt.close();
            }
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
}
