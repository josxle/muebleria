package model;

public class Cliente {
    
    private int numero;
    private String razonSocial;
    private String numeroTelefono;
    private String rfc;
    private String dirNumero;
    private String dirCalle;
    private int dirCP;
    private String dirColonia;
    private String contNombrePila;
    private String contPrimerApell;
    private String contSegundoApell;
    private String tipoCliente;

    public Cliente (int numero, String razonSocial, String numeroTelefono, String rfc, String dirNumero, String dirCalle, int dirCP, String dirColonia, String contNombrePila, String contPrimerApell, String contSegundoApell, String tipoCliente) {
        
        this.numero = numero;
        this.razonSocial = razonSocial;
        setNumTel(numeroTelefono);
        this.rfc = rfc;
        this.dirNumero = dirNumero;
        this.dirCalle = dirCalle;
        setCp(dirCP);
        this.dirColonia = dirColonia;
        this.contNombrePila = contNombrePila;
        this.contPrimerApell = contPrimerApell;
        this.contSegundoApell = contSegundoApell;
        this.tipoCliente = tipoCliente;

    }

    // Número

    public int getNumero() {
        return numero;
    }

    // Razón Social

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    // Número de teléfono

    public String getNumTel() {
        return numeroTelefono;
    }

    public void setNumTel(String numeroTelefono) {

        if(numeroTelefono == null || numeroTelefono.isBlank()) {
            throw new IllegalArgumentException("El número de telefono es obligatorio");
        }

        this.numeroTelefono = numeroTelefono;
    }

    // RFC 

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    // Dirección Número calle

    public String getDirNum() {
        return dirNumero;
    }

    public void setDirNum(String dirNumero) {
        this.dirNumero = dirNumero;
    }

    // Dirección Calle

    public String getDirCalle() {
        return dirCalle;
    }

    public void setDirCalle(String dirCalle) {
        this.dirCalle = dirCalle;
    }

    // Dirección Código postal

    public int getCp() {
        return dirCP;
    }

    public void setCp(int dirCP) {

        if(dirCP <= 0) {
            throw new IllegalArgumentException("El código postal debe ser mayor a 0");
        }

        this.dirCP = dirCP;
    }

    // Dirección Colonia

    public String getDirColonia() {
        return dirColonia;
    }

    public void setDirColonia(String dirColonia) {
        this.dirColonia = dirColonia;
    }

    // Nombre de pila del contacto

    public String getContNombrePila() {
        return contNombrePila;
    }

    public void setContNombrePila(String contNombrePila) {
        this.contNombrePila = contNombrePila;
    }

    // Primer apellido del contacto

    public String getContPrimerApell() {
        return contPrimerApell;
    }

    public void setContPrimerApell(String contPrimerApell) {
        this.contPrimerApell = contPrimerApell;
    }

    // Segundo apellido del contacto

    public String getContSegundApell() {
        return contSegundoApell;
    }

    public void setSegundApell(String contSegundoApell) {
        this.contSegundoApell = contSegundoApell;
    }

    // Tipo de cliente

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}
