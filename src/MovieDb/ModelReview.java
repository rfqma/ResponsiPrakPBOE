package MovieDb;

import javax.swing.*;
import java.sql.*;

public class ModelReview {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/movie_db";
    static final String USER = "root";
    static final String PASS = "hibiki123#";

    Connection con;
    Statement s;

    public ModelReview() {
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }

    public String[][] readData(){
        try{
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5];

            String query = "SELECT * FROM movie";
            ResultSet resultSet = s.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("judul"); //harus sesuai nama kolom di mysql
                data[jmlData][1] = String.valueOf(resultSet.getInt("alur"));
                data[jmlData][2] = String.valueOf(resultSet.getInt("penokohan"));
                data[jmlData][3] = String.valueOf(resultSet.getInt("akting"));
                data[jmlData][4] = String.valueOf(resultSet.getInt("nilai"));
                jmlData++;
            }
            return data;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }

    public void insertData(String Judul, int Alur, int Penokohan, int Akting, int Nilai){
        int jmlData=0;

        try {
            String query = "SELECT * FROM movie WHERE judul='" + Judul+"'";
            System.out.println(Judul + " " + Alur + " " + Penokohan + " " + Akting + " " + Nilai);
            ResultSet resultSet = s.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==0) {
                query = "INSERT INTO movie(judul, alur, penokohan, akting, nilai) VALUES('"+Judul+"','"+Alur+"','"+Penokohan+"','"+Akting+"','"+Nilai+"')";

                s = (Statement) con.createStatement();
                s.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public void updateData(String Judul, int Alur, int Penokohan, int Akting, int Nilai){
        int jmlData=0;
        try {
            String query = "SELECT * FROM movie WHERE judul='" + Judul+"'";
            ResultSet resultSet = s.executeQuery(query);

            while (resultSet.next()){
                jmlData++;
            }

            if (jmlData==1) {
                query = "UPDATE movie SET alur='" + Alur + "', penokohan='" + Penokohan + "', akting='"+ Akting+"', nilai='"+ Nilai+"' WHERE judul='" + Judul+"'";
                s = (Statement) con.createStatement();
                s.executeUpdate(query); //execute querynya
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            s = con.createStatement();
            String query = "SELECT * FROM movie";
            ResultSet resultSet = s.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteData (String Judul) {
        try{
            String query = "DELETE FROM movie WHERE judul = '"+Judul+"'";
            s = con.createStatement();
            s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }
}
