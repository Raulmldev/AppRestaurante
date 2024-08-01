package modelo;

/**
 * Clase que representa un detalle de pedido en el sistema.
 * 
 * @author Raul
 */
public class DetallePedido {
    private String idDetallePedido;
    private Cliente idCliente;
    private Pedido idPedido;
    private Empleado idEmpleado;
    private String descripcion;
  
    public DetallePedido() {
    }

    /**
     * Constructor con todos los parámetros de la clase DetallePedido.
     *
     * @param idDetallePedido Identificador del detalle de pedido.
     * @param idCliente       Identificador del cliente asociado al detalle de pedido.
     * @param idPedido        Identificador del pedido asociado al detalle de pedido.
     * @param descripcion     Descripción del detalle de pedido.
     * @param idEmpleado 
     */
    public DetallePedido(String idDetallePedido, Cliente idCliente, Pedido idPedido, Empleado idEmplead, String descripcion, Empleado idEmpleado) {
        this.idDetallePedido = idDetallePedido;
        this.idCliente = idCliente;
        this.idPedido = idPedido;
        this.idEmpleado = idEmpleado;
        this.descripcion = descripcion;
        
    }

    // Métodos getters y setters
    public String getIdDetallePedido() {
        return idDetallePedido;
    }

    public void setIdDetallePedido(String idDetallePedido) {
        this.idDetallePedido = idDetallePedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public Empleado getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Empleado idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
}