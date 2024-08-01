package modelo;

/**
 * Clase que representa un producto en el sistema.
 * 
 * @author Raul
 */
public class Producto {
    /**
     * Identificador único del producto.
     */
    private String idProducto;
    
    /**
     * Nombre del producto.
     */
    private String nombreProducto;
    
    /**
     * Cantidad de unidades en stock.
     */
    private int cantidadStock;
    
    /**
     * Precio de venta del producto.
     */
    private double precioVentaProducto;

    /**
     * Constructor vacío de Producto.
     */
    public Producto() {
    }

    /**
     * Constructor de Producto con todos los parámetros.
     *
     * @param idProducto         Identificador único del producto.
     * @param nombreProducto     Nombre del producto.
     * @param cantidadStock      Cantidad de unidades en stock.
     * @param precioVentaProducto Precio de venta del producto.
     */
    public Producto(String idProducto, String nombreProducto, int cantidadStock, double precioVentaProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadStock = cantidadStock;
        this.precioVentaProducto = precioVentaProducto;
    }
    
    // Métodos getter y setter
    /**
     * Obtiene el identificador único del producto.
     *
     * @return El identificador único del producto.
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param idProducto El identificador único del producto.
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombreProducto El nombre del producto.
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * Obtiene la cantidad de unidades en stock.
     *
     * @return La cantidad de unidades en stock.
     */
    public int getCantidadStock() {
        return cantidadStock;
    }

    /**
     * Establece la cantidad de unidades en stock.
     *
     * @param cantidadStock La cantidad de unidades en stock.
     */
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    
    /**
     * Obtiene el precio de venta del producto.
     *
     * @return El precio de venta del producto.
     */
    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    /**
     * Establece el precio de venta del producto.
     *
     * @param precioVentaProducto El precio de venta del producto.
     */
    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }
    
}