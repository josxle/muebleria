package model;

import java.sql.Timestamp;

public class Venta {
    
    private int folio;
    private Timestamp fecha;
    private double subtotal;
    private double iva;
    private double total;
    private int cantProd;
    private int cliente;
    private int vendedor;

    public Venta(int folio, Timestamp fecha, double subtotal, double iva, double total, int cantProd, int cliente, int vendedor) {

        this.folio = folio;
        this.fecha = fecha;
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.cantProd = cantProd;
        this.cliente = cliente;
        this.vendedor = vendedor;
    }

    // Folio

    public int getFolio() {
        return folio;
    }

    // Fecha

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    // Subtotal

    public double getSubtotal() {
        return subtotal;
    }
    
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    // IVA

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    // Total

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Cantidad de productos

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }

    // Cliente

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    // Vendedor

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }
}
