package sample;

import java.sql.*;

import java.sql.*;
import java.util.ArrayList;

public class DB{
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public void connect() {
        int tests = 0;
        while (tests < 3) {
            try {
                conn =
                        DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/ficon",
                                "ficon", "TBzLE3fcvoSVU1NG");
                System.out.println("Sukces");
                tests = 3;

            } catch (SQLException ex) {
                tests++;
                // handle any errors
                if(tests == 3) {
                    System.out.println("SQLException: " + ex.getMessage());
                    System.out.println("SQLState: " + ex.getSQLState());
                    System.out.println("VendorError: " + ex.getErrorCode());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList getData(){
        try {
            ArrayList<Book> listData = new ArrayList();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");
            while(rs.next()){
                listData.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
            return listData;

        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;
    }

    public ArrayList getDataByIsbn(String isbn){
        try {
            ArrayList<Book> listData = new ArrayList();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE isbn = " +isbn+ ";");
            while(rs.next()){
                listData.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }

            return listData;

        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;
    }

    public ArrayList getDataByAuthor(String author){
        try {
            ArrayList<Book> listData = new ArrayList();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE author like '" +author+ "';");
            while(rs.next()){
                listData.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }

            return listData;

        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;
    }

    public ArrayList getDataBylastName(String lastName){
        try {
            ArrayList<Book> listData = new ArrayList();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE author like '% " +lastName+ "';");
            while(rs.next()){
                listData.add(new Book(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
            return listData;
        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
        return null;
    }

    public void addBook(Book book){
        try {
            connect();
            String newValue = ("'"+book.getIsbn()+"'"+",'"+book.getTitle()+"','"+book.getAuthor()+"',"+book.getYear());
            stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO books VALUES("+ newValue+");");
        }catch (SQLException ex){
            // handle any errors
        }finally {
            // zwalniamy zasoby, które nie będą potrzebne
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) { } // ignore
                rs = null;
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) { } // ignore
                stmt = null;
            }
        }
    }
}