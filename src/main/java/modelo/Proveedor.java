package modelo;

/**
 * Clase que representa un proveedor en el sistema.
 * 
 * @author Raul
 */
public class Proveedor {
    /**
     * Identificador único del proveedor.
     */
    private String idProveedor;

    /**
     * Producto suministrado por el proveedor.
     */
    private Producto idProducto;

    /**
     * Nombre del proveedor.
     */
    private String nombreProveedor;

    /**
     * Número de teléfono del proveedor.
     */
    private String telefonoProveedor;

    /**
     * Dirección de correo electrónico del proveedor.
     */
    private String emailProveedor;

    /**
     * Precio de compra del producto suministrado por el proveedor.
     */
    private double precioCompraProducto;

    /**
     * Cantidad de producto comprado al proveedor.
     */
    private int cantidadCompraProducto;

    /**
     * Constructor vacío de Proveedor.
     */
    public Proveedor() {
    }

    /**
     * Constructor de Proveedor con todos los parámetros.
     *
     * @param idProveedor           Identificador único del proveedor.
     * @param idProducto            Producto suministrado por el proveedor.
     * @param nombreProveedor       Nombre del proveedor.
     * @param telefonoProveedor     Número de teléfono del proveedor.
     * @param emailProveedor        Dirección de correo electrónico del proveedor.
     * @param precioCompraProducto  Precio de compra del producto suministrado por el proveedor.
     * @param cantidadCompraProducto Cantidad de producto comprado al proveedor.
     */
    public Proveedor(String idProveedor, Producto idProducto, String nombreProveedor, String telefonoProveedor, String emailProveedor,
            double precioCompraProducto, int cantidadCompraProducto) {
        this.idProveedor = idProveedor;
        this.idProducto = idProducto;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.precioCompraProducto = precioCompraProducto;
        this.cantidadCompraProducto = cantidadCompraProducto;
    }

    // Métodos getter y setter

    /**
     * Obtiene el identificador único del proveedor.
     *
     * @return El identificador único del proveedor.
     */
    public String getIdProveedor() {
        return idProveedor;
    }

    /**
     * Establece el identificador único del proveedor.
     *
     * @param idProveedor El identificador único del proveedor.
     */
    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * Obtiene el producto suministrado por el proveedor.
     *
     * @return El producto suministrado por el proveedor.
     */
    public Producto getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el producto suministrado por el proveedor.
     *
     * @param idProducto El producto suministrado por el proveedor.
     */
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return El nombre del proveedor.
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombreProveedor El nombre del proveedor.
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * Obtiene el número de teléfono del proveedor.
     *
     * @return El número de teléfono del proveedor.
     */
    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    /**
     * Establece el número de teléfono del proveedor.
     *
     * @param telefonoProveedor El número de teléfono del proveedor.
     */
    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    /**
     * Obtiene la dirección de correo electrónico del proveedor.
     *
     * @return La dirección de correo electrónico del proveedor.
     */
    public String getEmailProveedor() {
        return emailProveedor;
    }

    /**
     * Establece la dirección de correo electrónico del proveedor.
     *
     * @param emailProveedor La dirección de correo electrónico del proveedor.
     */
    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    /**
     * Obtiene el precio de compra del producto suministrado por el proveedor.
     *
     * @return El precio de compra del producto suministrado por el proveedor.
     */
    public double getPrecioCompraProducto() {
        return precioCompraProducto;
    }

    /**
     * Establece el precio de compra del producto suministrado por el proveedor.
     *
     * @param precioCompraProducto El precio de compra del producto suministrado por el proveedor.
     */
    public void setPrecioCompraProducto(double precioCompraProducto) {
        this.precioCompraProducto = precioCompraProducto;
    }

    /**
     * Obtiene la cantidad de producto comprado al proveedor.
     *
     * @return La cantidad de producto comprado al proveedor.
     */
    public int getCantidadCompraProducto() {
        return cantidadCompraProducto;
    }

    /**
     * Establece la cantidad de producto comprado al proveedor.
     *
     * @param cantidadCompraProducto La cantidad de producto comprado al proveedor.
     */
    public void setCantidadCompraProducto(int cantidadCompraProducto) {
        this.cantidadCompraProducto = cantidadCompraProducto;
    }

}