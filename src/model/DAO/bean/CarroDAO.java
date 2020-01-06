/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.bean;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.bean.Carro;

/**
 *
 * @author MaryR
 */
public class CarroDAO {
    public void create(Carro car){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO carro (placa,dataCarro,cor,marca,modelo,chassi,proprietario,dataCompra)"
                    + "VALUES(?,?,?,?,?,?,?,?)");
            stmt.setString(1, car.getPlaca());
            stmt.setInt(2, car.getAnoCarro());
            stmt.setString(3, car.getCor());
            stmt.setString(4, car.getMarcar());
            stmt.setString(5, car.getModelo());
            stmt.setString(6, car.getChassi());
            stmt.setString(7, car.getProprietario());
            stmt.setDate(8, new java.sql.Date(car.getDataDaCompra().getTime()));
            
            stmt.executeUpdate();
            
            System.out.println("Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(String placa) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM carros WHERE placa = ?");
            stmt.setString(1, placa);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR:"+ex);
        } finally {
            if (stmt != null) {
                ConnectionFactory.closeConnection(con, stmt);
            } else {
                ConnectionFactory.closeConnection(con);
            }
        }
    }
}
