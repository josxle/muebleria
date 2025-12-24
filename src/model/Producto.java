package model;

public class Producto { // Clase
    
    private int codigo;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private String clasificacion;

    public Producto(int codigo, String nombre, double precioUnitario, int stock, String clasificacion) { // Constructor
        
        this.codigo = codigo;
        this.nombre = nombre;
        setPrecioUnitario(precioUnitario);
        setStock(stock);
        this.clasificacion = clasificacion;
    }

    /* GETTERS Y SETTERS */

    //Código

    public int getCodigo() {
        return codigo;
    }

    // Nombre

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Precio Unitario

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {

        if(precioUnitario <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0");
        }

        this.precioUnitario = precioUnitario;
    }

    // Stock

    public int getStock() {
        return stock;
    }

    public void setStock (int stock) {

        if(stock < 0) {
            throw new IllegalArgumentException("El stock debe ser mayor a 0");
        }

        this.stock = stock;
    }

    // Clasificación

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    // Cantidad

    public boolean hayStock(int cantidad) {
        return stock >= cantidad;
    }
}
