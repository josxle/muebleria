package model;

public class Vendedor {

    private int numero;
    private String nombrePila;
    private String primerApell;
    private String segundoApell;
    private String numTel;
    private String correo;

    public Vendedor (int numero, String nombrePila, String primerApell, String segundoApell, String numTel, String correo) {

        this.numero = numero;
        this.nombrePila = nombrePila;
        this.primerApell = primerApell;
        this.segundoApell = segundoApell;
        this.numTel = numTel;
        this.correo = correo;
    }

    // Número

    public int getNumero() {
        return numero;
    }

    // Nombre de pila

    public String getNombrePila() {
        return nombrePila;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    // Primer Apellido

    public String getPrimerApell() {
        return primerApell;
    }

    public void setPrimerApell(String primerApell) {
        this.primerApell = primerApell;
    }

    // Segundo Apellido

    public String getSegundoApell() {
        return segundoApell;
    }

    public void setSegundoApell(String segundoApell) {
        this.segundoApell = segundoApell;
    }

    // Número de teléfono

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    // Correo

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
