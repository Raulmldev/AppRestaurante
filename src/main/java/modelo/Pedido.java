package modelo;

/**
 * Clase que representa un pedido en el sistema.
 * 
 * @author Raul
 */
public class Pedido {
    /**
     * Identificador del pedido.
     */
    private String idPedido;
    
    /**
     * Identificador del cliente asociado al pedido.
     */
    private Cliente idCliente;
    
    /**
     * Identificador del producto asociado al pedido.
     */
    private Producto idProducto;
    
    /**
     * Método de pago del pedido.
     */
    private String metodoPago;
    
    /**
     * Nombre del producto solicitado en el pedido.
     */
    private String nombreProductoSolicitado;
    
    /**
     * Cantidad del producto solicitado en el pedido.
     */
    private int cantidadProductoSolicitado;   
    
    /**
     * Total del ticket del pedido.
     */
    private double totalTicketPedido;

    /**
     * Constructor por defecto de la clase Pedido.
     */
    public Pedido() {
    }

    /**
     * Constructor con todos los parámetros de la clase Pedido.
     *
     * @param idPedido                   Identificador del pedido.
     * @param idCliente                  Identificador del cliente asociado al pedido.
     * @param idProducto                 Identificador del producto asociado al pedido.
     * @param metodoPago                 Método de pago del pedido.
     * @param nombreProductoSolicitado   Nombre del producto solicitado en el pedido.
     * @param cantidadProductoSolicitado Cantidad del producto solicitado en el pedido.
     * @param totalTicketPedido          Total del ticket del pedido.
     */
    public Pedido(String idPedido, Cliente idCliente, Producto idProducto, String metodoPago, String nombreProductoSolicitado,
            int cantidadProductoSolicitado, double totalTicketPedido) {
        
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.metodoPago = metodoPago;
        this.nombreProductoSolicitado = nombreProductoSolicitado;
        this.cantidadProductoSolicitado = cantidadProductoSolicitado;
        this.totalTicketPedido = totalTicketPedido;
    }

    // Métodos getters y setters
    /**
     * Obtiene el identificador del pedido.
     *
     * @return El identificador del pedido.
     */
    public String getIdPedido() {
        return idPedido;
    }

    /**
     * Establece el identificador del pedido.
     *
     * @param idPedido El identificador del pedido.
     */
    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * Obtiene el identificador del cliente asociado al pedido.
     *
     * @return El identificador del cliente asociado al pedido.
     */
    public Cliente getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador del cliente asociado al pedido.
     *
     * @param idCliente El identificador del cliente asociado al pedido.
     */
    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el identificador del producto asociado al pedido.
     *
     * @return El identificador del producto asociado al pedido.
     */
    public Producto getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el identificador del producto asociado al pedido.
     *
     * @param idProducto El identificador del producto asociado al pedido.
     */
    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Obtiene el método de pago del pedido.
     *
     * @return El método de pago del pedido.
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Establece el método de pago del pedido.
     *
     * @param metodoPago El método de pago del pedido.
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Obtiene el nombre del producto solicitado en el pedido.
     *
     * @return El nombre del producto solicitado en el pedido.
     */
    public String getNombreProductoSolicitado() {
        return nombreProductoSolicitado;
    }

    /**
     * Establece el nombre del producto solicitado en el pedido.
     *
     * @param nombreProductoSolicitado El nombre del producto solicitado en el pedido.
     */
    public void setNombreProductoSolicitado(String nombreProductoSolicitado) {
        this.nombreProductoSolicitado = nombreProductoSolicitado;
    }

    /**
     * Obtiene la cantidad del producto solicitado en el pedido.
     *
     * @return La cantidad del producto solicitado en el pedido.
     */
    public int getCantidadProductoSolicitado() {
        return cantidadProductoSolicitado;
    }

    /**
     * Establece la cantidad del producto solicitado en el pedido.
     *
     * @param cantidadProductoSolicitado La cantidad del producto solicitado en el pedido.
     */
    public void setCantidadProductoSolicitado(int cantidadProductoSolicitado) {
        this.cantidadProductoSolicitado = cantidadProductoSolicitado;
    }

    /**
     * Obtiene el total del ticket del pedido.
     *
     * @return El total del ticket del pedido.
     */
    public double getTotalTicketPedido() {
        return totalTicketPedido;
    }

    /**
     * Establece el total del ticket del pedido.
     *
     * @param totalTicketPedido El total del ticket del pedido.
     */
    public void setTotalTicketPedido(double totalTicketPedido) {
        this.totalTicketPedido = totalTicketPedido;
    }

}