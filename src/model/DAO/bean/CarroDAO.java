/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO.bean;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            stmt.setString(4, car.getMarca());
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
    
    public Carro returnCar(String placa) throws SQLException{
        String sql = "SELECT * FROM carro WHERE placa=(?)";
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        stmt = con.prepareStatement(sql);
        
        stmt.setString(1, placa);
        
        ResultSet rs = stmt.executeQuery();
        
        Carro carro = new Carro();
        
        while(rs.next()){
            carro.setPlaca(rs.getString("placa"));
            carro.setAnoCarro(rs.getInt("dataCarro"));
            carro.setCor(rs.getString("cor"));
            carro.setMarca(rs.getString("marca"));
            carro.setModelo(rs.getString("modelo"));
            carro.setChassi(rs.getString("chassi"));
            carro.setProprietario(rs.getString("proprietario"));
            carro.setDataDaCompra(rs.getDate("dataCompra"));
        }
        stmt.close();
        
        return carro;
    }
    
    public void update(Carro carro) throws SQLException{
        String sql = "UPDATE carro SET placa=(?),dataCarro=(?),cor=(?),"
                + "marca=(?),modelo=(?),chassi=(?),proprietario=(?),dataCompra=(?) "
                + "WHERE placa=(?)";
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = con.prepareCall(sql);
        
        try {
            stmt.setString(1, carro.getPlaca());
            stmt.setInt(2, carro.getAnoCarro());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getMarca());
            stmt.setString(5, carro.getModelo());
            stmt.setString(6, carro.getChassi());
            stmt.setString(7, carro.getProprietario());
            stmt.setDate(8, new java.sql.Date(carro.getDataDaCompra().getTime()));
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERROR: "+ex);
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
    
    public void alterTable(String placa, Carro carro) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
       
        try {
            stmt = con.prepareStatement("UPDATE carro SET placa='?',dataCarro='?',cor='?',"
                    + "marca='?',modelo'?',chassi='?',proprietario='?',dataCompra='?' "
                    + "WHERE placa = '?'");
            stmt.setString(1, placa);
            
            stmt.setString(1, carro.getPlaca());
            stmt.setInt(2, carro.getAnoCarro());
            stmt.setString(3, carro.getCor());
            stmt.setString(4, carro.getMarca());
            stmt.setString(5, carro.getModelo());
            stmt.setString(6, carro.getChassi());
            stmt.setString(7, carro.getProprietario());
            stmt.setDate(8, new java.sql.Date(carro.getDataDaCompra().getTime()));
                    
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CarroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(stmt != null){
                ConnectionFactory.closeConnection(con,stmt);
            } else{
                ConnectionFactory.closeConnection(con);
            }
        }
    }
}
