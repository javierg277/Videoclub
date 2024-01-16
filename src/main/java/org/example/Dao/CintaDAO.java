package org.example.Dao;

import org.example.conexion.Connect;
import org.example.model.Cinta;
import org.example.Controller.ProgramController;

import java.sql.Connection;

public class CintaDAO {
    private Connection conn;
    public CintaDAO(Connection conn) {
        this.conn = conn;
    }
    public CintaDAO() {
        this.conn= Connect.getConnect();
    }
    public int GetLastIdCinta(){
        int a = (int)Math.random() * 1000;
        return a;
    }
    public void CreateCinta(Cinta cinta){
        try {
            String sql = "INSERT INTO cinta(name,director) VALUES(?,?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,cinta.getName());
            pst.setString(2,cinta.getDirector());
            pst.execute();
        } catch (Exception e) {
    }
}
    public void CreateDirector(Cinta cinta){
        int age = 30;
        try {
            String sql = "INSERT INTO director(director,edad) VALUES(?,?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,cinta.getDirector());
            pst.setInt(2,age);
            pst.execute();
        } catch (Exception e) {
        }
    }
}
