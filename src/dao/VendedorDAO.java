package dao;

import model.Vendedor;
import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    public void insertar(Vendedor vendedor) {

        String sql = "INSERT INTO Vendedor (Numero, NombrePila, PrimerApell, SegundoApell, NumTel, Correo) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection c = ConexionDB.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, vendedor.getNumero());
            ps.setString(2, vendedor.getNombrePila());
            ps.setString(3, vendedor.getPrimerApell());
            ps.setString(4, vendedor.getSegundoApell());
            ps.setString(5, vendedor.getNumTel());
            ps.setString(6, vendedor.getCorreo());

            ps.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException("Error al insertar datos del vendedor.", e);
        }
    }

    public Vendedor getById (int numero) {

        String sql = "SELECT * FROM Vendedor WHERE Numero = ?";

        try(Connection c = ConexionDB.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, numero);

            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    return new Vendedor(
                      rs.getInt("Numero"),
                      rs.getString("NombrePila"),  
                      rs.getString("PrimerApell"),  
                      rs.getString("SegundoApell"),  
                      rs.getString("NumTel"),  
                      rs.getString("Correo")  
                    );
                }
            }
        }
        catch(SQLException e) {
            throw new RuntimeException("Error al buscar el vendedor.", e);
        }

        return null;
    }
}
