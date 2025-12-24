package model;

public class VentaProd {

    private int venta;
    private int producto;
    private int cantidad;
    private double importe;

    public VentaProd(int venta, int producto, int cantidad, double precioUnitario) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = cantidad * precioUnitario;
    }

    public VentaProd(int venta, int producto, int cantidad, double importe, boolean desdeBD) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    // Venta
    
    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    // Producto

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    // Cantidad

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Importe

    public double getImporte() {
        return importe;
    }
}
