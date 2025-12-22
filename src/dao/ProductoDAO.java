package dao;

import model.Producto;
import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {
    
    public void insert(Producto producto) {

        String sql = "INSERT INTO Productos VALUES (?, ?, ?, ?, ?)";

        try(Connection c = ConexionDB.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecioUnitario());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getClasificacion());

            ps.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException("Error al insertar un producto.", e);
        }
    }

    public Producto GetByCode(int codigo) {
        
        String sql = "SELECT * FROM Productos WHERE Codigo = ?";

        try(Connection c = ConexionDB.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {
            
            ps.setInt(1, codigo);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    return new Producto(
                        rs.getInt("Codigo"),
                        rs.getString("Nombre"),
                        rs.getDouble("PU"),
                        rs.getInt("Stock"),
                        rs.getString("Clasif")
                    );
                }
            }
        }
        catch(SQLException e) {
            throw new RuntimeException("Error al buscar un producto.", e);
        }
        
        return null;
    }     
}
