package dao;

import model.Cliente;
import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public void insert(Cliente cliente) {

        String sql = "INSERT INTO Cliente (RazonSocial, NumTel, RFC, DirNum, DirCalle, DirCP, DirCol, ContNomPila, ContPrimApell, ContSegunApell, TC) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, cliente.getRazonSocial());
            ps.setString(2, cliente.getNumTel());
            ps.setString(3, cliente.getRfc());
            ps.setString(4, cliente.getDirNum());
            ps.setString(5, cliente.getDirCalle());
            ps.setInt(6, cliente.getCp());
            ps.setString(7, cliente.getDirColonia());
            ps.setString(8, cliente.getContNombrePila());
            ps.setString(9, cliente.getContPrimerApell());
            ps.setString(10, cliente.getContSegundApell());
            ps.setString(11, cliente.getTipoCliente());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar cliente", e);
        }
    }

    public Cliente getById(int numero) {

        String sql = "SELECT * FROM Cliente WHERE Numero = ?";

        try (Connection c = ConexionDB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, numero);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Cliente(
                        rs.getInt("Numero"),
                        rs.getString("RazonSocial"),
                        rs.getString("NumTel"),
                        rs.getString("RFC"),
                        rs.getString("DirNum"),
                        rs.getString("DirCalle"),
                        rs.getInt("DirCP"),
                        rs.getString("DirCol"),
                        rs.getString("ContNomPila"),
                        rs.getString("ContPrimApell"),
                        rs.getString("ContSegunApell"),
                        rs.getString("TC")
                    );
                }
            }

        } 
        catch (SQLException e) {
            throw new RuntimeException("Error al buscar cliente", e);
        }

        return null;
    }
}
