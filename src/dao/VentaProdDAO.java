package dao;

import model.VentaProd;
import util.ConexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VentaProdDAO {

    public void insertar(VentaProd ventaProd) {

        String sql = "INSERT INTO ventas_produc (Venta, Producto, Cantidad, Importe) VALUES (?, ?, ?, ?)";

        try(Connection c = ConexionDB.getConnection();
        PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, ventaProd.getVenta());
            ps.setInt(2, ventaProd.getProducto());
            ps.setInt(3, ventaProd.getCantidad());
            ps.setDouble(4, ventaProd.getImporte());

            ps.executeUpdate();
        }
        catch(SQLException e) {
            throw new RuntimeException("Error al insertar datos del venta y producto.", e);
        }
    }

    public List<VentaProd> getByVenta(int venta) {

        List<VentaProd> lista = new ArrayList<>();
        String sql = "SELECT * FROM ventas_produc WHERE Venta = ?";

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, venta);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new VentaProd(
                        rs.getInt("Venta"),
                        rs.getInt("Producto"),
                        rs.getInt("Cantidad"),
                        rs.getDouble("Importe"),
                        true
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener detalles de la venta.", e);
        }

        return lista;
    }

    
    public VentaProd getByVentaProducto(int venta, int producto) {

        String sql = "SELECT * FROM ventas_produc WHERE Venta = ? AND Producto = ?";

        try (Connection c = ConexionDB.getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, venta);
            ps.setInt(2, producto);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new VentaProd(
                        rs.getInt("Venta"),
                        rs.getInt("Producto"),
                        rs.getInt("Cantidad"),
                        rs.getDouble("Importe"),
                        true
                    );
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar detalle específico.", e);
        }

        return null;
    }
}
