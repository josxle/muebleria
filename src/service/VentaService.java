package service;

import dao.VentaDAO;
import dao.VentaProdDAO;
import model.Venta;
import model.VentaProd;
import util.ConexionDB;

import java.sql.Connection;
import java.util.List;

public class VentaService {

    private VentaDAO ventaDAO = new VentaDAO();
    private VentaProdDAO ventaProdDAO = new VentaProdDAO();

    public void registrarVenta(Venta venta, List<VentaProd> detalles) {

        try (Connection c = ConexionDB.getConnection()) {

            c.setAutoCommit(false);

            ventaDAO.insertar(venta, c);

            for (VentaProd vp : detalles) {
                ventaProdDAO.insertar(vp, c);
            }

            c.commit();

        } catch (Exception e) {
            throw new RuntimeException("Error al registrar la venta", e);
        }
    }
}
