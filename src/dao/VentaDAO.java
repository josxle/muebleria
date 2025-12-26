package dao;

import model.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAO {

    public int insertar(Venta venta, Connection c) {

        String sql = """
            INSERT INTO Ventas (Fecha, Subtotal, IVA, Total, CantProd, Client, Vend)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (PreparedStatement ps =
                 c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setTimestamp(1, venta.getFecha());
            ps.setDouble(2, venta.getSubtotal());
            ps.setDouble(3, venta.getIva());
            ps.setDouble(4, venta.getTotal());
            ps.setInt(5, venta.getCantProd());
            ps.setInt(6, venta.getCliente());
            ps.setInt(7, venta.getVendedor());

            ps.executeUpdate(); //primero inserta

            // recuperar el folio
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

            throw new SQLException("No se generó el folio");

        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar venta", e);
        }
    }

    public Venta getById(int folio) {

        String sql = "SELECT * FROM Ventas WHERE Folio = ?";

        try (Connection c = util.ConexionDB.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, folio);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Venta(
                        rs.getInt("Folio"),
                        rs.getTimestamp("Fecha"),
                        rs.getDouble("Subtotal"),
                        rs.getDouble("IVA"),
                        rs.getDouble("Total"),
                        rs.getInt("CantProd"),
                        rs.getInt("Client"),
                        rs.getInt("Vend")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar la venta", e);
        }

        return null;
    }
}
